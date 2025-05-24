import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert.AlertType;

// Existing entity classes remain unchanged
class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    int itemno;
    int quantity;   
    float price;
    
    Food(int itemno, int quantity) {
        this.itemno = itemno;
        this.quantity = quantity;
        switch(itemno) {
            case 1: price = quantity * 50; break;
            case 2: price = quantity * 60; break;
            case 3: price = quantity * 70; break;
            case 4: price = quantity * 30; break;
            case 5: price = quantity * 80; break;
            case 6: price = quantity * 120; break;
            case 7: price = quantity * 150; break;
            case 8: price = quantity * 40; break;
        }
    }
}

class RoomService implements Serializable {
    private static final long serialVersionUID = 1L;
    private int serviceId;
    private String description;
    private Date requestTime;
    private Date completionTime;
    private boolean isCompleted;
    private float charge;
    
    public RoomService(int serviceId, String description, float charge) {
        this.serviceId = serviceId;
        this.description = description;
        this.requestTime = new Date();
        this.isCompleted = false;
        this.charge = charge;
    }
    
    public void completeService() {
        this.isCompleted = true;
        this.completionTime = new Date();
    }
    
    public int getServiceId() { return serviceId; }
    public String getDescription() { return description; }
    public Date getRequestTime() { return requestTime; }
    public Date getCompletionTime() { return completionTime; }
    public boolean isCompleted() { return isCompleted; }
    public float getCharge() { return charge; }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Service ID: " + serviceId + 
               "\nDescription: " + description + 
               "\nRequested: " + sdf.format(requestTime) + 
               "\nStatus: " + (isCompleted ? "Completed at " + sdf.format(completionTime) : "Pending") +
               "\nCharge: $" + charge;
    }
}

class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID reviewId;
    private String guestName;
    private int rating;
    private String comment;
    private Date reviewDate;
    
    public Review(String guestName, int rating, String comment) {
        this.reviewId = UUID.randomUUID();
        this.guestName = guestName;
        this.rating = Math.max(1, Math.min(5, rating));
        this.comment = comment;
        this.reviewDate = new Date();
    }
    
    public UUID getReviewId() { return reviewId; }
    public String getGuestName() { return guestName; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public Date getReviewDate() { return reviewDate; }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Rating: " + "★".repeat(rating) + " ".repeat(5-rating) +
               "\nBy: " + guestName + " on " + sdf.format(reviewDate) +
               "\nComment: " + comment;
    }
}

class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID bookingId;
    private int roomNumber;
    private int roomType;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean isActive;
    private double totalAmount;
    private String guestId;
    
    public Booking(int roomNumber, int roomType, String guestId) {
        this.bookingId = UUID.randomUUID();
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.checkInDate = new Date();
        this.isActive = true;
        this.guestId = guestId;
    }
    
    public void checkout(double amount) {
        this.checkOutDate = new Date();
        this.isActive = false;
        this.totalAmount = amount;
    }
    
    public UUID getBookingId() { return bookingId; }
    public int getRoomNumber() { return roomNumber; }
    public int getRoomType() { return roomType; }
    public Date getCheckInDate() { return checkInDate; }
    public Date getCheckOutDate() { return checkOutDate; }
    public boolean isActive() { return isActive; }
    public double getTotalAmount() { return totalAmount; }
    public String getGuestId() { return guestId; }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String roomTypeStr = "";
        switch(roomType) {
            case 1: roomTypeStr = "Luxury Double Room"; break;
            case 2: roomTypeStr = "Deluxe Double Room"; break;
            case 3: roomTypeStr = "Luxury Single Room"; break;
            case 4: roomTypeStr = "Deluxe Single Room"; break;
        }
        
        return "Booking ID: " + bookingId +
               "\nRoom Number: " + roomNumber +
               "\nRoom Type: " + roomTypeStr +
               "\nCheck-in: " + sdf.format(checkInDate) +
               "\nCheck-out: " + (checkOutDate != null ? sdf.format(checkOutDate) : "Not checked out yet") +
               "\nStatus: " + (isActive ? "Active" : "Completed") +
               (isActive ? "" : "\nTotal Amount: $" + totalAmount);
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String password;
    private String name;
    private String contact;
    private String email;
    private boolean isAdmin;
    private List<Booking> bookingHistory;
    private int loyaltyPoints; 
    public User(String userId, String password, String name, String contact, String email, boolean isAdmin) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.isAdmin = isAdmin;
        this.bookingHistory = new ArrayList<>();
        this.loyaltyPoints = 0;
    }
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
        loyaltyPoints += 10;
    }
    public void completeBooking(UUID bookingId, double amount) {
        for(Booking booking : bookingHistory) {
            if(booking.getBookingId().equals(bookingId)) {
                booking.checkout(amount);
                loyaltyPoints += (int)(amount / 100);
                break;
            }
        }
    }
    public int calculateDiscount() {
        if(loyaltyPoints >= 500) return 15;
        if(loyaltyPoints >= 300) return 10;
        if(loyaltyPoints >= 100) return 5;
        return 0;
    }
    public String getUserId() { return userId; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getContact() { return contact; }
    public String getEmail() { return email; }
    public boolean isAdmin() { return isAdmin; }
    public List<Booking> getBookingHistory() { return bookingHistory; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    @Override
    public String toString() {
        return "User ID: " + userId +
               "\nName: " + name +
               "\nContact: " + contact +
               "\nEmail: " + email +
               "\nRole: " + (isAdmin ? "Admin" : "Guest") +
               "\nLoyalty Points: " + loyaltyPoints +
               "\nDiscount Eligible: " + calculateDiscount() + "%";
    }
}

class Singleroom implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String contact;
    String gender;   
    String guestId;
    ArrayList<Food> food = new ArrayList<>();
    ArrayList<RoomService> services = new ArrayList<>();
    Date checkInDate;
    
    Singleroom() {
        this.name = "";
    }
    
    Singleroom(String name, String contact, String gender, String guestId) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.guestId = guestId;
        this.checkInDate = new Date();
    }
    
    public void requestService(String description, float charge) {
        int serviceId = services.size() + 1;
        services.add(new RoomService(serviceId, description, charge));
    }
    
    public void completeService(int serviceId) {
        for(RoomService service : services) {
            if(service.getServiceId() == serviceId) {
                service.completeService();
                break;
            }
        }
    }
}

class Doubleroom extends Singleroom implements Serializable {
    private static final long serialVersionUID = 1L;
    String name2;
    String contact2;
    String gender2;  
    
    Doubleroom() {
        this.name = "";
        this.name2 = "";
    }
    
    Doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2, String guestId) {
        super(name, contact, gender, guestId);
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}

class NotAvailable extends Exception {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return "Not Available!";
    }
}

class InvalidInputException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InvalidInputException(String message) {
        super(message);
    }
    
    @Override
    public String toString() {
        return getMessage();
    }
}

class holder implements Serializable {
    private static final long serialVersionUID = 1L;
    Doubleroom luxury_doublerrom[] = new Doubleroom[10];
    Doubleroom deluxe_doublerrom[] = new Doubleroom[20];
    Singleroom luxury_singleerrom[] = new Singleroom[10];
    Singleroom deluxe_singleerrom[] = new Singleroom[20];
    Map<String, User> users = new HashMap<>();
    List<Review> reviews = new ArrayList<>();
    
    public void addReview(Review review) {
        reviews.add(review);
    }
    
    public List<Review> getReviews() {
        return reviews;
    }
    
    public double calculateAverageRating() {
        if(reviews.isEmpty()) return 0;
        
        int sum = 0;
        for(Review review : reviews) {
            sum += review.getRating();
        }
        return (double) sum / reviews.size();
    }
}

// Modified Hotel class with GUI-adapted methods
class Hotel {
    private static final Logger logger = Logger.getLogger(Hotel.class.getName());
    static holder hotel_ob = new holder();
    static User currentUser = null;
    
    static boolean login(String userId, String password) {
        User user = hotel_ob.users.get(userId);
        if(user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }
    
    static void register(String userId, String password, String name, String contact, String email, boolean isAdmin) {
        if(!hotel_ob.users.containsKey(userId)) {
            User newUser = new User(userId, password, name, contact, email, isAdmin);
            hotel_ob.users.put(userId, newUser);
        }
    }
    
    static void CustDetails(int i, int rn, String gender, String name2, String contact2, String gender2) throws InvalidInputException {
        if(currentUser == null) {
            throw new InvalidInputException("You need to login first!");
        }
        
        String name = currentUser.getName();
        String contact = currentUser.getContact();
        
        Booking booking = new Booking(i == 1 ? rn + 1 : (i == 2 ? rn + 11 : (i == 3 ? rn + 31 : rn + 41)), i, currentUser.getUserId());
        currentUser.addBooking(booking);
        
        switch (i) {
            case 1:
                hotel_ob.luxury_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2, currentUser.getUserId());
                break;
            case 2:
                hotel_ob.deluxe_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2, currentUser.getUserId());
                break;
            case 3:
                hotel_ob.luxury_singleerrom[rn] = new Singleroom(name, contact, gender, currentUser.getUserId());
                break;
            case 4:
                hotel_ob.deluxe_singleerrom[rn] = new Singleroom(name, contact, gender, currentUser.getUserId());
                break;
        }
    }
    
    static String bookRoom(int i, int rn, String gender, String name2, String contact2, String gender2) {
        try {
            if(currentUser == null) {
                return "You need to login first!";
            }
            
            int arrayIndex;
            int discount = currentUser.calculateDiscount();
            String discountMessage = "";
            switch (i) {
                case 1:
                    arrayIndex = rn - 1;
                    if(arrayIndex < 0 || arrayIndex >= hotel_ob.luxury_doublerrom.length)
                        return "Room number out of range";
                    if(hotel_ob.luxury_doublerrom[arrayIndex] != null)
                        return "Not Available!";
                    if(discount > 0) {
                        discountMessage = "Discount: " + discount + "% applied\nStandard rate: $4000\nYour rate: $" + (4000 - (4000 * discount / 100));
                    }
                    CustDetails(i, arrayIndex, gender, name2, contact2, gender2);
                    break;
                case 2:
                    arrayIndex = rn - 11;
                    if(arrayIndex < 0 || arrayIndex >= hotel_ob.deluxe_doublerrom.length)
                        return "Room number out of range";
                    if(hotel_ob.deluxe_doublerrom[arrayIndex] != null)
                        return "Not Available!";
                    if(discount > 0) {
                        discountMessage = "Discount: " + discount + "% applied\nStandard rate: $3000\nYour rate: $" + (3000 - (3000 * discount / 100));
                    }
                    CustDetails(i, arrayIndex, gender, name2, contact2, gender2);
                    break;
                case 3:
                    arrayIndex = rn - 31;
                    if(arrayIndex < 0 || arrayIndex >= hotel_ob.luxury_singleerrom.length)
                        return "Room number out of range";
                    if(hotel_ob.luxury_singleerrom[arrayIndex] != null)
                        return "Not Available!";
                    if(discount > 0) {
                        discountMessage = "Discount: " + discount + "% applied\nStandard rate: $2200\nYour rate: $" + (2200 - (2200 * discount / 100));
                    }
                    CustDetails(i, arrayIndex, gender, null, null, null);
                    break;
                case 4:
                    arrayIndex = rn - 41;
                    if(arrayIndex < 0 || arrayIndex >= hotel_ob.deluxe_singleerrom.length)
                        return "Room number out of range";
                    if(hotel_ob.deluxe_singleerrom[arrayIndex] != null)
                        return "Not Available!";
                    if(discount > 0) {
                        discountMessage = "Discount: " + discount + "% applied\nStandard rate: $1200\nYour rate: $" + (1200 - (1200 * discount / 100));
                    }
                    CustDetails(i, arrayIndex, gender, null, null, null);
                    break;
                default:
                    return "Invalid room type";
            }
            return "Room Booked Successfully!\n" + discountMessage;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    static String getFeatures(int i) {
        StringBuilder sb = new StringBuilder();
        switch (i) {
            case 1:
                sb.append("Room Type: Luxury Double Room\nNumber of double beds: 1\nAC: Yes\nFree breakfast: Yes\nWi-Fi: High-speed Premium\nRoom service: 24/7\nCharge per day: $4000");
                break;
            case 2:
                sb.append("Room Type: Deluxe Double Room\nNumber of double beds: 1\nAC: No\nFree breakfast: Yes\nWi-Fi: Standard\nRoom service: 12 hours\nCharge per day: $3000");
                break;
            case 3:
                sb.append("Room Type: Luxury Single Room\nNumber of single beds: 1\nAC: Yes\nFree breakfast: Yes\nWi-Fi: High-speed\nRoom service: 24/7\nCharge per day: $2200");
                break;
            case 4:
                sb.append("Room Type: Deluxe Single Room\nNumber of single beds: 1\nAC: No\nFree breakfast: Yes\nWi-Fi: Standard\nRoom service: Limited hours\nCharge per day: $1200");
                break;
            default:
                sb.append("Invalid option");
        }
        return sb.toString();
    }
    
    static String getAvailability(int i) {
        int count = 0;
        switch (i) {
            case 1:
                for(Doubleroom room : hotel_ob.luxury_doublerrom) {
                    if(room == null) count++;
                }
                break;
            case 2:
                for(Doubleroom room : hotel_ob.deluxe_doublerrom) {
                    if(room == null) count++;
                }
                break;
            case 3:
                for(Singleroom room : hotel_ob.luxury_singleerrom) {
                    if(room == null) count++;
                }
                break;
            case 4:
                for(Singleroom room : hotel_ob.deluxe_singleerrom) {
                    if(room == null) count++;
                }
                break;
            default:
                return "Invalid option";
        }
        return "Number of rooms available: " + count;
    }
    
    static List<Integer> getAvailableRoomNumbers(int i) {
        List<Integer> available = new ArrayList<>();
        switch (i) {
            case 1:
                for(int j = 0; j < hotel_ob.luxury_doublerrom.length; j++) {
                    if(hotel_ob.luxury_doublerrom[j] == null) available.add(j + 1);
                }
                break;
            case 2:
                for(int j = 0; j < hotel_ob.deluxe_doublerrom.length; j++) {
                    if(hotel_ob.deluxe_doublerrom[j] == null) available.add(j + 11);
                }
                break;
            case 3:
                for(int j = 0; j < hotel_ob.luxury_singleerrom.length; j++) {
                    if(hotel_ob.luxury_singleerrom[j] == null) available.add(j + 31);
                }
                break;
            case 4:
                for(int j = 0; j < hotel_ob.deluxe_singleerrom.length; j++) {
                    if(hotel_ob.deluxe_singleerrom[j] == null) available.add(j + 41);
                }
                break;
        }
        return available;
    }
    
    static String searchRoom(int choice, int subChoice, int minPrice, int maxPrice, int amenity) {
        StringBuilder sb = new StringBuilder();
        switch(choice) {
            case 1:
                if(subChoice >= 1 && subChoice <= 4) {
                    sb.append(getFeatures(subChoice)).append("\n").append(getAvailability(subChoice));
                } else {
                    sb.append("Invalid room type");
                }
                break;
            case 2:
                sb.append("Rooms available in price range $").append(minPrice).append(" - $").append(maxPrice).append(":\n");
                if(1200 >= minPrice && 1200 <= maxPrice) {
                    sb.append("Deluxe Single Room - $1200 per night\n").append(getAvailability(4)).append("\n");
                }
                if(2200 >= minPrice && 2200 <= maxPrice) {
                    sb.append("Luxury Single Room - $2200 per night\n").append(getAvailability(3)).append("\n");
                }
                if(3000 >= minPrice && 3000 <= maxPrice) {
                    sb.append("Deluxe Double Room - $3000 per night\n").append(getAvailability(2)).append("\n");
                }
                if(4000 >= minPrice && 4000 <= maxPrice) {
                    sb.append("Luxury Double Room - $4000 per night\n").append(getAvailability(1)).append("\n");
                }
                break;
            case 3:
                switch(amenity) {
                    case 1:
                        sb.append("Rooms with AC:\n1. Luxury Double Room - $4000 per night\n").append(getAvailability(1))
                          .append("\n3. Luxury Single Room - $2200 per night\n").append(getAvailability(3));
                        break;
                    case 2:
                        sb.append("Rooms with Premium Wi-Fi:\n1. Luxury Double Room - $4000 per night\n").append(getAvailability(1));
                        break;
                    case 3:
                        sb.append("Rooms with 24/7 Room Service:\n1. Luxury Double Room - $4000 per night\n").append(getAvailability(1))
                          .append("\n3. Luxury Single Room - $2200 per night\n").append(getAvailability(3));
                        break;
                    default:
                        sb.append("Invalid amenity option");
                }
                break;
            default:
                sb.append("Invalid search option");
        }
        return sb.toString();
    }
    
    static String generateBill(int rn, int rtype, int paymentMethod) {
        try {
            double amount = 0;
            String[] list = {"Sandwich", "Pasta", "Noodles", "Coke", "Pizza", "Burger", "Steak", "Water"};
            StringBuilder sb = new StringBuilder("*******\n Bill:-\n*******\n");
            
            int discount = currentUser != null ? currentUser.calculateDiscount() : 0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date checkoutDate = new Date();
            Date checkinDate = null;
            long stayDuration = 1;
            
            switch(rtype) {
                case 1: checkinDate = hotel_ob.luxury_doublerrom[rn].checkInDate; break;
                case 2: checkinDate = hotel_ob.deluxe_doublerrom[rn].checkInDate; break;
                case 3: checkinDate = hotel_ob.luxury_singleerrom[rn].checkInDate; break;
                case 4: checkinDate = hotel_ob.deluxe_singleerrom[rn].checkInDate; break;
            }
            
            if(checkinDate != null) {
                stayDuration = (checkoutDate.getTime() - checkinDate.getTime()) / (1000 * 60 * 60 * 24);
                if(stayDuration < 1) stayDuration = 1;
            }
            
            sb.append("\nCheck-in Date: ").append(sdf.format(checkinDate))
              .append("\nCheck-out Date: ").append(sdf.format(checkoutDate))
              .append("\nStay Duration: ").append(stayDuration).append(" day(s)");
            
            switch(rtype) {
                case 1:
                    double roomCharge = 4000 * stayDuration;
                    amount += roomCharge;
                    sb.append("\n\nRoom Charge - $").append(roomCharge).append(" ($4000 x ").append(stayDuration).append(" days)")
                      .append("\n===============\nFood Charges:-\n===============\nItem     Quantity    Price\n-------------------------");
                    for(Food obb : hotel_ob.luxury_doublerrom[rn].food) {
                        amount += obb.price;
                        sb.append(String.format("\n%-10s%-10s%-10s", list[obb.itemno-1], obb.quantity, obb.price));
                    }
                    if(!hotel_ob.luxury_doublerrom[rn].services.isEmpty()) {
                        sb.append("\n\n===============\nRoom Services:-\n===============\nService              Charge\n-------------------------");
                        for(RoomService service : hotel_ob.luxury_doublerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                sb.append(String.format("\n%-20s%-10s", service.getDescription(), service.getCharge()));
                            }
                        }
                    }
                    break;
                case 2:
                    roomCharge = 3000 * stayDuration;
                    amount += roomCharge;
                    sb.append("\n\nRoom Charge - $").append(roomCharge).append(" ($3000 x ").append(stayDuration).append(" days)")
                      .append("\n===============\nFood Charges:-\n===============\nItem     Quantity    Price\n-------------------------");
                    for(Food obb : hotel_ob.deluxe_doublerrom[rn].food) {
                        amount += obb.price;
                        sb.append(String.format("\n%-10s%-10s%-10s", list[obb.itemno-1], obb.quantity, obb.price));
                    }
                    if(!hotel_ob.deluxe_doublerrom[rn].services.isEmpty()) {
                        sb.append("\n\n===============\nRoom Services:-\n===============\nService              Charge\n-------------------------");
                        for(RoomService service : hotel_ob.deluxe_doublerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                sb.append(String.format("\n%-20s%-10s", service.getDescription(), service.getCharge()));
                            }
                        }
                    }
                    break;
                case 3:
                    roomCharge = 2200 * stayDuration;
                    amount += roomCharge;
                    sb.append("\n\nRoom Charge - $").append(roomCharge).append(" ($2200 x ").append(stayDuration).append(" days)")
                      .append("\n===============\nFood Charges:-\n===============\nItem     Quantity    Price\n-------------------------");
                    for(Food obb : hotel_ob.luxury_singleerrom[rn].food) {
                        amount += obb.price;
                        sb.append(String.format("\n%-10s%-10s%-10s", list[obb.itemno-1], obb.quantity, obb.price));
                    }
                    if(!hotel_ob.luxury_singleerrom[rn].services.isEmpty()) {
                        sb.append("\n\n===============\nRoom Services:-\n===============\nService              Charge\n-------------------------");
                        for(RoomService service : hotel_ob.luxury_singleerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                sb.append(String.format("\n%-20s%-10s", service.getDescription(), service.getCharge()));
                            }
                        }
                    }
                    break;
                case 4:
                    roomCharge = 1200 * stayDuration;
                    amount += roomCharge;
                    sb.append("\n\nRoom Charge - $").append(roomCharge).append(" ($1200 x ").append(stayDuration).append(" days)")
                      .append("\n===============\nFood Charges:-\n===============\nItem     Quantity    Price\n-------------------------");
                    for(Food obb : hotel_ob.deluxe_singleerrom[rn].food) {
                        amount += obb.price;
                        sb.append(String.format("\n%-10s%-10s%-10s", list[obb.itemno-1], obb.quantity, obb.price));
                    }
                    if(!hotel_ob.deluxe_singleerrom[rn].services.isEmpty()) {
                        sb.append("\n\n===============\nRoom Services:-\n===============\nService              Charge\n-------------------------");
                        for(RoomService service : hotel_ob.deluxe_singleerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                sb.append(String.format("\n%-20s%-10s", service.getDescription(), service.getCharge()));
                            }
                        }
                    }
                    break;
            }
            
            double finalAmount = amount;
            if(discount > 0) {
                double discountAmount = amount * discount / 100;
                finalAmount -= discountAmount;
                sb.append("\n\nSubtotal Amount: $").append(amount)
                  .append("\nLoyalty Discount (").append(discount).append("%): -$").append(discountAmount);
            }
            
            sb.append("\n\nFinal Amount: $").append(finalAmount);
            
            String paymentMethodStr = "";
            switch(paymentMethod) {
                case 1: paymentMethodStr = "Cash"; break;
                case 2: paymentMethodStr = "Credit Card"; break;
                case 3: paymentMethodStr = "Debit Card"; break;
                case 4: paymentMethodStr = "Mobile Payment"; break;
                default: paymentMethodStr = "Unknown";
            }
            
            sb.append("\n\nPayment processed via ").append(paymentMethodStr)
              .append("\nThank you for staying with us!");
            
            if(currentUser != null) {
                String guestId = "";
                switch (rtype) {
                    case 1: guestId = hotel_ob.luxury_doublerrom[rn].guestId; break;
                    case 2: guestId = hotel_ob.deluxe_doublerrom[rn].guestId; break;
                    case 3: guestId = hotel_ob.luxury_singleerrom[rn].guestId; break;
                    case 4: guestId = hotel_ob.deluxe_singleerrom[rn].guestId; break;
                }
                for(Booking booking : currentUser.getBookingHistory()) {
                    if(booking.isActive() && booking.getRoomType() == rtype) {
                        booking.checkout(finalAmount);
                        break;
                    }
                }
            }
            
            return sb.toString();
        } catch (Exception e) {
            return "Error generating bill: " + e.getMessage();
        }
    }
    
    static String deallocate(int rn, int rtype, int paymentMethod, int rating, String comment) {
        try {
            StringBuilder sb = new StringBuilder();
            switch (rtype) {
                case 1:
                    if(hotel_ob.luxury_doublerrom[rn] == null) {
                        return "Empty Already";
                    }
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.luxury_doublerrom[rn].guestId)) {
                        return "You don't have permission to check out this room.";
                    }
                    sb.append("Room used by ").append(hotel_ob.luxury_doublerrom[rn].name).append("\n");
                    sb.append(generateBill(rn, rtype, paymentMethod));
                    if(rating > 0) {
                        Review review = new Review(currentUser != null ? currentUser.getName() : "Anonymous", rating, comment);
                        hotel_ob.addReview(review);
                        sb.append("\n\nThank you for your feedback!");
                    }
                    hotel_ob.luxury_doublerrom[rn] = null;
                    sb.append("\nDeallocated successfully");
                    break;
                case 2:
                    if(hotel_ob.deluxe_doublerrom[rn] == null) {
                        return "Empty Already";
                    }
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.deluxe_doublerrom[rn].guestId)) {
                        return "You don't have permission to check out this room.";
                    }
                    sb.append("Room used by ").append(hotel_ob.deluxe_doublerrom[rn].name).append("\n");
                    sb.append(generateBill(rn, rtype, paymentMethod));
                    if(rating > 0) {
                        Review review = new Review(currentUser != null ? currentUser.getName() : "Anonymous", rating, comment);
                        hotel_ob.addReview(review);
                        sb.append("\n\nThank you for your feedback!");
                    }
                    hotel_ob.deluxe_doublerrom[rn] = null;
                    sb.append("\nDeallocated successfully");
                    break;
                case 3:
                    if(hotel_ob.luxury_singleerrom[rn] == null) {
                        return "Empty Already";
                    }
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.luxury_singleerrom[rn].guestId)) {
                        return "You don't have permission to check out this room.";
                    }
                    sb.append("Room used by ").append(hotel_ob.luxury_singleerrom[rn].name).append("\n");
                    sb.append(generateBill(rn, rtype, paymentMethod));
                    if(rating > 0) {
                        Review review = new Review(currentUser != null ? currentUser.getName() : "Anonymous", rating, comment);
                        hotel_ob.addReview(review);
                        sb.append("\n\nThank you for your feedback!");
                    }
                    hotel_ob.luxury_singleerrom[rn] = null;
                    sb.append("\nDeallocated successfully");
                    break;
                case 4:
                    if(hotel_ob.deluxe_singleerrom[rn] == null) {
                        return "Empty Already";
                    }
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.deluxe_singleerrom[rn].guestId)) {
                        return "You don't have permission to check out this room.";
                    }
                    sb.append("Room used by ").append(hotel_ob.deluxe_singleerrom[rn].name).append("\n");
                    sb.append(generateBill(rn, rtype, paymentMethod));
                    if(rating > 0) {
                        Review review = new Review(currentUser != null ? currentUser.getName() : "Anonymous", rating, comment);
                        hotel_ob.addReview(review);
                        sb.append("\n\nThank you for your feedback!");
                    }
                    hotel_ob.deluxe_singleerrom[rn] = null;
                    sb.append("\nDeallocated successfully");
                    break;
                default:
                    return "Invalid option";
            }
            return sb.toString();
        } catch (Exception e) {
            return "Error during checkout: " + e.getMessage();
        }
    }
    
    static String order(int rn, int rtype, List<Food> orders) {
        try {
            switch(rtype) {
                case 1: 
                    if(hotel_ob.luxury_doublerrom[rn] == null) return "Room not booked";
                    hotel_ob.luxury_doublerrom[rn].food.addAll(orders); 
                    break;
                case 2: 
                    if(hotel_ob.deluxe_doublerrom[rn] == null) return "Room not booked";
                    hotel_ob.deluxe_doublerrom[rn].food.addAll(orders); 
                    break;
                case 3: 
                    if(hotel_ob.luxury_singleerrom[rn] == null) return "Room not booked";
                    hotel_ob.luxury_singleerrom[rn].food.addAll(orders); 
                    break;
                case 4: 
                    if(hotel_ob.deluxe_singleerrom[rn] == null) return "Room not booked";
                    hotel_ob.deluxe_singleerrom[rn].food.addAll(orders); 
                    break;
                default:
                    return "Invalid room type";
            }
            return "Thank you for your order!\nYour food will be delivered to your room shortly.";
        } catch (Exception e) {
            return "Error processing food order: " + e.getMessage();
        }
    }
    
    static String requestRoomService(int rn, int rtype, String description, float charge) {
        try {
            if(currentUser == null) {
                return "You need to login first!";
            }
            switch(rtype) {
                case 1: 
                    if(hotel_ob.luxury_doublerrom[rn] == null) return "Room not booked";
                    hotel_ob.luxury_doublerrom[rn].requestService(description, charge); 
                    break;
                case 2: 
                    if(hotel_ob.deluxe_doublerrom[rn] == null) return "Room not booked";
                    hotel_ob.deluxe_doublerrom[rn].requestService(description, charge); 
                    break;
                case 3: 
                    if(hotel_ob.luxury_singleerrom[rn] == null) return "Room not booked";
                    hotel_ob.luxury_singleerrom[rn].requestService(description, charge); 
                    break;
                case 4: 
                    if(hotel_ob.deluxe_singleerrom[rn] == null) return "Room not booked";
                    hotel_ob.deluxe_singleerrom[rn].requestService(description, charge); 
                    break;
                default:
                    return "Invalid room type";
            }
            return "Room service request submitted successfully!\nService: " + description + "\nCharge: $" + charge;
        } catch (Exception e) {
            return "Error requesting room service: " + e.getMessage();
        }
    }
    
    static String completeRoomService(int rn, int rtype, int serviceId) {
        try {
            if(currentUser == null || !currentUser.isAdmin()) {
                return "Only administrators can mark services as complete!";
            }
            ArrayList<RoomService> services = null;
            switch(rtype) {
                case 1: if(hotel_ob.luxury_doublerrom[rn] != null) services = hotel_ob.luxury_doublerrom[rn].services; break;
                case 2: if(hotel_ob.deluxe_doublerrom[rn] != null) services = hotel_ob.deluxe_doublerrom[rn].services; break;
                case 3: if(hotel_ob.luxury_singleerrom[rn] != null) services = hotel_ob.luxury_singleerrom[rn].services; break;
                case 4: if(hotel_ob.deluxe_singleerrom[rn] != null) services = hotel_ob.deluxe_singleerrom[rn].services; break;
            }
            if(services == null || services.isEmpty()) {
                return "No room service requests for this room.";
            }
            for(RoomService service : services) {
                if(service.getServiceId() == serviceId && !service.isCompleted()) {
                    service.completeService();
                    return "Service marked as complete!";
                }
            }
            return "Invalid service ID or service already completed.";
        } catch (Exception e) {
            return "Error completing room service: " + e.getMessage();
        }
    }
    
    static String getBookingHistory() {
        if(currentUser == null) {
            return "You need to login first!";
        }
        List<Booking> bookings = currentUser.getBookingHistory();
        if(bookings.isEmpty()) {
            return "No booking history found.";
        }
        StringBuilder sb = new StringBuilder("====================\n  Booking History  \n====================\n");
        for(Booking booking : bookings) {
            sb.append("\n").append(booking);
        }
        return sb.toString();
    }
    
    static String getAccountDetails(int choice) {
        if(currentUser == null) {
            return "You need to login first!";
        }
        switch(choice) {
            case 1: return currentUser.toString();
            case 2: return getBookingHistory();
            case 3: 
                return "Loyalty Program\nPoints: " + currentUser.getLoyaltyPoints() +
                       "\nCurrent Discount: " + currentUser.calculateDiscount() + "%\n\nDiscount Tiers:\n" +
                       "100+ points: 5% discount\n300+ points: 10% discount\n500+ points: 15% discount";
            case 4:
                if(hotel_ob.getReviews().isEmpty()) {
                    return "No reviews available.";
                }
                StringBuilder sb = new StringBuilder("Hotel Reviews\nAverage Rating: " + String.format("%.1f", hotel_ob.calculateAverageRating()) + "/5");
                for(Review review : hotel_ob.getReviews()) {
                    sb.append("\n\n").append(review);
                }
                return sb.toString();
            default: return "Invalid choice";
        }
    }
    
    static String getAdminPanelDetails(int choice, int roomNum, int serviceId) {
        if(currentUser == null || !currentUser.isAdmin()) {
            return "Access denied. Admin privileges required.";
        }
        switch(choice) {
            case 1: return getAllRoomsStatus();
            case 2: return getAllUsers();
            case 3:
                if(roomNum > 60 || roomNum < 1) return "Room doesn't exist";
                else if(roomNum > 40) return completeRoomService(roomNum - 41, 4, serviceId);
                else if(roomNum > 30) return completeRoomService(roomNum - 31, 3, serviceId);
                else if(roomNum > 10) return completeRoomService(roomNum - 11, 2, serviceId);
                else return completeRoomService(roomNum - 1, 1, serviceId);
            case 4: return getHotelAnalytics();
            default: return "Invalid choice";
        }
    }
    
    static String getAllRoomsStatus() {
        StringBuilder sb = new StringBuilder("====================\n   All Rooms Status  \n====================\n");
        sb.append("\nLuxury Double Rooms:");
        for(int i = 0; i < hotel_ob.luxury_doublerrom.length; i++) {
            sb.append("\nRoom ").append(i + 1).append(": ");
            sb.append(hotel_ob.luxury_doublerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.luxury_doublerrom[i].name);
        }
        sb.append("\n\nDeluxe Double Rooms:");
        for(int i = 0; i < hotel_ob.deluxe_doublerrom.length; i++) {
            sb.append("\nRoom ").append(i + 11).append(": ");
            sb.append(hotel_ob.deluxe_doublerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.deluxe_doublerrom[i].name);
        }
        sb.append("\n\nLuxury Single Rooms:");
        for(int i = 0; i < hotel_ob.luxury_singleerrom.length; i++) {
            sb.append("\nRoom ").append(i + 31).append(": ");
            sb.append(hotel_ob.luxury_singleerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.luxury_singleerrom[i].name);
        }
        sb.append("\n\nDeluxe Single Rooms:");
        for(int i = 0; i < hotel_ob.deluxe_singleerrom.length; i++) {
            sb.append("\nRoom ").append(i + 41).append(": ");
            sb.append(hotel_ob.deluxe_singleerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.deluxe_singleerrom[i].name);
        }
        return sb.toString();
    }
    
    static String getAllUsers() {
        if(hotel_ob.users.isEmpty()) {
            return "No users registered.";
        }
        StringBuilder sb = new StringBuilder("====================\n   All Users  \n====================\n");
        for(User user : hotel_ob.users.values()) {
            sb.append("\nUser ID: ").append(user.getUserId())
              .append("\nName: ").append(user.getName())
              .append("\nContact: ").append(user.getContact())
              .append("\nEmail: ").append(user.getEmail())
              .append("\nRole: ").append(user.isAdmin() ? "Admin" : "Guest")
              .append("\nLoyalty Points: ").append(user.getLoyaltyPoints())
              .append("\nActive Bookings: ").append(user.getBookingHistory().stream().filter(Booking::isActive).count())
              .append("\n");
        }
        return sb.toString();
    }
    
    static String getHotelAnalytics() {
        StringBuilder sb = new StringBuilder("====================\n   Hotel Analytics  \n====================\n");
        int luxDoubleFilled = 0, deluxDoubleFilled = 0, luxSingleFilled = 0, deluxSingleFilled = 0;
        int luxDoubleTotal = hotel_ob.luxury_doublerrom.length;
        int deluxDoubleTotal = hotel_ob.deluxe_doublerrom.length;
        int luxSingleTotal = hotel_ob.luxury_singleerrom.length;
        int deluxSingleTotal = hotel_ob.deluxe_singleerrom.length;
        
        for(int i = 0; i < luxDoubleTotal; i++) if(hotel_ob.luxury_doublerrom[i] != null) luxDoubleFilled++;
        for(int i = 0; i < deluxDoubleTotal; i++) if(hotel_ob.deluxe_doublerrom[i] != null) deluxDoubleFilled++;
        for(int i = 0; i < luxSingleTotal; i++) if(hotel_ob.luxury_singleerrom[i] != null) luxSingleFilled++;
        for(int i = 0; i < deluxSingleTotal; i++) if(hotel_ob.deluxe_singleerrom[i] != null) deluxSingleFilled++;
        
        int totalRooms = luxDoubleTotal + deluxDoubleTotal + luxSingleTotal + deluxSingleTotal;
        int occupiedRooms = luxDoubleFilled + deluxDoubleFilled + luxSingleFilled + deluxSingleFilled;
        
        sb.append("\nRoom Occupancy:\n")
          .append("Luxury Double: ").append(luxDoubleFilled).append("/").append(luxDoubleTotal)
          .append(" (").append(luxDoubleTotal > 0 ? (luxDoubleFilled * 100 / luxDoubleTotal) : 0).append("%)\n")
          .append("Deluxe Double: ").append(deluxDoubleFilled).append("/").append(deluxDoubleTotal)
          .append(" (").append(deluxDoubleTotal > 0 ? (deluxDoubleFilled * 100 / deluxDoubleTotal) : 0).append("%)\n")
          .append("Luxury Single: ").append(luxSingleFilled).append("/").append(luxSingleTotal)
          .append(" (").append(luxSingleTotal > 0 ? (luxSingleFilled * 100 / luxSingleTotal) : 0).append("%)\n")
          .append("Deluxe Single: ").append(deluxSingleFilled).append("/").append(deluxSingleTotal)
          .append(" (").append(deluxSingleTotal > 0 ? (deluxSingleFilled * 100 / deluxSingleTotal) : 0).append("%)\n")
          .append("Total: ").append(occupiedRooms).append("/").append(totalRooms)
          .append(" (").append(totalRooms > 0 ? (occupiedRooms * 100 / totalRooms) : 0).append("%)\n");
        
        int totalUsers = hotel_ob.users.size();
        int activeBookings = 0;
        for(User user : hotel_ob.users.values()) {
            activeBookings += user.getBookingHistory().stream().filter(Booking::isActive).count();
        }
        
        sb.append("\nUser Statistics:\n")
          .append("Total Registered Users: ").append(totalUsers).append("\n")
          .append("Active Bookings: ").append(activeBookings).append("\n");
        
        if(!hotel_ob.reviews.isEmpty()) {
            sb.append("\nReview Statistics:\n")
              .append("Total Reviews: ").append(hotel_ob.reviews.size()).append("\n")
              .append("Average Rating: ").append(String.format("%.1f", hotel_ob.calculateAverageRating())).append("/5\n");
            int[] ratingCounts = new int[6];
            for(Review review : hotel_ob.reviews) ratingCounts[review.getRating()]++;
            for(int i = 5; i >= 1; i--) {
                sb.append(i).append(" Star: ").append(ratingCounts[i]).append(" reviews\n");
            }
        } else {
            sb.append("\nNo reviews available.");
        }
        return sb.toString();
    }
    
    static void writeToFile() {
        try {
            File file = new File("hotel_data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(hotel_ob);
            oos.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error saving data to file", e);
        }
    }
    
    static void readFromFile() {
        try {
            File file = new File("hotel_data.ser");
            if(file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                hotel_ob = (holder)ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error loading data from file", e);
        }
    }
}

// JavaFX GUI Application
public class HotelGUI extends Application {
    private Stage primaryStage;
    private static final String[] ROOM_TYPES = {"Luxury Double Room", "Deluxe Double Room", "Luxury Single Room", "Deluxe Single Room"};
    
    @Override
    public void start(Stage stage) {
        Hotel.readFromFile();
        this.primaryStage = stage;
        primaryStage.setTitle("Hotel Management System");
        primaryStage.setScene(createLoginScene());
        primaryStage.show();
    }
    
    @Override
    public void stop() {
        Hotel.writeToFile();
    }
    
    private Scene createLoginScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        
        Text title = new Text("Login");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);
        
        grid.add(new Label("User ID:"), 0, 1);
        TextField userIdField = new TextField();
        grid.add(userIdField, 1, 1);
        
        grid.add(new Label("Password:"), 0, 2);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);
        
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        HBox hbButtons = new HBox(10, loginButton, registerButton);
        hbButtons.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(hbButtons, 1, 3);
        
        Text actionTarget = new Text();
        grid.add(actionTarget, 1, 4);
        
        loginButton.setOnAction(e -> {
            if(Hotel.login(userIdField.getText(), passwordField.getText())) {
                primaryStage.setScene(createMainMenuScene());
            } else {
                actionTarget.setText("Invalid credentials");
                actionTarget.setFill(javafx.scene.paint.Color.RED);
            }
        });
        
        registerButton.setOnAction(e -> primaryStage.setScene(createRegisterScene()));
        
        return new Scene(grid, 300, 200);
    }
    
    private Scene createRegisterScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        
        Text title = new Text("Register");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);
        
        grid.add(new Label("User ID:"), 0, 1);
        TextField userIdField = new TextField();
        grid.add(userIdField, 1, 1);
        
        grid.add(new Label("Password:"), 0, 2);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);
        
        grid.add(new Label("Name:"), 0, 3);
        TextField nameField = new TextField();
        grid.add(nameField, 1, 3);
        
        grid.add(new Label("Contact:"), 0, 4);
        TextField contactField = new TextField();
        grid.add(contactField, 1, 4);
        
        grid.add(new Label("Email:"), 0, 5);
        TextField emailField = new TextField();
        grid.add(emailField, 1, 5);
        
        CheckBox adminCheck = new CheckBox("Admin (first user only)");
        adminCheck.setDisable(!Hotel.hotel_ob.users.isEmpty());
        grid.add(adminCheck, 1, 6);
        
        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");
        HBox hbButtons = new HBox(10, registerButton, backButton);
        hbButtons.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(hbButtons, 1, 7);
        
        Text actionTarget = new Text();
        grid.add(actionTarget, 1, 8);
        
        registerButton.setOnAction(e -> {
            if(Hotel.hotel_ob.users.containsKey(userIdField.getText())) {
                actionTarget.setText("User ID already exists");
                actionTarget.setFill(javafx.scene.paint.Color.RED);
            } else {
                Hotel.register(userIdField.getText(), passwordField.getText(), nameField.getText(), contactField.getText(), emailField.getText(), adminCheck.isSelected());
                showAlert("Registration successful. Please login.");
                primaryStage.setScene(createLoginScene());
            }
        });
        
        backButton.setOnAction(e -> primaryStage.setScene(createLoginScene()));
        
        return new Scene(grid, 300, 300);
    }
    
    private Scene createMainMenuScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        Button[] buttons = {
            new Button("Display Room Details"), new Button("Display Room Availability"), new Button("Search Rooms"),
            new Button("Book Room"), new Button("Order Food"), new Button("Request Room Service"),
            new Button("Checkout"), new Button("Manage Account"), new Button("Admin Panel"), new Button("Logout")
        };
        
        buttons[8].setDisable(Hotel.currentUser == null || !Hotel.currentUser.isAdmin());
        
        buttons[0].setOnAction(e -> primaryStage.setScene(createRoomDetailsScene()));
        buttons[1].setOnAction(e -> primaryStage.setScene(createAvailabilityScene()));
        buttons[2].setOnAction(e -> primaryStage.setScene(createSearchRoomsScene()));
        buttons[3].setOnAction(e -> primaryStage.setScene(createBookRoomScene()));
        buttons[4].setOnAction(e -> primaryStage.setScene(createOrderFoodScene()));
        buttons[5].setOnAction(e -> primaryStage.setScene(createRequestServiceScene()));
        buttons[6].setOnAction(e -> primaryStage.setScene(createCheckoutScene()));
        buttons[7].setOnAction(e -> primaryStage.setScene(createManageAccountScene()));
        buttons[8].setOnAction(e -> primaryStage.setScene(createAdminPanelScene()));
        buttons[9].setOnAction(e -> {
            Hotel.currentUser = null;
            primaryStage.setScene(createLoginScene());
        });
        
        vbox.getChildren().addAll(buttons);
        return new Scene(vbox, 300, 400);
    }
    
    private Scene createRoomDetailsScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        ComboBox<String> roomTypeCombo = new ComboBox<>(FXCollections.observableArrayList(ROOM_TYPES));
        roomTypeCombo.setPromptText("Select room type");
        
        TextArea detailsArea = new TextArea();
        detailsArea.setEditable(false);
        detailsArea.setPrefHeight(200);
        
        roomTypeCombo.setOnAction(e -> {
            int type = roomTypeCombo.getSelectionModel().getSelectedIndex() + 1;
            detailsArea.setText(Hotel.getFeatures(type));
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(new Label("Room Details"), roomTypeCombo, detailsArea, backButton);
        return new Scene(vbox, 400, 300);
    }
    
    private Scene createAvailabilityScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        ComboBox<String> roomTypeCombo = new ComboBox<>(FXCollections.observableArrayList(ROOM_TYPES));
        roomTypeCombo.setPromptText("Select room type");
        
        TextArea availArea = new TextArea();
        availArea.setEditable(false);
        availArea.setPrefHeight(100);
        
        roomTypeCombo.setOnAction(e -> {
            int type = roomTypeCombo.getSelectionModel().getSelectedIndex() + 1;
            availArea.setText(Hotel.getAvailability(type));
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(new Label("Room Availability"), roomTypeCombo, availArea, backButton);
        return new Scene(vbox, 400, 200);
    }
    
    private Scene createSearchRoomsScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        ComboBox<String> searchTypeCombo = new ComboBox<>(FXCollections.observableArrayList("By Room Type", "By Price Range", "By Amenities"));
        searchTypeCombo.setPromptText("Select search type");
        
        VBox subOptions = new VBox(10);
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefHeight(200);
        
        searchTypeCombo.setOnAction(e -> {
            subOptions.getChildren().clear();
            int choice = searchTypeCombo.getSelectionModel().getSelectedIndex() + 1;
            if(choice == 1) {
                ComboBox<String> roomTypeCombo = new ComboBox<>(FXCollections.observableArrayList(ROOM_TYPES));
                roomTypeCombo.setPromptText("Select room type");
                Button searchButton = new Button("Search");
                subOptions.getChildren().addAll(new Label("Room Type"), roomTypeCombo, searchButton);
                searchButton.setOnAction(ev -> {
                    int subChoice = roomTypeCombo.getSelectionModel().getSelectedIndex() + 1;
                    resultArea.setText(Hotel.searchRoom(choice, subChoice, 0, 0, 0));
                });
            } else if(choice == 2) {
                TextField minPriceField = new TextField();
                TextField maxPriceField = new TextField();
                Button searchButton = new Button("Search");
                subOptions.getChildren().addAll(new Label("Min Price"), minPriceField, new Label("Max Price"), maxPriceField, searchButton);
                searchButton.setOnAction(ev -> {
                    try {
                        int min = Integer.parseInt(minPriceField.getText());
                        int max = Integer.parseInt(maxPriceField.getText());
                        resultArea.setText(Hotel.searchRoom(choice, 0, min, max, 0));
                    } catch (NumberFormatException ex) {
                        showAlert("Please enter valid numbers for price range");
                    }
                });
            } else if(choice == 3) {
                ComboBox<String> amenityCombo = new ComboBox<>(FXCollections.observableArrayList("AC", "Premium Wi-Fi", "24/7 Room Service"));
                amenityCombo.setPromptText("Select amenity");
                Button searchButton = new Button("Search");
                subOptions.getChildren().addAll(new Label("Amenity"), amenityCombo, searchButton);
                searchButton.setOnAction(ev -> {
                    int amenity = amenityCombo.getSelectionModel().getSelectedIndex() + 1;
                    resultArea.setText(Hotel.searchRoom(choice, 0, 0, 0, amenity));
                });
            }
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(new Label("Search Rooms"), searchTypeCombo, subOptions, resultArea, backButton);
        return new Scene(vbox, 400, 400);
    }
    
    private Scene createBookRoomScene() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20));
        
        VBox leftBox = new VBox(10);
        ComboBox<String> roomTypeCombo = new ComboBox<>(FXCollections.observableArrayList(ROOM_TYPES));
        roomTypeCombo.setPromptText("Select room type");
        ListView<String> roomList = new ListView<>();
        roomList.setPrefHeight(200);
        
        roomTypeCombo.setOnAction(e -> {
            int type = roomTypeCombo.getSelectionModel().getSelectedIndex() + 1;
            List<Integer> rooms = Hotel.getAvailableRoomNumbers(type);
            roomList.getItems().clear();
            for(int room : rooms) roomList.getItems().add("Room " + room);
        });
        
        leftBox.getChildren().addAll(new Label("Select Room Type:"), roomTypeCombo, new Label("Available Rooms:"), roomList);
        borderPane.setLeft(leftBox);
        
        VBox rightBox = new VBox(10);
        rightBox.setAlignment(Pos.CENTER);
        
        roomList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            rightBox.getChildren().clear();
            if(newVal != null) {
                int roomNum = Integer.parseInt(newVal.split(" ")[1]);
                int type = roomTypeCombo.getSelectionModel().getSelectedIndex() + 1;
                
                ComboBox<String> genderCombo = new ComboBox<>(FXCollections.observableArrayList("Male", "Female", "Other"));
                genderCombo.setPromptText("Select gender");
                rightBox.getChildren().addAll(new Label("Gender:"), genderCombo);
                
                TextField name2Field = new TextField();
                TextField contact2Field = new TextField();
                ComboBox<String> gender2Combo = new ComboBox<>(FXCollections.observableArrayList("Male", "Female", "Other"));
                gender2Combo.setPromptText("Select gender");
                
                if(type == 1 || type == 2) {
                    rightBox.getChildren().addAll(
                        new Label("Second Customer Name:"), name2Field,
                        new Label("Second Customer Contact:"), contact2Field,
                        new Label("Second Customer Gender:"), gender2Combo
                    );
                }
                
                Button bookButton = new Button("Book Room");
                bookButton.setOnAction(ev -> {
                    String gender = genderCombo.getValue();
                    if(gender == null) {
                        showAlert("Please select gender");
                        return;
                    }
                    String result = Hotel.bookRoom(type, roomNum, gender, 
                        name2Field.getText().isEmpty() ? null : name2Field.getText(),
                        contact2Field.getText().isEmpty() ? null : contact2Field.getText(),
                        gender2Combo.getValue());
                    showAlert(result);
                    if(result.startsWith("Room Booked Successfully")) {
                        primaryStage.setScene(createMainMenuScene());
                    }
                });
                rightBox.getChildren().add(bookButton);
            }
        });
        
        borderPane.setRight(rightBox);
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        borderPane.setBottom(backButton);
        
        return new Scene(borderPane, 600, 400);
    }
    
    private Scene createOrderFoodScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        TextField roomNumField = new TextField();
        ListView<String> menuList = new ListView<>(FXCollections.observableArrayList(
            "1. Sandwich - $50", "2. Pasta - $60", "3. Noodles - $70", "4. Coke - $30",
            "5. Pizza - $80", "6. Burger - $120", "7. Steak - $150", "8. Water - $40"
        ));
        menuList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TextField quantityField = new TextField();
        Button addButton = new Button("Add to Order");
        ListView<String> orderList = new ListView<>();
        Button orderButton = new Button("Place Order");
        Button backButton = new Button("Back");
        
        List<Food> orders = new ArrayList<>();
        addButton.setOnAction(e -> {
            try {
                int quantity = Integer.parseInt(quantityField.getText());
                for(String item : menuList.getSelectionModel().getSelectedItems()) {
                    int itemNo = Integer.parseInt(item.split("\\.")[0].trim());
                    orders.add(new Food(itemNo, quantity));
                    orderList.getItems().add(item + " x " + quantity);
                }
                quantityField.clear();
            } catch (NumberFormatException ex) {
                showAlert("Please enter a valid quantity");
            }
        });
        
        orderButton.setOnAction(e -> {
            try {
                int roomNum = Integer.parseInt(roomNumField.getText());
                int type, index;
                if(roomNum > 60 || roomNum < 1) {
                    showAlert("Room doesn't exist");
                    return;
                } else if(roomNum > 40) { type = 4; index = roomNum - 41; }
                else if(roomNum > 30) { type = 3; index = roomNum - 31; }
                else if(roomNum > 10) { type = 2; index = roomNum - 11; }
                else { type = 1; index = roomNum - 1; }
                
                String result = Hotel.order(index, type, orders);
                showAlert(result);
                if(result.startsWith("Thank you for your order")) {
                    primaryStage.setScene(createMainMenuScene());
                }
            } catch (NumberFormatException ex) {
                showAlert("Please enter a valid room number");
            }
        });
        
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(
            new Label("Order Food"), new Label("Room Number:"), roomNumField,
            new Label("Menu:"), menuList, new Label("Quantity:"), quantityField,
            addButton, new Label("Your Order:"), orderList, orderButton, backButton
        );
        return new Scene(vbox, 400, 600);
    }
    
    private Scene createRequestServiceScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        TextField roomNumField = new TextField();
        ComboBox<String> serviceCombo = new ComboBox<>(FXCollections.observableArrayList(
            "Room Cleaning - $30", "Laundry Service - $50", "Technical Support - $40", "Extra Amenities - $25", "Special Request"
        ));
        serviceCombo.setPromptText("Select service");
        
        VBox specialRequestBox = new VBox(10);
        TextField descField = new TextField();
        TextField chargeField = new TextField();
        
        serviceCombo.setOnAction(e -> {
            specialRequestBox.getChildren().clear();
            if(serviceCombo.getValue() != null && serviceCombo.getValue().equals("Special Request")) {
                specialRequestBox.getChildren().addAll(
                    new Label("Description:"), descField,
                    new Label("Charge:"), chargeField
                );
            }
        });
        
        Button requestButton = new Button("Request Service");
        Button backButton = new Button("Back");
        
        requestButton.setOnAction(e -> {
            try {
                int roomNum = Integer.parseInt(roomNumField.getText());
                int type, index;
                if(roomNum > 60 || roomNum < 1) {
                    showAlert("Room doesn't exist");
                    return;
                } else if(roomNum > 40) { type = 4; index = roomNum - 41; }
                else if(roomNum > 30) { type = 3; index = roomNum - 31; }
                else if(roomNum > 10) { type = 2; index = roomNum - 11; }
                else { type = 1; index = roomNum - 1; }
                
                String service = serviceCombo.getValue();
                if(service == null) {
                    showAlert("Please select a service");
                    return;
                }
                
                String desc;
                float charge;
                if(service.equals("Special Request")) {
                    desc = descField.getText();
                    charge = Float.parseFloat(chargeField.getText());
                } else {
                    desc = service.split(" - ")[0];
                    charge = Float.parseFloat(service.split(" - \\$")[1]);
                }
                
                String result = Hotel.requestRoomService(index, type, desc, charge);
                showAlert(result);
                if(result.startsWith("Room service request submitted successfully")) {
                    primaryStage.setScene(createMainMenuScene());
                }
            } catch (NumberFormatException ex) {
                showAlert("Please enter valid numbers for room and charge (if applicable)");
            }
        });
        
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(
            new Label("Request Room Service"), new Label("Room Number:"), roomNumField,
            new Label("Service:"), serviceCombo, specialRequestBox, requestButton, backButton
        );
        return new Scene(vbox, 400, 400);
    }
    
    private Scene createCheckoutScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        TextField roomNumField = new TextField();
        ComboBox<String> paymentCombo = new ComboBox<>(FXCollections.observableArrayList("Cash", "Credit Card", "Debit Card", "Mobile Payment"));
        paymentCombo.setPromptText("Select payment method");
        
        VBox reviewBox = new VBox(10);
        ComboBox<Integer> ratingCombo = new ComboBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        ratingCombo.setPromptText("Rating (1-5)");
        TextArea commentArea = new TextArea();
        commentArea.setPrefHeight(100);
        reviewBox.getChildren().addAll(new Label("Rating:"), ratingCombo, new Label("Comment:"), commentArea);
        
        Button checkoutButton = new Button("Checkout");
        Button backButton = new Button("Back");
        
        checkoutButton.setOnAction(e -> {
            try {
                int roomNum = Integer.parseInt(roomNumField.getText());
                int type, index;
                if(roomNum > 60 || roomNum < 1) {
                    showAlert("Room doesn't exist");
                    return;
                } else if(roomNum > 40) { type = 4; index = roomNum - 41; }
                else if(roomNum > 30) { type = 3; index = roomNum - 31; }
                else if(roomNum > 10) { type = 2; index = roomNum - 11; }
                else { type = 1; index = roomNum - 1; }
                
                int payment = paymentCombo.getSelectionModel().getSelectedIndex() + 1;
                if(payment < 1) {
                    showAlert("Please select a payment method");
                    return;
                }
                
                int rating = ratingCombo.getValue() != null ? ratingCombo.getValue() : 0;
                String comment = commentArea.getText();
                
                String result = Hotel.deallocate(index, type, payment, rating, comment);
                showAlert(result);
                if(result.contains("Deallocated successfully")) {
                    primaryStage.setScene(createMainMenuScene());
                }
            } catch (NumberFormatException ex) {
                showAlert("Please enter a valid room number");
            }
        });
        
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(
            new Label("Checkout"), new Label("Room Number:"), roomNumField,
            new Label("Payment Method:"), paymentCombo, new Label("Leave a Review:"), reviewBox,
            checkoutButton, backButton
        );
        return new Scene(vbox, 400, 500);
    }
    
    private Scene createManageAccountScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        ComboBox<String> optionCombo = new ComboBox<>(FXCollections.observableArrayList(
            "View Account Details", "View Booking History", "Check Loyalty Points", "View Reviews"
        ));
        optionCombo.setPromptText("Select option");
        
        TextArea detailsArea = new TextArea();
        detailsArea.setEditable(false);
        detailsArea.setPrefHeight(300);
        
        optionCombo.setOnAction(e -> {
            int choice = optionCombo.getSelectionModel().getSelectedIndex() + 1;
            detailsArea.setText(Hotel.getAccountDetails(choice));
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(new Label("Manage Account"), optionCombo, detailsArea, backButton);
        return new Scene(vbox, 400, 400);
    }
    
    private Scene createAdminPanelScene() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        ComboBox<String> optionCombo = new ComboBox<>(FXCollections.observableArrayList(
            "View All Rooms Status", "View All Users", "Complete Room Service", "View Hotel Analytics"
        ));
        optionCombo.setPromptText("Select option");
        
        VBox subOptions = new VBox(10);
        TextArea detailsArea = new TextArea();
        detailsArea.setEditable(false);
        detailsArea.setPrefHeight(300);
        
        optionCombo.setOnAction(e -> {
            subOptions.getChildren().clear();
            int choice = optionCombo.getSelectionModel().getSelectedIndex() + 1;
            if(choice == 3) {
                TextField roomNumField = new TextField();
                TextField serviceIdField = new TextField();
                Button completeButton = new Button("Complete Service");
                subOptions.getChildren().addAll(
                    new Label("Room Number:"), roomNumField,
                    new Label("Service ID:"), serviceIdField,
                    completeButton
                );
                completeButton.setOnAction(ev -> {
                    try {
                        int roomNum = Integer.parseInt(roomNumField.getText());
                        int serviceId = Integer.parseInt(serviceIdField.getText());
                        detailsArea.setText(Hotel.getAdminPanelDetails(choice, roomNum, serviceId));
                    } catch (NumberFormatException ex) {
                        showAlert("Please enter valid numbers");
                    }
                });
            } else {
                detailsArea.setText(Hotel.getAdminPanelDetails(choice, 0, 0));
            }
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(createMainMenuScene()));
        
        vbox.getChildren().addAll(new Label("Admin Panel"), optionCombo, subOptions, detailsArea, backButton);
        return new Scene(vbox, 400, 500);
    }
    
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}