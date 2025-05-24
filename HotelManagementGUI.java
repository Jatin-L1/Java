import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// Existing classes (unchanged except for minor adjustments)

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
    private int rating; // 1-5 stars
    private String comment;
    private Date reviewDate;
    
    public Review(String guestName, int rating, String comment) {
        this.reviewId = UUID.randomUUID();
        this.guestName = guestName;
        this.rating = Math.max(1, Math.min(5, rating)); // Ensure rating is between 1-5
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
        loyaltyPoints += 10; // Add points for each booking
    }
    
    public void completeBooking(UUID bookingId, double amount) {
        for(Booking booking : bookingHistory) {
            if(booking.getBookingId().equals(bookingId)) {
                booking.checkout(amount);
                loyaltyPoints += (int)(amount / 100); // Add points based on amount spent
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
    String guestId; // Link to user account
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
    Doubleroom luxury_doublerrom[] = new Doubleroom[10]; // Luxury
    Doubleroom deluxe_doublerrom[] = new Doubleroom[20]; // Deluxe
    Singleroom luxury_singleerrom[] = new Singleroom[10]; // Luxury
    Singleroom deluxe_singleerrom[] = new Singleroom[20]; // Deluxe
    Map<String, User> users = new HashMap<>(); // Store users
    List<Review> reviews = new ArrayList<>(); // Store reviews
    
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

class Hotel {
    private static final Logger logger = Logger.getLogger(Hotel.class.getName());
    static holder hotel_ob = new holder();
    static User currentUser = null;
    
    static String login(String userId, String password) {
        User user = hotel_ob.users.get(userId);
        if(user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return "Welcome, " + user.getName() + "!";
        } else {
            return "Invalid User ID or Password. Please try again.";
        }
    }
    
    static String register(String userId, String password, String name, String contact, String email, boolean isAdmin) {
        if(hotel_ob.users.containsKey(userId)) {
            return "User ID already exists. Please choose another.";
        }
        
        User newUser = new User(userId, password, name, contact, email, isAdmin);
        hotel_ob.users.put(userId, newUser);
        return "Registration successful. Please login.";
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
            default:
                throw new InvalidInputException("Invalid room type");
        }
    }
    
    static String bookroom(int i, int rn, String gender, String name2, String contact2, String gender2) {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            rn--; // Adjust for 0-based indexing
            switch (i) {
                case 1:
                    if(rn < 0 || rn >= hotel_ob.luxury_doublerrom.length)
                        throw new InvalidInputException("Room number out of range");
                    if(hotel_ob.luxury_doublerrom[rn] != null)
                        throw new NotAvailable();
                    int discount1 = currentUser.calculateDiscount();
                    CustDetails(i, rn, gender, name2, contact2, gender2);
                    return discount1 > 0 ? 
                        "Room Booked Successfully!\nDiscount: " + discount1 + "%\nStandard rate: $4000\nYour rate: $" + (4000 - (4000 * discount1 / 100)) :
                        "Room Booked Successfully!\nStandard rate: $4000";
                case 2:
                    rn = rn - 10; // Adjust for room numbers 11-30
                    if(rn < 0 || rn >= hotel_ob.deluxe_doublerrom.length)
                        throw new InvalidInputException("Room number out of range");
                    if(hotel_ob.deluxe_doublerrom[rn] != null)
                        throw new NotAvailable();
                    int discount2 = currentUser.calculateDiscount();
                    CustDetails(i, rn, gender, name2, contact2, gender2);
                    return discount2 > 0 ? 
                        "Room Booked Successfully!\nDiscount: " + discount2 + "%\nStandard rate: $3000\nYour rate: $" + (3000 - (3000 * discount2 / 100)) :
                        "Room Booked Successfully!\nStandard rate: $3000";
                case 3:
                    rn = rn - 30; // Adjust for room numbers 31-40
                    if(rn < 0 || rn >= hotel_ob.luxury_singleerrom.length)
                        throw new InvalidInputException("Room number out of range");
                    if(hotel_ob.luxury_singleerrom[rn] != null)
                        throw new NotAvailable();
                    int discount3 = currentUser.calculateDiscount();
                    CustDetails(i, rn, gender, "", "", "");
                    return discount3 > 0 ? 
                        "Room Booked Successfully!\nDiscount: " + discount3 + "%\nStandard rate: $2200\nYour rate: $" + (2200 - (2200 * discount3 / 100)) :
                        "Room Booked Successfully!\nStandard rate: $2200";
                case 4:
                    rn = rn - 40; // Adjust for room numbers 41-60
                    if(rn < 0 || rn >= hotel_ob.deluxe_singleerrom.length)
                        throw new InvalidInputException("Room number out of range");
                    if(hotel_ob.deluxe_singleerrom[rn] != null)
                        throw new NotAvailable();
                    int discount4 = currentUser.calculateDiscount();
                    CustDetails(i, rn, gender, "", "", "");
                    return discount4 > 0 ? 
                        "Room Booked Successfully!\nDiscount: " + discount4 + "%\nStandard rate: $1200\nYour rate: $" + (1200 - (1200 * discount4 / 100)) :
                        "Room Booked Successfully!\nStandard rate: $1200";
                default:
                    return "Invalid room type";
            }
        } catch (InvalidInputException | NotAvailable e) {
            logger.log(Level.WARNING, "Error during room booking", e);
            return e.getMessage();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during room booking", e);
            return "Error: " + e.getMessage();
        }
    }
    
    static String features(int i) {
        switch (i) {
            case 1:
                return "Room Type: Luxury Double Room\nNumber of double beds: 1\nAC: Yes\nFree breakfast: Yes\nWi-Fi: High-speed Premium\nRoom service: 24/7\nCharge per day: $4000";
            case 2:
                return "Room Type: Deluxe Double Room\nNumber of double beds: 1\nAC: No\nFree breakfast: Yes\nWi-Fi: Standard\nRoom service: 12 hours\nCharge per day: $3000";
            case 3:
                return "Room Type: Luxury Single Room\nNumber of single beds: 1\nAC: Yes\nFree breakfast: Yes\nWi-Fi: High-speed\nRoom service: 24/7\nCharge per day: $2200";
            case 4:
                return "Room Type: Deluxe Single Room\nNumber of single beds: 1\nAC: No\nFree breakfast: Yes\nWi-Fi: Standard\nRoom service: Limited hours\nCharge per day: $1200";
            default:
                return "Invalid option";
        }
    }
    
    static String availability(int i) {
        int count = 0;
        StringBuilder rooms = new StringBuilder();
        switch (i) {
            case 1:
                for(int j = 0; j < hotel_ob.luxury_doublerrom.length; j++) {
                    if(hotel_ob.luxury_doublerrom[j] == null) {
                        count++;
                        rooms.append(j + 1).append(", ");
                    }
                }
                break;
            case 2:
                for(int j = 0; j < hotel_ob.deluxe_doublerrom.length; j++) {
                    if(hotel_ob.deluxe_doublerrom[j] == null) {
                        count++;
                        rooms.append(j + 11).append(", ");
                    }
                }
                break;
            case 3:
                for(int j = 0; j < hotel_ob.luxury_singleerrom.length; j++) {
                    if(hotel_ob.luxury_singleerrom[j] == null) {
                        count++;
                        rooms.append(j + 31).append(", ");
                    }
                }
                break;
            case 4:
                for(int j = 0; j < hotel_ob.deluxe_singleerrom.length; j++) {
                    if(hotel_ob.deluxe_singleerrom[j] == null) {
                        count++;
                        rooms.append(j + 41).append(", ");
                    }
                }
                break;
            default:
                return "Invalid option";
        }
        return "Number of rooms available: " + count + (rooms.length() > 0 ? "\nAvailable rooms: " + rooms.substring(0, rooms.length() - 2) : "");
    }
    
    static String searchRoom(int choice, int param1, int param2) {
        try {
            StringBuilder result = new StringBuilder();
            switch(choice) {
                case 1:
                    if(param1 >= 1 && param1 <= 4) {
                        result.append(features(param1)).append("\n").append(availability(param1));
                    } else {
                        return "Invalid room type";
                    }
                    break;
                case 2:
                    result.append("Rooms available in price range $").append(param1).append(" - $").append(param2).append(":\n");
                    if(1200 >= param1 && 1200 <= param2) {
                        result.append("Deluxe Single Room - $1200 per night\n").append(availability(4)).append("\n");
                    }
                    if(2200 >= param1 && 2200 <= param2) {
                        result.append("Luxury Single Room - $2200 per night\n").append(availability(3)).append("\n");
                    }
                    if(3000 >= param1 && 3000 <= param2) {
                        result.append("Deluxe Double Room - $3000 per night\n").append(availability(2)).append("\n");
                    }
                    if(4000 >= param1 && 4000 <= param2) {
                        result.append("Luxury Double Room - $4000 per night\n").append(availability(1));
                    }
                    break;
                case 3:
                    switch(param1) {
                        case 1:
                            result.append("Rooms with AC:\n");
                            result.append("1. Luxury Double Room - $4000 per night\n").append(availability(1)).append("\n");
                            result.append("3. Luxury Single Room - $2200 per night\n").append(availability(3));
                            break;
                        case 2:
                            result.append("Rooms with Premium Wi-Fi:\n");
                            result.append("1. Luxury Double Room - $4000 per night\n").append(availability(1));
                            break;
                        case 3:
                            result.append("Rooms with 24/7 Room Service:\n");
                            result.append("1. Luxury Double Room - $4000 per night\n").append(availability(1)).append("\n");
                            result.append("3. Luxury Single Room - $2200 per night\n").append(availability(3));
                            break;
                        default:
                            return "Invalid amenity option";
                    }
                    break;
                default:
                    return "Invalid search option";
            }
            return result.toString();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error during room search", e);
            return "Error during room search: " + e.getMessage();
        }
    }
    
    static String bill(int rn, int rtype, int paymentMethod) {
        try {
            StringBuilder bill = new StringBuilder();
            double amount = 0;
            String[] list = {"Sandwich", "Pasta", "Noodles", "Coke", "Pizza", "Burger", "Steak", "Water"};
            bill.append("\n*******\n Bill:-\n*******\n");
            
            int discount = currentUser != null ? currentUser.calculateDiscount() : 0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date checkoutDate = new Date();
            Date checkinDate = null;
            long stayDuration = 1;
            
            switch(rtype) {
                case 1:
                    checkinDate = hotel_ob.luxury_doublerrom[rn].checkInDate;
                    break;
                case 2:
                    checkinDate = hotel_ob.deluxe_doublerrom[rn].checkInDate;
                    break;
                case 3:
                    checkinDate = hotel_ob.luxury_singleerrom[rn].checkInDate;
                    break;
                case 4:
                    checkinDate = hotel_ob.deluxe_singleerrom[rn].checkInDate;
                    break;
            }
            
            if(checkinDate != null) {
                stayDuration = (checkoutDate.getTime() - checkinDate.getTime()) / (1000 * 60 * 60 * 24);
                if(stayDuration < 1) stayDuration = 1;
            }
            
            bill.append("\nCheck-in Date: ").append(sdf.format(checkinDate))
                .append("\nCheck-out Date: ").append(sdf.format(checkoutDate))
                .append("\nStay Duration: ").append(stayDuration).append(" day(s)");
            
            double roomCharge = 0;
            ArrayList<Food> foods = null;
            ArrayList<RoomService> services = null;
            
            switch(rtype) {
                case 1:
                    roomCharge = 4000 * stayDuration;
                    amount += roomCharge;
                    foods = hotel_ob.luxury_doublerrom[rn].food;
                    services = hotel_ob.luxury_doublerrom[rn].services;
                    bill.append("\n\nRoom Charge - $").append(roomCharge).append(" ($4000 x ").append(stayDuration).append(" days)");
                    break;
                case 2:
                    roomCharge = 3000 * stayDuration;
                    amount += roomCharge;
                    foods = hotel_ob.deluxe_doublerrom[rn].food;
                    services = hotel_ob.deluxe_doublerrom[rn].services;
                    bill.append("\n\nRoom Charge - $").append(roomCharge).append(" ($3000 x ").append(stayDuration).append(" days)");
                    break;
                case 3:
                    roomCharge = 2200 * stayDuration;
                    amount += roomCharge;
                    foods = hotel_ob.luxury_singleerrom[rn].food;
                    services = hotel_ob.luxury_singleerrom[rn].services;
                    bill.append("\n\nRoom Charge - $").append(roomCharge).append(" ($2200 x ").append(stayDuration).append(" days)");
                    break;
                case 4:
                    roomCharge = 1200 * stayDuration;
                    amount += roomCharge;
                    foods = hotel_ob.deluxe_singleerrom[rn].food;
                    services = hotel_ob.deluxe_singleerrom[rn].services;
                    bill.append("\n\nRoom Charge - $").append(roomCharge).append(" ($1200 x ").append(stayDuration).append(" days)");
                    break;
                default:
                    return "Invalid room type";
            }
            
            bill.append("\n\n===============\nFood Charges:-\n===============\n")
                .append("Item     Quantity    Price\n-------------------------\n");
            for(Food obb : foods) {
                amount += obb.price;
                bill.append(String.format("%-10s%-10s%-10s%n", list[obb.itemno-1], obb.quantity, obb.price));
            }
            
            if(!services.isEmpty()) {
                bill.append("\n===============\nRoom Services:-\n===============\n")
                    .append("Service              Charge\n-------------------------\n");
                for(RoomService service : services) {
                    if(service.isCompleted()) {
                        amount += service.getCharge();
                        bill.append(String.format("%-20s%-10s%n", service.getDescription(), service.getCharge()));
                    }
                }
            }
            
            double finalAmount = amount;
            if(discount > 0) {
                double discountAmount = amount * discount / 100;
                finalAmount = amount - discountAmount;
                bill.append("\nSubtotal Amount: $").append(amount)
                    .append("\nLoyalty Discount (").append(discount).append("%): -$").append(discountAmount);
            }
            
            bill.append("\n\nFinal Amount: $").append(finalAmount);
            
            String paymentMethodStr = switch(paymentMethod) {
                case 1 -> "Cash";
                case 2 -> "Credit Card";
                case 3 -> "Debit Card";
                case 4 -> "Mobile Payment";
                default -> "Unknown";
            };
            
            bill.append("\n\nPayment processed successfully via ").append(paymentMethodStr)
                .append("\nThank you for staying with us!");
            
            if(currentUser != null) {
                String guestId = switch(rtype) {
                    case 1 -> hotel_ob.luxury_doublerrom[rn].guestId;
                    case 2 -> hotel_ob.deluxe_doublerrom[rn].guestId;
                    case 3 -> hotel_ob.luxury_singleerrom[rn].guestId;
                    case 4 -> hotel_ob.deluxe_singleerrom[rn].guestId;
                    default -> "";
                };
                
                for(Booking booking : currentUser.getBookingHistory()) {
                    if(booking.isActive() && booking.getRoomType() == rtype) {
                        booking.checkout(finalAmount);
                        break;
                    }
                }
            }
            
            return bill.toString();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error generating bill", e);
            return "Error generating bill: " + e.getMessage();
        }
    }
    
    static String deallocate(int rn, int rtype, boolean leaveReview, int rating, String comment) {
        try {
            StringBuilder result = new StringBuilder();
            String occupant = "";
            boolean isOccupied = false;
            
            switch (rtype) {
                case 1:
                    if(hotel_ob.luxury_doublerrom[rn] != null) {
                        occupant = hotel_ob.luxury_doublerrom[rn].name;
                        isOccupied = true;
                    }
                    break;
                case 2:
                    if(hotel_ob.deluxe_doublerrom[rn] != null) {
                        occupant = hotel_ob.deluxe_doublerrom[rn].name;
                        isOccupied = true;
                    }
                    break;
                case 3:
                    if(hotel_ob.luxury_singleerrom[rn] != null) {
                        occupant = hotel_ob.luxury_singleerrom[rn].name;
                        isOccupied = true;
                    }
                    break;
                case 4:
                    if(hotel_ob.deluxe_singleerrom[rn] != null) {
                        occupant = hotel_ob.deluxe_singleerrom[rn].name;
                        isOccupied = true;
                    }
                    break;
                default:
                    return "Invalid room type";
            }
            
            if(!isOccupied) {
                return "Room is already empty";
            }
            
            result.append("Room used by ").append(occupant).append("\n");
            
            if(currentUser != null && !currentUser.isAdmin()) {
                String guestId = switch(rtype) {
                    case 1 -> hotel_ob.luxury_doublerrom[rn].guestId;
                    case 2 -> hotel_ob.deluxe_doublerrom[rn].guestId;
                    case 3 -> hotel_ob.luxury_singleerrom[rn].guestId;
                    case 4 -> hotel_ob.deluxe_singleerrom[rn].guestId;
                    default -> "";
                };
                if(!currentUser.getUserId().equals(guestId)) {
                    return "You don't have permission to check out this room.";
                }
            }
            
            result.append(bill(rn, rtype, 2)); // Default to Credit Card for simplicity
            
            if(leaveReview) {
                Review review = new Review(currentUser != null ? currentUser.getName() : "Anonymous", rating, comment);
                hotel_ob.addReview(review);
                result.append("\nThank you for your feedback!");
            }
            
            switch(rtype) {
                case 1: hotel_ob.luxury_doublerrom[rn] = null; break;
                case 2: hotel_ob.deluxe_doublerrom[rn] = null; break;
                case 3: hotel_ob.luxury_singleerrom[rn] = null; break;
                case 4: hotel_ob.deluxe_singleerrom[rn] = null; break;
            }
            
            result.append("\nDeallocated successfully");
            return result.toString();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during checkout", e);
            return "Error during checkout: " + e.getMessage();
        }
    }
    
    static String order(int rn, int rtype, List<int[]> orders) {
        try {
            switch(rtype) {
                case 1:
                    for(int[] order : orders) {
                        hotel_ob.luxury_doublerrom[rn].food.add(new Food(order[0], order[1]));
                    }
                    break;
                case 2:
                    for(int[] order : orders) {
                        hotel_ob.deluxe_doublerrom[rn].food.add(new Food(order[0], order[1]));
                    }
                    break;
                case 3:
                    for(int[] order : orders) {
                        hotel_ob.luxury_singleerrom[rn].food.add(new Food(order[0], order[1]));
                    }
                    break;
                case 4:
                    for(int[] order : orders) {
                        hotel_ob.deluxe_singleerrom[rn].food.add(new Food(order[0], order[1]));
                    }
                    break;
                default:
                    return "Invalid room type";
            }
            return "Thank you for your order!\nYour food will be delivered to your room shortly.";
        } catch(NullPointerException e) {
            logger.log(Level.WARNING, "Food order attempted for unbooked room", e);
            return "Room not booked";
        } catch(Exception e) {
            logger.log(Level.SEVERE, "Error processing food order", e);
            return "Error processing food order: " + e.getMessage();
        }
    }
    
    static String requestRoomService(int rn, int rtype, int choice, String specialRequest, float charge) {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            String description;
            float serviceCharge;
            
            switch(choice) {
                case 1:
                    description = "Room Cleaning";
                    serviceCharge = 30;
                    break;
                case 2:
                    description = "Laundry Service";
                    serviceCharge = 50;
                    break;
                case 3:
                    description = "Technical Support";
                    serviceCharge = 40;
                    break;
                case 4:
                    description = "Extra Amenities";
                    serviceCharge = 25;
                    break;
                case 5:
                    description = specialRequest;
                    serviceCharge = charge;
                    break;
                default:
                    return "Invalid choice";
            }
            
            switch(rtype) {
                case 1:
                    hotel_ob.luxury_doublerrom[rn].requestService(description, serviceCharge);
                    break;
                case 2:
                    hotel_ob.deluxe_doublerrom[rn].requestService(description, serviceCharge);
                    break;
                case 3:
                    hotel_ob.luxury_singleerrom[rn].requestService(description, serviceCharge);
                    break;
                case 4:
                    hotel_ob.deluxe_singleerrom[rn].requestService(description, serviceCharge);
                    break;
                default:
                    return "Invalid room type";
            }
            
            return "Room service request submitted successfully!\nService: " + description + "\nCharge: $" + serviceCharge;
        } catch(NullPointerException e) {
            logger.log(Level.WARNING, "Room service requested for unbooked room", e);
            return "Room not booked";
        } catch(Exception e) {
            logger.log(Level.SEVERE, "Error requesting room service", e);
            return "Error requesting room service: " + e.getMessage();
        }
    }
    
    static String completeRoomService(int rn, int rtype, int serviceId) {
        try {
            if(currentUser == null || !currentUser.isAdmin()) {
                throw new InvalidInputException("Only administrators can mark services as complete!");
            }
            
            ArrayList<RoomService> services = null;
            switch(rtype) {
                case 1:
                    if(hotel_ob.luxury_doublerrom[rn] != null)
                        services = hotel_ob.luxury_doublerrom[rn].services;
                    break;
                case 2:
                    if(hotel_ob.deluxe_doublerrom[rn] != null)
                        services = hotel_ob.deluxe_doublerrom[rn].services;
                    break;
                case 3:
                    if(hotel_ob.luxury_singleerrom[rn] != null)
                        services = hotel_ob.luxury_singleerrom[rn].services;
                    break;
                case 4:
                    if(hotel_ob.deluxe_singleerrom[rn] != null)
                        services = hotel_ob.deluxe_singleerrom[rn].services;
                    break;
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
        } catch(InvalidInputException e) {
            logger.log(Level.WARNING, "Unauthorized attempt to complete room service", e);
            return e.getMessage();
        } catch(Exception e) {
            logger.log(Level.SEVERE, "Error completing room service", e);
            return "Error completing room service: " + e.getMessage();
        }
    }
    
    static String viewBookingHistory() {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            List<Booking> bookings = currentUser.getBookingHistory();
            if(bookings.isEmpty()) {
                return "No booking history found.";
            }
            
            StringBuilder result = new StringBuilder("Booking History\n====================\n");
            for(Booking booking : bookings) {
                result.append("\n").append(booking).append("\n");
            }
            return result.toString();
        } catch(InvalidInputException e) {
            logger.log(Level.WARNING, "Unauthorized attempt to view booking history", e);
            return e.getMessage();
        } catch(Exception e) {
            logger.log(Level.SEVERE, "Error viewing booking history", e);
            return "Error viewing booking history: " + e.getMessage();
        }
    }
    
    static String viewAllRoomsStatus() {
        StringBuilder result = new StringBuilder("All Rooms Status\n====================\n");
        
        result.append("\nLuxury Double Rooms:\n");
        for(int i = 0; i < hotel_ob.luxury_doublerrom.length; i++) {
            result.append("Room ").append(i + 1).append(": ")
                  .append(hotel_ob.luxury_doublerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.luxury_doublerrom[i].name)
                  .append("\n");
        }
        
        result.append("\nDeluxe Double Rooms:\n");
        for(int i = 0; i < hotel_ob.deluxe_doublerrom.length; i++) {
            result.append("Room ").append(i + 11).append(": ")
                  .append(hotel_ob.deluxe_doublerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.deluxe_doublerrom[i].name)
                  .append("\n");
        }
        
        result.append("\nLuxury Single Rooms:\n");
        for(int i = 0; i < hotel_ob.luxury_singleerrom.length; i++) {
            result.append("Room ").append(i + 31).append(": ")
                  .append(hotel_ob.luxury_singleerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.luxury_singleerrom[i].name)
                  .append("\n");
        }
        
        result.append("\nDeluxe Single Rooms:\n");
        for(int i = 0; i < hotel_ob.deluxe_singleerrom.length; i++) {
            result.append("Room ").append(i + 41).append(": ")
                  .append(hotel_ob.deluxe_singleerrom[i] == null ? "Available" : "Occupied by " + hotel_ob.deluxe_singleerrom[i].name)
                  .append("\n");
        }
        
        return result.toString();
    }
    
    static String viewAllUsers() {
        if(hotel_ob.users.isEmpty()) {
            return "No users registered.";
        }
        
        StringBuilder result = new StringBuilder("All Users\n====================\n");
        for(Map.Entry<String, User> entry : hotel_ob.users.entrySet()) {
            User user = entry.getValue();
            result.append("\nUser ID: ").append(user.getUserId())
                  .append("\nName: ").append(user.getName())
                  .append("\nContact: ").append(user.getContact())
                  .append("\nEmail: ").append(user.getEmail())
                  .append("\nRole: ").append(user.isAdmin() ? "Admin" : "Guest")
                  .append("\nLoyalty Points: ").append(user.getLoyaltyPoints())
                  .append("\nActive Bookings: ").append(user.getBookingHistory().stream().filter(Booking::isActive).count())
                  .append("\n");
        }
        return result.toString();
    }
    
    static String hotelAnalytics() {
        StringBuilder result = new StringBuilder("Hotel Analytics\n====================\n");
        
        int luxDoubleFilled = 0, deluxDoubleFilled = 0, luxSingleFilled = 0, deluxSingleFilled = 0;
        int luxDoubleTotal = hotel_ob.luxury_doublerrom.length;
        int deluxDoubleTotal = hotel_ob.deluxe_doublerrom.length;
        int luxSingleTotal = hotel_ob.luxury_singleerrom.length;
        int deluxSingleTotal = hotel_ob.deluxe_singleerrom.length;
        
        for(int i = 0; i < luxDoubleTotal; i++) {
            if(hotel_ob.luxury_doublerrom[i] != null) luxDoubleFilled++;
        }
        
        for(int i = 0; i < deluxDoubleTotal; i++) {
            if(hotel_ob.deluxe_doublerrom[i] != null) deluxDoubleFilled++;
        }
        
        for(int i = 0; i < luxSingleTotal; i++) {
            if(hotel_ob.luxury_singleerrom[i] != null) luxSingleFilled++;
        }
        
        for(int i = 0; i < deluxSingleTotal; i++) {
            if(hotel_ob.deluxe_singleerrom[i] != null) deluxSingleFilled++;
        }
        
        int totalRooms = luxDoubleTotal + deluxDoubleTotal + luxSingleTotal + deluxSingleTotal;
        int occupiedRooms = luxDoubleFilled + deluxDoubleFilled + luxSingleFilled + deluxSingleFilled;
        
        result.append("\nRoom Occupancy:\n")
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
            for(Booking booking : user.getBookingHistory()) {
                if(booking.isActive()) activeBookings++;
            }
        }
        
        result.append("\nUser Statistics:\n")
              .append("Total Registered Users: ").append(totalUsers).append("\n")
              .append("Active Bookings: ").append(activeBookings).append("\n");
        
        if(!hotel_ob.reviews.isEmpty()) {
            result.append("\nReview Statistics:\n")
                  .append("Total Reviews: ").append(hotel_ob.reviews.size()).append("\n")
                  .append("Average Rating: ").append(String.format("%.1f", hotel_ob.calculateAverageRating())).append("/5\n");
            
            int[] ratingCounts = new int[6];
            for(Review review : hotel_ob.reviews) {
                ratingCounts[review.getRating()]++;
            }
            
            for(int i = 5; i >= 1; i--) {
                result.append(i).append(" Star: ").append(ratingCounts[i]).append(" reviews\n");
            }
        } else {
            result.append("\nNo reviews available.");
        }
        
        return result.toString();
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

// New JavaFX GUI class
public class HotelManagementGUI extends Application {
    private static final Logger logger = Logger.getLogger(HotelManagementGUI.class.getName());
    private Stage primaryStage;
    private Scene loginScene, registerScene, mainMenuScene, bookRoomScene, orderFoodScene, roomServiceScene, checkoutScene, accountScene, adminScene;
    
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        Hotel.readFromFile();
        setupScenes();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Hotel Management System");
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(e -> {
            Hotel.writeToFile();
            System.exit(0);
        });
    }
    
    private void setupScenes() {
        // Login Scene
        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setAlignment(Pos.CENTER);
        
        TextField userIdField = new TextField();
        userIdField.setPromptText("User ID");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        Label messageLabel = new Label();
        
        loginButton.setOnAction(e -> {
            String result = Hotel.login(userIdField.getText(), passwordField.getText());
            messageLabel.setText(result);
            if(result.startsWith("Welcome")) {
                primaryStage.setScene(mainMenuScene);
            }
        });
        
        registerButton.setOnAction(e -> primaryStage.setScene(registerScene));
        
        loginLayout.getChildren().addAll(
            new Label("Hotel Management System"),
            userIdField, passwordField, loginButton, registerButton, messageLabel
        );
        
        loginScene = new Scene(loginLayout, 400, 300);
        
        // Register Scene
        VBox registerLayout = new VBox(10);
        registerLayout.setPadding(new Insets(20));
        registerLayout.setAlignment(Pos.CENTER);
        
        TextField regUserIdField = new TextField();
        regUserIdField.setPromptText("User ID");
        PasswordField regPasswordField = new PasswordField();
        regPasswordField.setPromptText("Password");
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField contactField = new TextField();
        contactField.setPromptText("Contact");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        CheckBox isAdminCheck = new CheckBox("Admin Account");
        Button regSubmitButton = new Button("Register");
        Button regBackButton = new Button("Back");
        Label regMessageLabel = new Label();
        
        regSubmitButton.setOnAction(e -> {
            String result = Hotel.register(
                regUserIdField.getText(),
                regPasswordField.getText(),
                nameField.getText(),
                contactField.getText(),
                emailField.getText(),
                Hotel.hotel_ob.users.isEmpty() && isAdminCheck.isSelected()
            );
            regMessageLabel.setText(result);
            if(result.contains("successful")) {
                primaryStage.setScene(loginScene);
            }
        });
        
        regBackButton.setOnAction(e -> primaryStage.setScene(loginScene));
        
        registerLayout.getChildren().addAll(
            new Label("Register New User"),
            regUserIdField, regPasswordField, nameField, contactField, emailField,
            isAdminCheck, regSubmitButton, regBackButton, regMessageLabel
        );
        
        registerScene = new Scene(registerLayout, 400, 400);
        
        // Main Menu Scene
        VBox mainMenuLayout = new VBox(10);
        mainMenuLayout.setPadding(new Insets(20));
        mainMenuLayout.setAlignment(Pos.CENTER);
        
        Button roomDetailsButton = new Button("Display Room Details");
        Button availabilityButton = new Button("Display Room Availability");
        Button searchRoomButton = new Button("Search Rooms");
        Button bookRoomButton = new Button("Book Room");
        Button orderFoodButton = new Button("Order Food");
        Button roomServiceButton = new Button("Request Room Service");
        Button checkoutButton = new Button("Checkout");
        Button manageAccountButton = new Button("Manage Account");
        Button adminPanelButton = new Button("Admin Panel");
        Button logoutButton = new Button("Logout");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        
        roomDetailsButton.setOnAction(e -> {
            ComboBox<Integer> roomTypeCombo = new ComboBox<>();
            roomTypeCombo.getItems().addAll(1, 2, 3, 4);
            roomTypeCombo.setPromptText("Select Room Type");
            Button submit = new Button("Show Details");
            VBox dialog = new VBox(10, new Label("Choose room type:"), roomTypeCombo, submit);
            dialog.setPadding(new Insets(20));
            Scene dialogScene = new Scene(dialog, 300, 200);
            Stage dialogStage = new Stage();
            dialogStage.setScene(dialogScene);
            dialogStage.show();
            
            submit.setOnAction(se -> {
                if(roomTypeCombo.getValue() != null) {
                    outputArea.setText(Hotel.features(roomTypeCombo.getValue()));
                    dialogStage.close();
                }
            });
        });
        
        availabilityButton.setOnAction(e -> {
            ComboBox<Integer> roomTypeCombo = new ComboBox<>();
            roomTypeCombo.getItems().addAll(1, 2, 3, 4);
            roomTypeCombo.setPromptText("Select Room Type");
            Button submit = new Button("Check Availability");
            VBox dialog = new VBox(10, new Label("Choose room type:"), roomTypeCombo, submit);
            dialog.setPadding(new Insets(20));
            Scene dialogScene = new Scene(dialog, 300, 200);
            Stage dialogStage = new Stage();
            dialogStage.setScene(dialogScene);
            dialogStage.show();
            
            submit.setOnAction(se -> {
                if(roomTypeCombo.getValue() != null) {
                    outputArea.setText(Hotel.availability(roomTypeCombo.getValue()));
                    dialogStage.close();
                }
            });
        });
        
        searchRoomButton.setOnAction(e -> {
            ComboBox<Integer> searchTypeCombo = new ComboBox<>();
            searchTypeCombo.getItems().addAll(1, 2, 3);
            searchTypeCombo.setPromptText("Search By");
            TextField param1Field = new TextField();
            TextField param2Field = new TextField();
            Button submit = new Button("Search");
            VBox dialog = new VBox(10);
            dialog.setPadding(new Insets(20));
            
            searchTypeCombo.setOnAction(se -> {
                dialog.getChildren().clear();
                dialog.getChildren().addAll(new Label("Search Rooms"), searchTypeCombo);
                if(searchTypeCombo.getValue() != null) {
                    switch(searchTypeCombo.getValue()) {
                        case 1:
                            ComboBox<Integer> roomTypeCombo = new ComboBox<>();
                            roomTypeCombo.getItems().addAll(1, 2, 3, 4);
                            roomTypeCombo.setPromptText("Room Type");
                            dialog.getChildren().add(roomTypeCombo);
                            submit.setOnAction(ae -> {
                                if(roomTypeCombo.getValue() != null) {
                                    outputArea.setText(Hotel.searchRoom(1, roomTypeCombo.getValue(), 0));
                                    dialogStage.close();
                                }
                            });
                            break;
                        case 2:
                            param1Field.setPromptText("Min Price");
                            param2Field.setPromptText("Max Price");
                            dialog.getChildren().addAll(param1Field, param2Field);
                            submit.setOnAction(ae -> {
                                try {
                                    int min = Integer.parseInt(param1Field.getText());
                                    int max = Integer.parseInt(param2Field.getText());
                                    outputArea.setText(Hotel.searchRoom(2, min, max));
                                    dialogStage.close();
                                } catch (NumberFormatException ex) {
                                    outputArea.setText("Invalid price range");
                                }
                            });
                            break;
                        case 3:
                            ComboBox<Integer> amenityCombo = new ComboBox<>();
                            amenityCombo.getItems().addAll(1, 2, 3);
                            amenityCombo.setPromptText("Amenity");
                            dialog.getChildren().add(amenityCombo);
                            submit.setOnAction(ae -> {
                                if(amenityCombo.getValue() != null) {
                                    outputArea.setText(Hotel.searchRoom(3, amenityCombo.getValue(), 0));
                                    dialogStage.close();
                                }
                            });
                            break;
                    }
                }
                dialog.getChildren().add(submit);
            });
            
            dialog.getChildren().addAll(searchTypeCombo, submit);
            Scene dialogScene = new Scene(dialog, 300, 250);
            Stage dialogStage = new Stage();
            dialogStage.setScene(dialogScene);
            dialogStage.show();
        });
        
        bookRoomButton.setOnAction(e -> primaryStage.setScene(bookRoomScene));
        orderFoodButton.setOnAction(e -> primaryStage.setScene(orderFoodScene));
        roomServiceButton.setOnAction(e -> primaryStage.setScene(roomServiceScene));
        checkoutButton.setOnAction(e -> primaryStage.setScene(checkoutScene));
        manageAccountButton.setOnAction(e -> primaryStage.setScene(accountScene));
        adminPanelButton.setOnAction(e -> {
            if(Hotel.currentUser != null && Hotel.currentUser.isAdmin()) {
                primaryStage.setScene(adminScene);
            } else {
                outputArea.setText("Access denied. Admin privileges required.");
            }
        });
        logoutButton.setOnAction(e -> {
            Hotel.currentUser = null;
            primaryStage.setScene(loginScene);
            outputArea.clear();
        });
        
        mainMenuLayout.getChildren().addAll(
            new Label("Main Menu"),
            roomDetailsButton, availabilityButton, searchRoomButton, bookRoomButton,
            orderFoodButton, roomServiceButton, checkoutButton, manageAccountButton,
            adminPanelButton, logoutButton, outputArea
        );
        
        mainMenuScene = new Scene(mainMenuLayout, 600, 600);
        
        // Book Room Scene
        VBox bookRoomLayout = new VBox(10);
        bookRoomLayout.setPadding(new Insets(20));
        bookRoomLayout.setAlignment(Pos.CENTER);
        
        ComboBox<Integer> roomTypeCombo = new ComboBox<>();
        roomTypeCombo.getItems().addAll(1, 2, 3, 4);
        roomTypeCombo.setPromptText("Room Type");
        TextField roomNumberField = new TextField();
        roomNumberField.setPromptText("Room Number");
        TextField genderField = new TextField();
        genderField.setPromptText("Gender");
        TextField name2Field = new TextField();
        name2Field.setPromptText("Second Guest Name");
        TextField contact2Field = new TextField();
        contact2Field.setPromptText("Second Guest Contact");
        TextField gender2Field = new TextField();
        gender2Field.setPromptText("Second Guest Gender");
        Button bookButton = new Button("Book Room");
        Button backButton = new Button("Back");
        TextArea bookOutputArea = new TextArea();
        bookOutputArea.setEditable(false);
        
        roomTypeCombo.setOnAction(e -> {
            boolean isDoubleRoom = roomTypeCombo.getValue() != null && (roomTypeCombo.getValue() == 1 || roomTypeCombo.getValue() == 2);
            name2Field.setDisable(!isDoubleRoom);
            contact2Field.setDisable(!isDoubleRoom);
            gender2Field.setDisable(!isDoubleRoom);
        });
        
        bookButton.setOnAction(e -> {
            try {
                int roomType = roomTypeCombo.getValue() != null ? roomTypeCombo.getValue() : 0;
                int roomNumber = Integer.parseInt(roomNumberField.getText());
                String gender = genderField.getText();
                String name2 = name2Field.getText();
                String contact2 = contact2Field.getText();
                String gender2 = gender2Field.getText();
                
                String result = Hotel.bookroom(roomType, roomNumber, gender, name2, contact2, gender2);
                bookOutputArea.setText(result);
            } catch (NumberFormatException ex) {
                bookOutputArea.setText("Invalid room number");
            }
        });
        
        backButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        
        bookRoomLayout.getChildren().addAll(
            new Label("Book Room"),
            roomTypeCombo, roomNumberField, genderField, name2Field, contact2Field, gender2Field,
            bookButton, backButton, bookOutputArea
        );
        
        bookRoomScene = new Scene(bookRoomLayout, 600, 600);
        
        // Order Food Scene
        VBox orderFoodLayout = new VBox(10);
        orderFoodLayout.setPadding(new Insets(20));
        orderFoodLayout.setAlignment(Pos.CENTER);
        
        TextField foodRoomNumberField = new TextField();
        foodRoomNumberField.setPromptText("Room Number");
        ComboBox<Integer> foodItemCombo = new ComboBox<>();
        foodItemCombo.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        foodItemCombo.setPromptText("Food Item");
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        Button addFoodButton = new Button("Add Item");
        Button submitOrderButton = new Button("Submit Order");
        Button foodBackButton = new Button("Back");
        TextArea foodOutputArea = new TextArea();
        foodOutputArea.setEditable(false);
        
        List<int[]> foodOrders = new ArrayList<>();
        
        addFoodButton.setOnAction(e -> {
            try {
                int item = foodItemCombo.getValue() != null ? foodItemCombo.getValue() : 0;
                int quantity = Integer.parseInt(quantityField.getText());
                foodOrders.add(new int[]{item, quantity});
                foodOutputArea.setText("Added: Item " + item + ", Quantity: " + quantity);
                foodItemCombo.getSelectionModel().clearSelection();
                quantityField.clear();
            } catch (NumberFormatException ex) {
                foodOutputArea.setText("Invalid quantity");
            }
        });
        
        submitOrderButton.setOnAction(e -> {
            try {
                int roomNumber = Integer.parseInt(foodRoomNumberField.getText());
                int rtype, rn;
                if(roomNumber > 60 || roomNumber < 1) {
                    foodOutputArea.setText("Room doesn't exist");
                    return;
                } else if(roomNumber > 40) {
                    rtype = 4;
                    rn = roomNumber - 41;
                } else if(roomNumber > 30) {
                    rtype = 3;
                    rn = roomNumber - 31;
                } else if(roomNumber > 10) {
                    rtype = 2;
                    rn = roomNumber - 11;
                } else {
                    rtype = 1;
                    rn = roomNumber - 1;
                }
                
                String result = Hotel.order(rn, rtype, foodOrders);
                foodOutputArea.setText(result);
                foodOrders.clear();
            } catch (NumberFormatException ex) {
                foodOutputArea.setText("Invalid room number");
            }
        });
        
        foodBackButton.setOnAction(e -> {
            foodOrders.clear();
            primaryStage.setScene(mainMenuScene);
        });
        
        orderFoodLayout.getChildren().addAll(
            new Label("Order Food"),
            foodRoomNumberField, foodItemCombo, quantityField, addFoodButton,
            submitOrderButton, foodBackButton, foodOutputArea
        );
        
        orderFoodScene = new Scene(orderFoodLayout, 600, 600);
        
        // Room Service Scene
        VBox roomServiceLayout = new VBox(10);
        roomServiceLayout.setPadding(new Insets(20));
        roomServiceLayout.setAlignment(Pos.CENTER);
        
        TextField serviceRoomNumberField = new TextField();
        serviceRoomNumberField.setPromptText("Room Number");
        ComboBox<Integer> serviceTypeCombo = new ComboBox<>();
        serviceTypeCombo.getItems().addAll(1, 2, 3, 4, 5);
        serviceTypeCombo.setPromptText("Service Type");
        TextField specialRequestField = new TextField();
        specialRequestField.setPromptText("Special Request");
        TextField chargeField = new TextField();
        chargeField.setPromptText("Charge (for special request)");
        Button requestServiceButton = new Button("Request Service");
        Button serviceBackButton = new Button("Back");
        TextArea serviceOutputArea = new TextArea();
        serviceOutputArea.setEditable(false);
        
        serviceTypeCombo.setOnAction(e -> {
            boolean isSpecial = serviceTypeCombo.getValue() != null && serviceTypeCombo.getValue() == 5;
            specialRequestField.setDisable(!isSpecial);
            chargeField.setDisable(!isSpecial);
        });
        
        requestServiceButton.setOnAction(e -> {
            try {
                int roomNumber = Integer.parseInt(serviceRoomNumberField.getText());
                int serviceType = serviceTypeCombo.getValue() != null ? serviceTypeCombo.getValue() : 0;
                String specialRequest = specialRequestField.getText();
                float charge = serviceType == 5 ? Float.parseFloat(chargeField.getText()) : 0;
                
                int rtype, rn;
                if(roomNumber > 60 || roomNumber < 1) {
                    serviceOutputArea.setText("Room doesn't exist");
                    return;
                } else if(roomNumber > 40) {
                    rtype = 4;
                    rn = roomNumber - 41;
                } else if(roomNumber > 30) {
                    rtype = 3;
                    rn = roomNumber - 31;
                } else if(roomNumber > 10) {
                    rtype = 2;
                    rn = roomNumber - 11;
                } else {
                    rtype = 1;
                    rn = roomNumber - 1;
                }
                
                String result = Hotel.requestRoomService(rn, rtype, serviceType, specialRequest, charge);
                serviceOutputArea.setText(result);
            } catch (NumberFormatException ex) {
                serviceOutputArea.setText("Invalid input");
            }
        });
        
        serviceBackButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        
        roomServiceLayout.getChildren().addAll(
            new Label("Request Room Service"),
            serviceRoomNumberField, serviceTypeCombo, specialRequestField, chargeField,
            requestServiceButton, serviceBackButton, serviceOutputArea
        );
        
        roomServiceScene = new Scene(roomServiceLayout, 600, 600);
        
        // Checkout Scene
        VBox checkoutLayout = new VBox(10);
        checkoutLayout.setPadding(new Insets(20));
        checkoutLayout.setAlignment(Pos.CENTER);
        
        TextField checkoutRoomNumberField = new TextField();
        checkoutRoomNumberField.setPromptText("Room Number");
        CheckBox leaveReviewCheck = new CheckBox("Leave a Review");
        ComboBox<Integer> ratingCombo = new ComboBox<>();
        ratingCombo.getItems().addAll(1, 2, 3, 4, 5);
        ratingCombo.setPromptText("Rating");
        TextArea commentArea = new TextArea();
        commentArea.setPromptText("Comment");
        Button checkoutButton = new Button("Checkout");
        Button checkoutBackButton = new Button("Back");
        TextArea checkoutOutputArea = new TextArea();
        checkoutOutputArea.setEditable(false);
        
        leaveReviewCheck.setOnAction(e -> {
            ratingCombo.setDisable(!leaveReviewCheck.isSelected());
            commentArea.setDisable(!leaveReviewCheck.isSelected());
        });
        
        checkoutButton.setOnAction(e -> {
            try {
                int roomNumber = Integer.parseInt(checkoutRoomNumberField.getText());
                int rtype, rn;
                if(roomNumber > 60 || roomNumber < 1) {
                    checkoutOutputArea.setText("Room doesn't exist");
                    return;
                } else if(roomNumber > 40) {
                    rtype = 4;
                    rn = roomNumber - 41;
                } else if(roomNumber > 30) {
                    rtype = 3;
                    rn = roomNumber - 31;
                } else if(roomNumber > 10) {
                    rtype = 2;
                    rn = roomNumber - 11;
                } else {
                    rtype = 1;
                    rn = roomNumber - 1;
                }
                
                boolean leaveReview = leaveReviewCheck.isSelected();
                int rating = ratingCombo.getValue() != null ? ratingCombo.getValue() : 1;
                String comment = commentArea.getText();
                
                String result = Hotel.deallocate(rn, rtype, leaveReview, rating, comment);
                checkoutOutputArea.setText(result);
            } catch (NumberFormatException ex) {
                checkoutOutputArea.setText("Invalid room number");
            }
        });
        
        checkoutBackButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        
        checkoutLayout.getChildren().addAll(
            new Label("Checkout"),
            checkoutRoomNumberField, leaveReviewCheck, ratingCombo, commentArea,
            checkoutButton, checkoutBackButton, checkoutOutputArea
        );
        
        checkoutScene = new Scene(checkoutLayout, 600, 600);
        
        // Manage Account Scene
        VBox accountLayout = new VBox(10);
        accountLayout.setPadding(new Insets(20));
        accountLayout.setAlignment(Pos.CENTER);
        
        Button viewDetailsButton = new Button("View Account Details");
        Button viewHistoryButton = new Button("View Booking History");
        Button checkLoyaltyButton = new Button("Check Loyalty Points");
        Button viewReviewsButton = new Button("View Reviews");
        Button accountBackButton = new Button("Back");
        TextArea accountOutputArea = new TextArea();
        accountOutputArea.setEditable(false);
        
        viewDetailsButton.setOnAction(e -> {
            if(Hotel.currentUser != null) {
                accountOutputArea.setText(Hotel.currentUser.toString());
            } else {
                accountOutputArea.setText("You need to login first!");
            }
        });
        
        viewHistoryButton.setOnAction(e -> accountOutputArea.setText(Hotel.viewBookingHistory()));
        
        checkLoyaltyButton.setOnAction(e -> {
            if(Hotel.currentUser != null) {
                accountOutputArea.setText(
                    "Loyalty Program\nPoints: " + Hotel.currentUser.getLoyaltyPoints() +
                    "\nCurrent Discount: " + Hotel.currentUser.calculateDiscount() + "%" +
                    "\n\nDiscount Tiers:\n100+ points: 5% discount\n300+ points: 10% discount\n500+ points: 15% discount"
                );
            } else {
                accountOutputArea.setText("You need to login first!");
            }
        });
        
        viewReviewsButton.setOnAction(e -> {
            if(Hotel.hotel_ob.getReviews().isEmpty()) {
                accountOutputArea.setText("No reviews available.");
            } else {
                StringBuilder reviews = new StringBuilder("Hotel Reviews\nAverage Rating: " + String.format("%.1f", Hotel.hotel_ob.calculateAverageRating()) + "/5\n");
                for(Review review : Hotel.hotel_ob.getReviews()) {
                    reviews.append("\n").append(review).append("\n");
                }
                accountOutputArea.setText(reviews.toString());
            }
        });
        
        accountBackButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        
        accountLayout.getChildren().addAll(
            new Label("Manage Account"),
            viewDetailsButton, viewHistoryButton, checkLoyaltyButton, viewReviewsButton,
            accountBackButton, accountOutputArea
        );
        
        accountScene = new Scene(accountLayout, 600, 600);
        
        // Admin Panel Scene
        VBox adminLayout = new VBox(10);
        adminLayout.setPadding(new Insets(20));
        adminLayout.setAlignment(Pos.CENTER);
        
        Button viewRoomsButton = new Button("View All Rooms Status");
        Button viewUsersButton = new Button("View All Users");
        Button completeServiceButton = new Button("Complete Room Service");
        Button analyticsButton = new Button("View Hotel Analytics");
        Button adminBackButton = new Button("Back");
        TextArea adminOutputArea = new TextArea();
        adminOutputArea.setEditable(false);
        
        viewRoomsButton.setOnAction(e -> adminOutputArea.setText(Hotel.viewAllRoomsStatus()));
        viewUsersButton.setOnAction(e -> adminOutputArea.setText(Hotel.viewAllUsers()));
        
        completeServiceButton.setOnAction(e -> {
            TextField roomNumberField = new TextField();
            roomNumberField.setPromptText("Room Number");
            TextField serviceIdField = new TextField();
            serviceIdField.setPromptText("Service ID");
            Button submit = new Button("Complete Service");
            VBox dialog = new VBox(10, new Label("Complete Room Service"), roomNumberField, serviceIdField, submit);
            dialog.setPadding(new Insets(20));
            Scene dialogScene = new Scene(dialog, 300, 200);
            Stage dialogStage = new Stage();
            dialogStage.setScene(dialogScene);
            dialogStage.show();
            
            submit.setOnAction(se -> {
                try {
                    int roomNumber = Integer.parseInt(roomNumberField.getText());
                    int serviceId = Integer.parseInt(serviceIdField.getText());
                    int rtype, rn;
                    if(roomNumber > 60 || roomNumber < 1) {
                        adminOutputArea.setText("Room doesn't exist");
                        return;
                    } else if(roomNumber > 40) {
                        rtype = 4;
                        rn = roomNumber - 41;
                    } else if(roomNumber > 30) {
                        rtype = 3;
                        rn = roomNumber - 31;
                    } else if(roomNumber > 10) {
                        rtype = 2;
                        rn = roomNumber - 11;
                    } else {
                        rtype = 1;
                        rn = roomNumber - 1;
                    }
                    
                    String result = Hotel.completeRoomService(rn, rtype, serviceId);
                    adminOutputArea.setText(result);
                    dialogStage.close();
                } catch (NumberFormatException ex) {
                    adminOutputArea.setText("Invalid input");
                }
            });
        });
        
        analyticsButton.setOnAction(e -> adminOutputArea.setText(Hotel.hotelAnalytics()));
        adminBackButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        
        adminLayout.getChildren().addAll(
            new Label("Admin Panel"),
            viewRoomsButton, viewUsersButton, completeServiceButton, analyticsButton,
            adminBackButton, adminOutputArea
        );
        
        adminScene = new Scene(adminLayout, 600, 600);
    }
    
    public static void main(String[] args) {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.INFO);
        launch(args);
    }
}