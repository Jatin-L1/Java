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
import java.util.Scanner;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    static Scanner sc = new Scanner(System.in);
    static User currentUser = null;
    
    static boolean login() {
        System.out.print("\nEnter User ID: ");
        String userId = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();
        
        User user = hotel_ob.users.get(userId);
        if(user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("\nWelcome, " + user.getName() + "!");
            return true;
        } else {
            System.out.println("\nInvalid User ID or Password. Please try again.");
            return false;
        }
    }
    
    static void register() {
        System.out.print("\nEnter User ID: ");
        String userId = sc.next();
        
        if(hotel_ob.users.containsKey(userId)) {
            System.out.println("User ID already exists. Please choose another.");
            return;
        }
        
        System.out.print("Enter Password: ");
        String password = sc.next();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Contact: ");
        String contact = sc.next();
        System.out.print("Enter Email: ");
        String email = sc.next();
        
        boolean isAdmin = false;
        if(hotel_ob.users.isEmpty()) {
            System.out.print("This is the first user. Make this user an admin? (y/n): ");
            char choice = sc.next().charAt(0);
            isAdmin = (choice == 'y' || choice == 'Y');
        }
        
        User newUser = new User(userId, password, name, contact, email, isAdmin);
        hotel_ob.users.put(userId, newUser);
        System.out.println("\nRegistration successful. Please login.");
    }
    
    static void CustDetails(int i, int rn) {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            String name, contact, gender;
            String name2 = null, contact2 = null; 
            String gender2 = "";
            
            name = currentUser.getName();
            contact = currentUser.getContact();
            
            System.out.print("Enter gender: ");
            gender = sc.next();
            
            if(i < 3) {
                System.out.print("Enter second customer name: ");
                name2 = sc.next();
                System.out.print("Enter second customer contact number: ");
                contact2 = sc.next();
                System.out.print("Enter second customer gender: ");
                gender2 = sc.next();
            }
            
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
                    System.out.println("Wrong option");
                    break;
            }
        } catch (InvalidInputException e) {
            System.out.println(e);
            logger.log(Level.WARNING, "Invalid input during customer details entry", e);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.SEVERE, "Error during customer details entry", e);
        }
    }
    
    static void bookroom(int i) {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            int j;
            int rn;
            System.out.println("\nChoose room number from: ");
            
            switch (i) {
                case 1:
                    for(j = 0; j < hotel_ob.luxury_doublerrom.length; j++) {
                        if(hotel_ob.luxury_doublerrom[j] == null) {
                            System.out.print((j + 1) + ", ");
                        }
                    }
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        rn--;
                        if(rn < 0 || rn >= hotel_ob.luxury_doublerrom.length)
                            throw new InvalidInputException("Room number out of range");
                        
                        if(hotel_ob.luxury_doublerrom[rn] != null)
                            throw new NotAvailable();
                        
                        // Apply discount if eligible
                        int discount = currentUser.calculateDiscount();
                        if(discount > 0) {
                            System.out.println("Congratulations! You are eligible for a " + discount + "% discount.");
                            System.out.println("Standard rate: $4000");
                            System.out.println("Your discounted rate: $" + (4000 - (4000 * discount / 100)));
                        }
                        
                        CustDetails(i, rn);
                    } catch(InvalidInputException e) {
                        System.out.println(e);
                        return;
                    } catch(Exception e) {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                case 2:
                    for(j = 0; j < hotel_ob.deluxe_doublerrom.length; j++) {
                        if(hotel_ob.deluxe_doublerrom[j] == null) {
                            System.out.print((j + 11) + ", ");
                        }
                    }
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        rn = rn - 11;
                        if(rn < 0 || rn >= hotel_ob.deluxe_doublerrom.length)
                            throw new InvalidInputException("Room number out of range");
                        
                        if(hotel_ob.deluxe_doublerrom[rn] != null)
                            throw new NotAvailable();
                        
                        // Apply discount if eligible
                        int discount = currentUser.calculateDiscount();
                        if(discount > 0) {
                            System.out.println("Congratulations! You are eligible for a " + discount + "% discount.");
                            System.out.println("Standard rate: $3000");
                            System.out.println("Your discounted rate: $" + (3000 - (3000 * discount / 100)));
                        }
                        
                        CustDetails(i, rn);
                    } catch(InvalidInputException e) {
                        System.out.println(e);
                        return;
                    } catch(Exception e) {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                case 3:
                    for(j = 0; j < hotel_ob.luxury_singleerrom.length; j++) {
                        if(hotel_ob.luxury_singleerrom[j] == null) {
                            System.out.print((j + 31) + ", ");
                        }
                    }
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        rn = rn - 31;
                        if(rn < 0 || rn >= hotel_ob.luxury_singleerrom.length)
                            throw new InvalidInputException("Room number out of range");
                        
                        if(hotel_ob.luxury_singleerrom[rn] != null)
                            throw new NotAvailable();
                        
                        // Apply discount if eligible
                        int discount = currentUser.calculateDiscount();
                        if(discount > 0) {
                            System.out.println("Congratulations! You are eligible for a " + discount + "% discount.");
                            System.out.println("Standard rate: $2200");
                            System.out.println("Your discounted rate: $" + (2200 - (2200 * discount / 100)));
                        }
                        
                        CustDetails(i, rn);
                    } catch(InvalidInputException e) {
                        System.out.println(e);
                        return;
                    } catch(Exception e) {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                case 4:
                    for(j = 0; j < hotel_ob.deluxe_singleerrom.length; j++) {
                        if(hotel_ob.deluxe_singleerrom[j] == null) {
                            System.out.print((j + 41) + ", ");
                        }
                    }
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        rn = rn - 41;
                        if(rn < 0 || rn >= hotel_ob.deluxe_singleerrom.length)
                            throw new InvalidInputException("Room number out of range");
                        
                        if(hotel_ob.deluxe_singleerrom[rn] != null)
                            throw new NotAvailable();
                        
                        // Apply discount if eligible
                        int discount = currentUser.calculateDiscount();
                        if(discount > 0) {
                            System.out.println("Congratulations! You are eligible for a " + discount + "% discount.");
                            System.out.println("Standard rate: $1200");
                            System.out.println("Your discounted rate: $" + (1200 - (1200 * discount / 100)));
                        }
                        
                        CustDetails(i, rn);
                    } catch(InvalidInputException e) {
                        System.out.println(e);
                        return;
                    } catch(Exception e) {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
            
            System.out.println("Room Booked Successfully!");
            
        } catch (InvalidInputException e) {
            System.out.println(e);
            logger.log(Level.WARNING, "Invalid input during room booking", e);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.SEVERE, "Error during room booking", e);
        }
    }
    
    static void features(int i) {
        switch (i) {
            case 1:
                System.out.println("Room Type: Luxury Double Room");
                System.out.println("Number of double beds: 1");
                System.out.println("AC: Yes");
                System.out.println("Free breakfast: Yes");
                System.out.println("Wi-Fi: High-speed Premium");
                System.out.println("Room service: 24/7");
                System.out.println("Charge per day: $4000");
                break;
            case 2:
                System.out.println("Room Type: Deluxe Double Room");
                System.out.println("Number of double beds: 1");
                System.out.println("AC: No");
                System.out.println("Free breakfast: Yes");
                System.out.println("Wi-Fi: Standard");
                System.out.println("Room service: 12 hours");
                System.out.println("Charge per day: $3000");
                break;
            case 3:
                System.out.println("Room Type: Luxury Single Room");
                System.out.println("Number of single beds: 1");
                System.out.println("AC: Yes");
                System.out.println("Free breakfast: Yes");
                System.out.println("Wi-Fi: High-speed");
                System.out.println("Room service: 24/7");
                System.out.println("Charge per day: $2200");
                break;
            case 4:
                System.out.println("Room Type: Deluxe Single Room");
                System.out.println("Number of single beds: 1");
                System.out.println("AC: No");
                System.out.println("Free breakfast: Yes");
                System.out.println("Wi-Fi: Standard");
                System.out.println("Room service: Limited hours");
                System.out.println("Charge per day: $1200");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    
    static void availability(int i) {
        int j, count = 0;
        switch (i) {
            case 1:
                for(j = 0; j < hotel_ob.luxury_doublerrom.length; j++) {
                    if(hotel_ob.luxury_doublerrom[j] == null)
                        count++;
                }
                break;
            case 2:
                for(j = 0; j < hotel_ob.deluxe_doublerrom.length; j++) {
                    if(hotel_ob.deluxe_doublerrom[j] == null)
                        count++;
                }
                break;
            case 3:
                for(j = 0; j < hotel_ob.luxury_singleerrom.length; j++) {
                    if(hotel_ob.luxury_singleerrom[j] == null)
                        count++;
                }
                break;
            case 4:
                for(j = 0; j < hotel_ob.deluxe_singleerrom.length; j++) {
                    if(hotel_ob.deluxe_singleerrom[j] == null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available: " + count);
    }
    
    static void searchRoom() {
        try {
            System.out.println("\nRoom Search");
            System.out.println("1. Search by room type");
            System.out.println("2. Search by price range");
            System.out.println("3. Search by amenities");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.println("\nSelect room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    System.out.print("Enter your choice: ");
                    int roomType = sc.nextInt();
                    
                    if(roomType >= 1 && roomType <= 4) {
                        features(roomType);
                        availability(roomType);
                    } else {
                        System.out.println("Invalid room type");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter minimum price: $");
                    int minPrice = sc.nextInt();
                    System.out.print("Enter maximum price: $");
                    int maxPrice = sc.nextInt();
                    
                    System.out.println("\nRooms available in price range $" + minPrice + " - $" + maxPrice + ":");
                    
                    if(1200 >= minPrice && 1200 <= maxPrice) {
                        System.out.println("Deluxe Single Room - $1200 per night");
                        availability(4);
                    }
                    
                    if(2200 >= minPrice && 2200 <= maxPrice) {
                        System.out.println("Luxury Single Room - $2200 per night");
                        availability(3);
                    }
                    
                    if(3000 >= minPrice && 3000 <= maxPrice) {
                        System.out.println("Deluxe Double Room - $3000 per night");
                        availability(2);
                    }
                    
                    if(4000 >= minPrice && 4000 <= maxPrice) {
                        System.out.println("Luxury Double Room - $4000 per night");
                        availability(1);
                    }
                    break;
                    
                case 3:
                    System.out.println("\nSelect amenity:");
                    System.out.println("1. AC");
                    System.out.println("2. Premium Wi-Fi");
                    System.out.println("3. 24/7 Room Service");
                    System.out.print("Enter your choice: ");
                    int amenity = sc.nextInt();
                    
                    switch(amenity) {
                        case 1:
                            System.out.println("\nRooms with AC:");
                            System.out.println("1. Luxury Double Room - $4000 per night");
                            availability(1);
                            System.out.println("3. Luxury Single Room - $2200 per night");
                            availability(3);
                            break;
                            
                        case 2:
                            System.out.println("\nRooms with Premium Wi-Fi:");
                            System.out.println("1. Luxury Double Room - $4000 per night");
                            availability(1);
                            break;
                            
                        case 3:
                            System.out.println("\nRooms with 24/7 Room Service:");
                            System.out.println("1. Luxury Double Room - $4000 per night");
                            availability(1);
                            System.out.println("3. Luxury Single Room - $2200 per night");
                            availability(3);
                            break;
                            
                        default:
                            System.out.println("Invalid amenity option");
                    }
                    break;
                    
                default:
                    System.out.println("Invalid search option");
            }
        } catch (Exception e) {
            System.out.println("Error during room search: " + e.getMessage());
            logger.log(Level.WARNING, "Error during room search", e);
        }
    }
    
    static void bill(int rn, int rtype) {
        try {
            double amount = 0;
            String list[] = {"Sandwich", "Pasta", "Noodles", "Coke", "Pizza", "Burger", "Steak", "Water"};
            System.out.println("\n*******");
            System.out.println(" Bill:-");
            System.out.println("*******");
            
            // Apply discount if applicable
            int discount = 0;
            if(currentUser != null) {
                discount = currentUser.calculateDiscount();
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            // Calculate room charges based on stay duration
            Date checkoutDate = new Date();
            Date checkinDate = null;
            long stayDuration = 1; // Default to 1 day
            
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
                if(stayDuration < 1) stayDuration = 1; // Minimum 1 day charge
            }
            
            System.out.println("\nCheck-in Date: " + sdf.format(checkinDate));
            System.out.println("Check-out Date: " + sdf.format(checkoutDate));
            System.out.println("Stay Duration: " + stayDuration + " day(s)");
            
            switch(rtype) {
                case 1:
                    double roomCharge = 4000 * stayDuration;
                    amount += roomCharge;
                    System.out.println("\nRoom Charge - $" + roomCharge + " ($4000 x " + stayDuration + " days)");
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotel_ob.luxury_doublerrom[rn].food) {
                        amount += obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format, list[obb.itemno-1], obb.quantity, obb.price);
                    }
                    
                    // Room service charges
                    if(!hotel_ob.luxury_doublerrom[rn].services.isEmpty()) {
                        System.out.println("\n===============");
                        System.out.println("Room Services:- ");
                        System.out.println("===============");
                        System.out.println("Service              Charge");
                        System.out.println("-------------------------");
                        for(RoomService service : hotel_ob.luxury_doublerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                String format = "%-20s%-10s%n";
                                System.out.printf(format, service.getDescription(), service.getCharge());
                            }
                        }
                    }
                    break;
                    
                case 2:
                    roomCharge = 3000 * stayDuration;
                    amount += roomCharge;
                    System.out.println("\nRoom Charge - $" + roomCharge + " ($3000 x " + stayDuration + " days)");
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotel_ob.deluxe_doublerrom[rn].food) {
                        amount += obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format, list[obb.itemno-1], obb.quantity, obb.price);
                    }
                    
                    // Room service charges
                    if(!hotel_ob.deluxe_doublerrom[rn].services.isEmpty()) {
                        System.out.println("\n===============");
                        System.out.println("Room Services:- ");
                        System.out.println("===============");
                        System.out.println("Service              Charge");
                        System.out.println("-------------------------");
                        for(RoomService service : hotel_ob.deluxe_doublerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                String format = "%-20s%-10s%n";
                                System.out.printf(format, service.getDescription(), service.getCharge());
                            }
                        }
                    }
                    break;
                    
                case 3:
                    roomCharge = 2200 * stayDuration;
                    amount += roomCharge;
                    System.out.println("\nRoom Charge - $" + roomCharge + " ($2200 x " + stayDuration + " days)");
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotel_ob.luxury_singleerrom[rn].food) {
                        amount += obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format, list[obb.itemno-1], obb.quantity, obb.price);
                    }
                    
                    // Room service charges
                    if(!hotel_ob.luxury_singleerrom[rn].services.isEmpty()) {
                        System.out.println("\n===============");
                        System.out.println("Room Services:- ");
                        System.out.println("===============");
                        System.out.println("Service              Charge");
                        System.out.println("-------------------------");
                        for(RoomService service : hotel_ob.luxury_singleerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                String format = "%-20s%-10s%n";
                                System.out.printf(format, service.getDescription(), service.getCharge());
                            }
                        }
                    }
                    break;
                    
                case 4:
                    roomCharge = 1200 * stayDuration;
                    amount += roomCharge;
                    System.out.println("\nRoom Charge - $" + roomCharge + " ($1200 x " + stayDuration + " days)");
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb: hotel_ob.deluxe_singleerrom[rn].food) {
                        amount += obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format, list[obb.itemno-1], obb.quantity, obb.price);
                    }
                    
                    // Room service charges
                    if(!hotel_ob.deluxe_singleerrom[rn].services.isEmpty()) {
                        System.out.println("\n===============");
                        System.out.println("Room Services:- ");
                        System.out.println("===============");
                        System.out.println("Service              Charge");
                        System.out.println("-------------------------");
                        for(RoomService service : hotel_ob.deluxe_singleerrom[rn].services) {
                            if(service.isCompleted()) {
                                amount += service.getCharge();
                                String format = "%-20s%-10s%n";
                                System.out.printf(format, service.getDescription(), service.getCharge());
                            }
                        }
                    }
                    break;
                    
                default:
                    System.out.println("Not valid");
            }
            
            // Apply discount if eligible
            double finalAmount = amount;
            if(discount > 0) {
                double discountAmount = amount * discount / 100;
                finalAmount = amount - discountAmount;
                System.out.println("\nSubtotal Amount: $" + amount);
                System.out.println("Loyalty Discount (" + discount + "%): -$" + discountAmount);
            }
            
            System.out.println("\nFinal Amount: $" + finalAmount);
            
            // Ask for payment method
            System.out.println("\n=================");
            System.out.println("Payment Options:");
            System.out.println("=================");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3. Debit Card");
            System.out.println("4. Mobile Payment");
            System.out.print("\nSelect payment method: ");
            int paymentMethod = sc.nextInt();
            
            String paymentMethodStr = "";
            switch(paymentMethod) {
                case 1: paymentMethodStr = "Cash"; break;
                case 2: paymentMethodStr = "Credit Card"; break;
                case 3: paymentMethodStr = "Debit Card"; break;
                case 4: paymentMethodStr = "Mobile Payment"; break;
                default: paymentMethodStr = "Unknown";
            }
            
            System.out.println("\nPayment processed successfully via " + paymentMethodStr);
            System.out.println("Thank you for staying with us!");
            
            // Update the booking for the user
            if(currentUser != null) {
                String guestId = "";
                switch (rtype) {
                    case 1: guestId = hotel_ob.luxury_doublerrom[rn].guestId; break;
                    case 2: guestId = hotel_ob.deluxe_doublerrom[rn].guestId; break;
                    case 3: guestId = hotel_ob.luxury_singleerrom[rn].guestId; break;
                    case 4: guestId = hotel_ob.deluxe_singleerrom[rn].guestId; break;
                }
                
                // Find the booking and update
                for(Booking booking : currentUser.getBookingHistory()) {
                    if(booking.isActive() && booking.getRoomType() == rtype) {
                        booking.checkout(finalAmount);
                        break;
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error generating bill: " + e.getMessage());
            logger.log(Level.SEVERE, "Error generating bill", e);
        }
    }
    
    static void deallocate(int rn, int rtype) {
        int j;
        char w;
        try {
            switch (rtype) {
                case 1:               
                    if(hotel_ob.luxury_doublerrom[rn] != null)
                        System.out.println("Room used by " + hotel_ob.luxury_doublerrom[rn].name);                
                    else {    
                        System.out.println("Empty Already");
                        return;
                    }
                    
                    // Check if current user has permission
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.luxury_doublerrom[rn].guestId)) {
                        System.out.println("You don't have permission to check out this room.");
                        return;
                    }
                    
                    System.out.println("Do you want to checkout? (y/n)");
                    w = sc.next().charAt(0);
                    if(w == 'y' || w == 'Y') {
                        bill(rn, rtype);
                        
                        // Ask for review
                        askForReview();
                        
                        hotel_ob.luxury_doublerrom[rn] = null;
                        System.out.println("Deallocated successfully");
                    }
                    break;
                    
                case 2:
                    if(hotel_ob.deluxe_doublerrom[rn] != null)
                        System.out.println("Room used by " + hotel_ob.deluxe_doublerrom[rn].name);                
                    else { 
                        System.out.println("Empty Already");
                        return;
                    }
                    
                    // Check if current user has permission
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.deluxe_doublerrom[rn].guestId)) {
                        System.out.println("You don't have permission to check out this room.");
                        return;
                    }
                    
                    System.out.println("Do you want to checkout? (y/n)");
                    w = sc.next().charAt(0);
                    if(w == 'y' || w == 'Y') {
                        bill(rn, rtype);
                        
                        // Ask for review
                        askForReview();
                        
                        hotel_ob.deluxe_doublerrom[rn] = null;
                        System.out.println("Deallocated successfully");
                    }
                    break;
                    
                case 3:
                    if(hotel_ob.luxury_singleerrom[rn] != null)
                        System.out.println("Room used by " + hotel_ob.luxury_singleerrom[rn].name);                
                    else {    
                        System.out.println("Empty Already");
                        return;
                    }
                    
                    // Check if current user has permission
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.luxury_singleerrom[rn].guestId)) {
                        System.out.println("You don't have permission to check out this room.");
                        return;
                    }
                    
                    System.out.println("Do you want to checkout? (y/n)");
                    w = sc.next().charAt(0);
                    if(w == 'y' || w == 'Y') {
                        bill(rn, rtype);
                        
                        // Ask for review
                        askForReview();
                        
                        hotel_ob.luxury_singleerrom[rn] = null;
                        System.out.println("Deallocated successfully");
                    }
                    break;
                    
                case 4:
                    if(hotel_ob.deluxe_singleerrom[rn] != null)
                        System.out.println("Room used by " + hotel_ob.deluxe_singleerrom[rn].name);                
                    else {    
                        System.out.println("Empty Already");
                        return;
                    }
                    
                    // Check if current user has permission
                    if(currentUser != null && !currentUser.isAdmin() && 
                       !currentUser.getUserId().equals(hotel_ob.deluxe_singleerrom[rn].guestId)) {
                        System.out.println("You don't have permission to check out this room.");
                        return;
                    }
                    
                    System.out.println("Do you want to checkout? (y/n)");
                    w = sc.next().charAt(0);
                    if(w == 'y' || w == 'Y') {
                        bill(rn, rtype);
                        
                        // Ask for review
                        askForReview();
                        
                        hotel_ob.deluxe_singleerrom[rn] = null;
                        System.out.println("Deallocated successfully");
                    }
                    break;
                    
                default:
                    System.out.println("\nEnter valid option");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error during checkout: " + e.getMessage());
            logger.log(Level.SEVERE, "Error during checkout", e);
        }
    }
    
    static void askForReview() {
        try {
            System.out.println("\nWould you like to leave a review? (y/n)");
            char choice = sc.next().charAt(0);
            
            if(choice == 'y' || choice == 'Y') {
                sc.nextLine(); // Clear buffer
                
                System.out.println("\nPlease rate your stay (1-5 stars):");
                int rating = sc.nextInt();
                sc.nextLine(); // Clear buffer
                
                System.out.println("Please leave a comment:");
                String comment = sc.nextLine();
                
                // Create and add the review
                Review review = new Review(currentUser != null ? currentUser.getName() : "Anonymous", rating, comment);
                hotel_ob.addReview(review);
                
                System.out.println("\nThank you for your feedback!");
            }
        } catch (Exception e) {
            System.out.println("Error processing review: " + e.getMessage());
            logger.log(Level.WARNING, "Error processing review", e);
        }
    }
    
    static void order(int rn, int rtype) {
        int i, q;
        char wish;
        try {
            System.out.println("\n==========\n   Menu:  \n==========\n");
            System.out.println("1. Sandwich\t$50");
            System.out.println("2. Pasta\t$60");
            System.out.println("3. Noodles\t$70");
            System.out.println("4. Coke\t\t$30");
            System.out.println("5. Pizza\t$80");
            System.out.println("6. Burger\t$120");
            System.out.println("7. Steak\t$150");
            System.out.println("8. Water\t$40");
            
            do {
                System.out.print("\nEnter your choice: ");
                i = sc.nextInt();
                System.out.print("Enter quantity: ");
                q = sc.nextInt();
               
                switch(rtype) {
                    case 1: hotel_ob.luxury_doublerrom[rn].food.add(new Food(i, q));
                        break;
                    case 2: hotel_ob.deluxe_doublerrom[rn].food.add(new Food(i, q));
                        break;
                    case 3: hotel_ob.luxury_singleerrom[rn].food.add(new Food(i, q));
                        break;
                    case 4: hotel_ob.deluxe_singleerrom[rn].food.add(new Food(i, q));
                        break;                                                 
                }
                System.out.println("Do you want to order anything else? (y/n)");
                wish = sc.next().charAt(0); 
            } while(wish == 'y' || wish == 'Y');  
            
            System.out.println("\nThank you for your order!");
            System.out.println("Your food will be delivered to your room shortly.");
            
        } catch(NullPointerException e) {
            System.out.println("\nRoom not booked");
            logger.log(Level.WARNING, "Food order attempted for unbooked room", e);
        } catch(Exception e) {
            System.out.println("Error processing food order: " + e.getMessage());
            logger.log(Level.SEVERE, "Error processing food order", e);
        }
    }
    
    static void requestRoomService(int rn, int rtype) {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            System.out.println("\n=======================");
            System.out.println("   Room Service Menu   ");
            System.out.println("=======================");
            System.out.println("1. Room Cleaning - $30");
            System.out.println("2. Laundry Service - $50");
            System.out.println("3. Technical Support - $40");
            System.out.println("4. Extra Amenities - $25");
            System.out.println("5. Special Request - $Variable");
            
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            String description = "";
            float charge = 0;
            
            switch(choice) {
                case 1:
                    description = "Room Cleaning";
                    charge = 30;
                    break;
                case 2:
                    description = "Laundry Service";
                    charge = 50;
                    break;
                case 3:
                    description = "Technical Support";
                    charge = 40;
                    break;
                case 4:
                    description = "Extra Amenities";
                    charge = 25;
                    break;
                case 5:
                    sc.nextLine(); // Clear buffer
                    System.out.print("Enter special request description: ");
                    description = sc.nextLine();
                    System.out.print("Enter agreed charge: $");
                    charge = sc.nextFloat();
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }
            
            switch(rtype) {
                case 1:
                    hotel_ob.luxury_doublerrom[rn].requestService(description, charge);
                    break;
                case 2:
                    hotel_ob.deluxe_doublerrom[rn].requestService(description, charge);
                    break;
                case 3:
                    hotel_ob.luxury_singleerrom[rn].requestService(description, charge);
                    break;
                case 4:
                    hotel_ob.deluxe_singleerrom[rn].requestService(description, charge);
                    break;
            }
            
            System.out.println("\nRoom service request submitted successfully!");
            System.out.println("Service: " + description);
            System.out.println("Charge: $" + charge);
            
        } catch(NullPointerException e) {
            System.out.println("\nRoom not booked");
            logger.log(Level.WARNING, "Room service requested for unbooked room", e);
        } catch(Exception e) {
            System.out.println("Error requesting room service: " + e.getMessage());
            logger.log(Level.SEVERE, "Error requesting room service", e);
        }
    }
    
    static void completeRoomService(int rn, int rtype) {
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
                System.out.println("No room service requests for this room.");
                return;
            }
            
            System.out.println("\nPending Room Services:");
            boolean hasPending = false;
            
            for(RoomService service : services) {
                if(!service.isCompleted()) {
                    System.out.println(service.getServiceId() + ". " + service.getDescription() + " - $" + service.getCharge());
                    hasPending = true;
                }
            }
            
            if(!hasPending) {
                System.out.println("No pending room service requests for this room.");
                return;
            }
            
            System.out.print("\nEnter service ID to mark as complete: ");
            int serviceId = sc.nextInt();
            
            boolean found = false;
            for(RoomService service : services) {
                if(service.getServiceId() == serviceId && !service.isCompleted()) {
                    service.completeService();
                    System.out.println("Service marked as complete!");
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                System.out.println("Invalid service ID or service already completed.");
            }
            
        } catch(InvalidInputException e) {
            System.out.println(e);
            logger.log(Level.WARNING, "Unauthorized attempt to complete room service", e);
        } catch(Exception e) {
            System.out.println("Error completing room service: " + e.getMessage());
            logger.log(Level.SEVERE, "Error completing room service", e);
        }
    }
    
    static void viewBookingHistory() {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            List<Booking> bookings = currentUser.getBookingHistory();
            
            if(bookings.isEmpty()) {
                System.out.println("\nNo booking history found.");
                return;
            }
            
            System.out.println("\n====================");
            System.out.println("  Booking History  ");
            System.out.println("====================");
            
            for(Booking booking : bookings) {
                System.out.println("\n" + booking);
            }
            
        } catch(InvalidInputException e) {
            System.out.println(e);
            logger.log(Level.WARNING, "Unauthorized attempt to view booking history", e);
        } catch(Exception e) {
            System.out.println("Error viewing booking history: " + e.getMessage());
            logger.log(Level.SEVERE, "Error viewing booking history", e);
        }
    }
    
    static void manageAccount() {
        try {
            if(currentUser == null) {
                throw new InvalidInputException("You need to login first!");
            }
            
            boolean exit = false;
            
            while(!exit) {
                System.out.println("\n=================");
                System.out.println("  Account Menu  ");
                System.out.println("=================");
                System.out.println("1. View Account Details");
                System.out.println("2. View Booking History");
                System.out.println("3. Check Loyalty Points");
                System.out.println("4. View Reviews");
                System.out.println("5. Back to Main Menu");
                
                System.out.print("\nEnter your choice: ");
                int choice = sc.nextInt();
                
                switch(choice) {
                    case 1:
                        System.out.println("\n" + currentUser);
                        break;
                        
                    case 2:
                        viewBookingHistory();
                        break;
                        
                    case 3:
                        System.out.println("\nLoyalty Program");
                        System.out.println("Points: " + currentUser.getLoyaltyPoints());
                        System.out.println("Current Discount: " + currentUser.calculateDiscount() + "%");
                        System.out.println("\nDiscount Tiers:");
                        System.out.println("100+ points: 5% discount");
                        System.out.println("300+ points: 10% discount");
                        System.out.println("500+ points: 15% discount");
                        break;
                        
                    case 4:
                        if(hotel_ob.getReviews().isEmpty()) {
                            System.out.println("\nNo reviews available.");
                        } else {
                            System.out.println("\nHotel Reviews");
                            System.out.println("Average Rating: " + String.format("%.1f", hotel_ob.calculateAverageRating()) + "/5");
                            
                            for(Review review : hotel_ob.getReviews()) {
                                System.out.println("\n" + review);
                            }
                        }
                        break;
                        
                    case 5:
                        exit = true;
                        break;
                        
                    default:
                        System.out.println("Invalid choice");
                }
            }
            
        } catch(InvalidInputException e) {
            System.out.println(e);
            logger.log(Level.WARNING, "Unauthorized account management attempt", e);
        } catch(Exception e) {
            System.out.println("Error in account management: " + e.getMessage());
            logger.log(Level.SEVERE, "Error in account management", e);
        }
    }
    
    static void adminPanel() {
        try {
            if(currentUser == null || !currentUser.isAdmin()) {
                throw new InvalidInputException("Access denied. Admin privileges required.");
            }
            
            boolean exit = false;
            
            while(!exit) {
                System.out.println("\n=================");
                System.out.println("   Admin Panel  ");
                System.out.println("=================");
                System.out.println("1. View All Rooms Status");
                System.out.println("2. View All Users");
                System.out.println("3. Complete Room Service");
                System.out.println("4. View Hotel Analytics");
                System.out.println("5. Back to Main Menu");
                
                System.out.print("\nEnter your choice: ");
                int choice = sc.nextInt();
                
                switch(choice) {
                    case 1:
                        viewAllRoomsStatus();
                        break;
                        
                    case 2:
                        viewAllUsers();
                        break;
                        
                    case 3:
                        System.out.print("\nEnter room number: ");
                        int roomNum = sc.nextInt();
                        
                        if(roomNum > 60) {
                            System.out.println("Room doesn't exist");
                        } else if(roomNum > 40) {
                            completeRoomService(roomNum - 41, 4);
                        } else if(roomNum > 30) {
                            completeRoomService(roomNum - 31, 3);
                        } else if(roomNum > 10) {
                            completeRoomService(roomNum - 11, 2);
                        } else if(roomNum > 0) {
                            completeRoomService(roomNum - 1, 1);
                        } else {
                            System.out.println("Room doesn't exist");
                        }
                        break;
                        
                    case 4:
                        hotelAnalytics();
                        break;
                        
                    case 5:
                        exit = true;
                        break;
                        
                    default:
                        System.out.println("Invalid choice");
                }
            }
            
        } catch(InvalidInputException e) {
            System.out.println(e);
            logger.log(Level.WARNING, "Unauthorized admin panel access attempt", e);
        } catch(Exception e) {
            System.out.println("Error in admin panel: " + e.getMessage());
            logger.log(Level.SEVERE, "Error in admin panel", e);
        }
    }
    
    // Completing the viewAllRoomsStatus() method
static void viewAllRoomsStatus() {
    System.out.println("\n====================");
    System.out.println("   All Rooms Status  ");
    System.out.println("====================");
    
    // Luxury Double Rooms
    System.out.println("\nLuxury Double Rooms:");
    for(int i = 0; i < hotel_ob.luxury_doublerrom.length; i++) {
        System.out.print("Room " + (i + 1) + ": ");
        if(hotel_ob.luxury_doublerrom[i] == null) {
            System.out.println("Available");
        } else {
            System.out.println("Occupied by " + hotel_ob.luxury_doublerrom[i].name);
        }
    }
    
    // Deluxe Double Rooms
    System.out.println("\nDeluxe Double Rooms:");
    for(int i = 0; i < hotel_ob.deluxe_doublerrom.length; i++) {
        System.out.print("Room " + (i + 11) + ": ");
        if(hotel_ob.deluxe_doublerrom[i] == null) {
            System.out.println("Available");
        } else {
            System.out.println("Occupied by " + hotel_ob.deluxe_doublerrom[i].name);
        }
    }
    
    // Luxury Single Rooms
    System.out.println("\nLuxury Single Rooms:");
    for(int i = 0; i < hotel_ob.luxury_singleerrom.length; i++) {
        System.out.print("Room " + (i + 31) + ": ");
        if(hotel_ob.luxury_singleerrom[i] == null) {
            System.out.println("Available");
        } else {
            System.out.println("Occupied by " + hotel_ob.luxury_singleerrom[i].name);
        }
    }
    
    // Deluxe Single Rooms
    System.out.println("\nDeluxe Single Rooms:");
    for(int i = 0; i < hotel_ob.deluxe_singleerrom.length; i++) {
        System.out.print("Room " + (i + 41) + ": ");
        if(hotel_ob.deluxe_singleerrom[i] == null) {
            System.out.println("Available");
        } else {
            System.out.println("Occupied by " + hotel_ob.deluxe_singleerrom[i].name);
        }
    }
}

static void viewAllUsers() {
    System.out.println("\n====================");
    System.out.println("   All Users  ");
    System.out.println("====================");
    
    if(hotel_ob.users.isEmpty()) {
        System.out.println("No users registered.");
        return;
    }
    
    for(Map.Entry<String, User> entry : hotel_ob.users.entrySet()) {
        User user = entry.getValue();
        System.out.println("\nUser ID: " + user.getUserId());
        System.out.println("Name: " + user.getName());
        System.out.println("Contact: " + user.getContact());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Role: " + (user.isAdmin() ? "Admin" : "Guest"));
        System.out.println("Loyalty Points: " + user.getLoyaltyPoints());
        System.out.println("Active Bookings: " + user.getBookingHistory().stream().filter(Booking::isActive).count());
    }
}

static void hotelAnalytics() {
    System.out.println("\n====================");
    System.out.println("   Hotel Analytics  ");
    System.out.println("====================");
    
    // Room occupancy stats
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
    
    System.out.println("\nRoom Occupancy:");
    System.out.println("Luxury Double: " + luxDoubleFilled + "/" + luxDoubleTotal + 
                      " (" + (luxDoubleTotal > 0 ? (luxDoubleFilled * 100 / luxDoubleTotal) : 0) + "%)");
    System.out.println("Deluxe Double: " + deluxDoubleFilled + "/" + deluxDoubleTotal + 
                      " (" + (deluxDoubleTotal > 0 ? (deluxDoubleFilled * 100 / deluxDoubleTotal) : 0) + "%)");
    System.out.println("Luxury Single: " + luxSingleFilled + "/" + luxSingleTotal + 
                      " (" + (luxSingleTotal > 0 ? (luxSingleFilled * 100 / luxSingleTotal) : 0) + "%)");
    System.out.println("Deluxe Single: " + deluxSingleFilled + "/" + deluxSingleTotal + 
                      " (" + (deluxSingleTotal > 0 ? (deluxSingleFilled * 100 / deluxSingleTotal) : 0) + "%)");
    System.out.println("Total: " + occupiedRooms + "/" + totalRooms + 
                      " (" + (totalRooms > 0 ? (occupiedRooms * 100 / totalRooms) : 0) + "%)");
    
    // User statistics
    int totalUsers = hotel_ob.users.size();
    int activeBookings = 0;
    
    for(User user : hotel_ob.users.values()) {
        for(Booking booking : user.getBookingHistory()) {
            if(booking.isActive()) activeBookings++;
        }
    }
    
    System.out.println("\nUser Statistics:");
    System.out.println("Total Registered Users: " + totalUsers);
    System.out.println("Active Bookings: " + activeBookings);
    
    // Review statistics
    if(!hotel_ob.reviews.isEmpty()) {
        System.out.println("\nReview Statistics:");
        System.out.println("Total Reviews: " + hotel_ob.reviews.size());
        System.out.println("Average Rating: " + String.format("%.1f", hotel_ob.calculateAverageRating()) + "/5");
        
        // Count by rating
        int[] ratingCounts = new int[6]; // Index 0 not used
        for(Review review : hotel_ob.reviews) {
            ratingCounts[review.getRating()]++;
        }
        
        for(int i = 5; i >= 1; i--) {
            System.out.println(i + " Star: " + ratingCounts[i] + " reviews");
        }
    } else {
        System.out.println("\nNo reviews available.");
    }
}

static void writeToFile() {
    try {
        File file = new File("hotel_data.ser");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hotel_ob);
        oos.close();
        System.out.println("Data saved successfully!");
        
    } catch (Exception e) {
        System.out.println("Error saving data: " + e.getMessage());
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
            System.out.println("Data loaded successfully!");
        }
        
    } catch (Exception e) {
        System.out.println("Error loading data: " + e.getMessage());
        logger.log(Level.SEVERE, "Error loading data from file", e);
    }
}

public static void main(String[] args) {
    try {
        // Setup logger
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.INFO);
        
        // Load data from file if exists
        readFromFile();
        
        int ch, ch2;
        char wish;
        
        System.out.println("\nWelcome to Hotel Management System");
        
        do {
            System.out.println("\n=======================");
            System.out.println("   Main Menu Options   ");
            System.out.println("=======================");
            System.out.println("1. User Login");
            System.out.println("2. Register New User");
            System.out.println("3. Display Room Details");
            System.out.println("4. Display Room Availability");
            System.out.println("5. Search Rooms");
            System.out.println("6. Book Room");
            System.out.println("7. Order Food");
            System.out.println("8. Request Room Service");
            System.out.println("9. Checkout");
            System.out.println("10. Manage Account");
            System.out.println("11. Admin Panel");
            System.out.println("12. Exit");
            
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            
            switch(ch) {
                case 1:
                    login();
                    break;
                    
                case 2:
                    register();
                    break;
                    
                case 3:
                    System.out.println("\nChoose room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    System.out.print("\nEnter your choice: ");
                    ch2 = sc.nextInt();
                    features(ch2);
                    break;
                    
                case 4:
                    System.out.println("\nChoose room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    System.out.print("\nEnter your choice: ");
                    ch2 = sc.nextInt();
                    availability(ch2);
                    break;
                    
                case 5:
                    searchRoom();
                    break;
                    
                case 6:
                    System.out.println("\nChoose room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    System.out.print("\nEnter your choice: ");
                    ch2 = sc.nextInt();
                    bookroom(ch2);                     
                    break;
                    
                case 7:
                    System.out.print("\nEnter room number: ");
                    ch2 = sc.nextInt();
                    if(ch2 > 60) {
                        System.out.println("Room doesn't exist");
                    } else if(ch2 > 40) {
                        order(ch2 - 41, 4);
                    } else if(ch2 > 30) {
                        order(ch2 - 31, 3);
                    } else if(ch2 > 10) {
                        order(ch2 - 11, 2);
                    } else if(ch2 > 0) {
                        order(ch2 - 1, 1);
                    } else {
                        System.out.println("Room doesn't exist");
                    }
                    break;
                    
                case 8:
                    System.out.print("\nEnter room number: ");
                    ch2 = sc.nextInt();
                    if(ch2 > 60) {
                        System.out.println("Room doesn't exist");
                    } else if(ch2 > 40) {
                        requestRoomService(ch2 - 41, 4);
                    } else if(ch2 > 30) {
                        requestRoomService(ch2 - 31, 3);
                    } else if(ch2 > 10) {
                        requestRoomService(ch2 - 11, 2);
                    } else if(ch2 > 0) {
                        requestRoomService(ch2 - 1, 1);
                    } else {
                        System.out.println("Room doesn't exist");
                    }
                    break;
                    
                case 9:
                    System.out.print("\nEnter room number: ");
                    ch2 = sc.nextInt();
                    if(ch2 > 60) {
                        System.out.println("Room doesn't exist");
                    } else if(ch2 > 40) {
                        deallocate(ch2 - 41, 4);
                    } else if(ch2 > 30) {
                        deallocate(ch2 - 31, 3);
                    } else if(ch2 > 10) {
                        deallocate(ch2 - 11, 2);
                    } else if(ch2 > 0) {
                        deallocate(ch2 - 1, 1);
                    } else {
                        System.out.println("Room doesn't exist");
                    }
                    break;
                    
                case 10:
                    manageAccount();
                    break;
                    
                case 11:
                    adminPanel();
                    break;
                    
                case 12:
                    writeToFile();
                    System.out.println("\nThank you for using Hotel Management System!");
                    break;
                    
                default:
                    System.out.println("Invalid option");
                    break;
            }
            
            if(ch != 12) {
                System.out.println("\nContinue? (y/n)");
                wish = sc.next().charAt(0);
                if(wish == 'n' || wish == 'N') {
                    writeToFile();
                    System.out.println("\nThank you for using Hotel Management System!");
                    break;
                }
            } else {
                break;
            }
            
        } while(true);
        
    } catch(Exception e) {
        System.out.println("Error in main function: " + e.getMessage());
        logger.log(Level.SEVERE, "Critical error in main function", e);
    } finally {
        sc.close();
    }
}
}