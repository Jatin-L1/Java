import java.util.*; // 
import java.io.*; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(); 
        hotel.start(); 
    }
}

// Hotel class managing the overall system
class Hotel {
    private RoomManager roomManager;
    private CustomerManager customerManager;
    private StaffManager staffManager; // private object declared
    private AdminManager adminManager;
    private Scanner scanner;

    public Hotel() {
        roomManager = new RoomManager();
        customerManager = new CustomerManager(roomManager);
        staffManager = new StaffManager();
        adminManager = new AdminManager(roomManager, staffManager);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to Hotel Management System");
            System.out.println("Are you a:");
            System.out.println("0. Exit");
            System.out.println("1. Customer");
            System.out.println("2. Staff/Employee");
            System.out.println("3. Admin");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput(0, 3);
            if (choice == 0) {
                System.out.println("Thank you for using the Hotel Management System!");
                break;
            }

            switch (choice) {
                case 1:
                    customerManager.customerMenu();
                    break;
                case 2:
                    staffManager.staffMenu();
                    break;
                case 3:
                    adminManager.adminMenu();
                    break;
            }
        }
    }

    private int getValidIntInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }
}

// Room class representing a hotel room
class Room {
    private int roomNo;
    private String type; // instance variable or user defined variable
    private double price;
    private List<String> accessories;
    private boolean isAvailable;

    public Room(int roomNo, String type, double price, List<String> accessories) { // parameterized constructor
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        this.accessories = accessories;
        this.isAvailable = true;
    }

    // Getters and Setters
    public int getRoomNo() { return roomNo; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public List<String> getAccessories() { return accessories; } // getters and setters
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public void setPrice(double price) { this.price = price; }
    public void setAccessories(List<String> accessories) { this.accessories = accessories; }
}

// Dish class representing a food item
class Dish {
    private String name;
    private double price;
    private String description; // instance variable
    // user defined variable
    private int stock;

    public Dish(String name, double price, String description, int stock) { // parameterized constructor
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    // Getters and Setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public String getDescription() { return description; }
    public void setStock(int stock) { this.stock = stock; }
    public void setPrice(double price) { this.price = price; }
}

// RoomManager using Binary Search Tree for efficient searching
class RoomManager {
    private class RoomNode {
        Room room;
        RoomNode left, right;
        RoomNode(Room room) {
            this.room = room;
        }
    }
    private RoomNode root; // root node of the BST
    private List<Booking> bookings; // list of bookings
    public RoomManager() {
        bookings = new ArrayList<>(); // Initialize bookings list
        addRoom(new Room(101, "Single", 100.0, Arrays.asList("WiFi", "TV")));
        addRoom(new Room(102, "Double", 150.0, Arrays.asList("WiFi", "TV", "AC")));
        addRoom(new Room(201, "Suite", 300.0, Arrays.asList("WiFi", "TV", "AC", "MiniBar")));
    }
    public void addRoom(Room room) {
        root = insert(root, room);
    }
    private RoomNode insert(RoomNode node, Room room) {
        if (node == null) {
            return new RoomNode(room);
        }
        if (room.getPrice() < node.room.getPrice()) {
            node.left = insert(node.left, room);
        } else {
            node.right = insert(node.right, room);
        }
        return node;
    }
    public List<Room> findAvailableRooms(double minBudget, double maxBudget, int persons, List<String> accessories) {
        List<Room> availableRooms = new ArrayList<>();
        findAvailableRooms(root, minBudget, maxBudget, persons, accessories, availableRooms);
        return availableRooms;
    }
    private void findAvailableRooms(RoomNode node, double minBudget, double maxBudget, int persons, List<String> accessories, List<Room> result) {
        if (node == null) return;
        Room room = node.room;
        if (room.isAvailable() && room.getPrice() >= minBudget && room.getPrice() <= maxBudget) {
            if (room.getAccessories().containsAll(accessories)) {
                result.add(room);
            }
        }
        findAvailableRooms(node.left, minBudget, maxBudget, persons, accessories, result);
        findAvailableRooms(node.right, minBudget, maxBudget, persons, accessories, result);
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.getRoom().setAvailable(false);
    }
    public List<Booking> getAllBookings() {
        return bookings;
    }
    public Room findRoomByNumber(int roomNo) {
        return findRoomByNumber(root, roomNo);
    }
    private Room findRoomByNumber(RoomNode node, int roomNo) {
        if (node == null) return null;
        if (node.room.getRoomNo() == roomNo) return node.room;
        Room left = findRoomByNumber(node.left, roomNo);
        if (left != null) return left;
        return findRoomByNumber(node.right, roomNo);
    }
}

// Booking class
class Booking {
    private Customer customer;
    private Room room;
    private LocalDateTime bookingTime;

    public Booking(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
        this.bookingTime = LocalDateTime.now();
    }

    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public LocalDateTime getBookingTime() { return bookingTime; }
}

// Customer class using LinkedList
class Customer {
    private String name;
    private String phone;
    private List<Order> orders;
    private List<ServiceRequest> serviceRequests;
    private List<Feedback> feedback;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.orders = new ArrayList<>();
        this.serviceRequests = new ArrayList<>();
        this.feedback = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public List<Order> getOrders() { return orders; }
    public List<ServiceRequest> getServiceRequests() { return serviceRequests; }
    public List<Feedback> getFeedback() { return feedback; }

    public void addOrder(Order order) { orders.add(order); }
    public void addServiceRequest(ServiceRequest request) { serviceRequests.add(request); }
    public void addFeedback(Feedback feedback) { this.feedback.add(feedback); }
}

// Order class for food orders
class Order {
    private List<Dish> dishes;
    private double tip;
    private String specialRequest;
    private LocalDateTime orderTime;

    public Order() {
        this.dishes = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addDish(Dish dish) { dishes.add(dish); }
    public void setTip(double tip) { this.tip = tip; }
    public void setSpecialRequest(String request) { this.specialRequest = request; }
    public List<Dish> getDishes() { return dishes; }
    public double getTip() { return tip; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public double getTotal() {
        return dishes.stream().mapToDouble(Dish::getPrice).sum() + tip;
    }
}

// ServiceRequest class
class ServiceRequest {
    private String type;
    private int roomNo;
    private LocalDateTime requestTime;
    private String status;

    public ServiceRequest(String type, int roomNo) {
        this.type = type;
        this.roomNo = roomNo;
        this.requestTime = LocalDateTime.now();
        this.status = "Pending";
    }

    public String getType() { return type; }
    public int getRoomNo() { return roomNo; }
    public LocalDateTime getRequestTime() { return requestTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// Feedback class
class Feedback {
    private int foodRating;
    private int serviceRating;
    private int overallRating;
    private String comments;
    private LocalDateTime feedbackTime;

    public Feedback(int foodRating, int serviceRating, int overallRating, String comments) {
        this.foodRating = foodRating;
        this.serviceRating = serviceRating;
        this.overallRating = overallRating;
        this.comments = comments;
        this.feedbackTime = LocalDateTime.now();
    }

    public int getFoodRating() { return foodRating; }
    public int getServiceRating() { return serviceRating; }
    public int getOverallRating() { return overallRating; }
    public String getComments() { return comments; }
}

// CustomerManager handling customer operations
class CustomerManager {
    private LinkedList<Customer> customers;
    private RoomManager roomManager;
    private List<Dish> menu;
    private Queue<Order> orderQueue;
    private Queue<ServiceRequest> serviceQueue;
    private Scanner scanner;

    public CustomerManager(RoomManager roomManager) {
        this.customers = new LinkedList<>();
        this.roomManager = roomManager;
        this.menu = new ArrayList<>();
        this.orderQueue = new LinkedList<>();
        this.serviceQueue = new LinkedList<>();
        this.scanner = new Scanner(System.in);
        // Initialize sample menu
        menu.add(new Dish("Pizza", 15.0, "Margherita Pizza", 10));
        menu.add(new Dish("Pasta", 12.0, "Creamy Alfredo Pasta", 15));
        menu.add(new Dish("Salad", 8.0, "Caesar Salad", 20));
    }

    public void customerMenu() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, phone);
        customers.add(customer);

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Book a Room");
            System.out.println("2. Order Food");
            System.out.println("3. Request Additional Service");
            System.out.println("4. View Bill");
            System.out.println("5. Feedback/Rating");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput(1, 6);
            if (choice == 6) break;

            switch (choice) {
                case 1:
                    bookRoom(customer);
                    break;
                case 2:
                    orderFood(customer);
                    break;
                case 3:
                    requestService(customer);
                    break;
                case 4:
                    viewBill(customer);
                    break;
                case 5:
                    provideFeedback(customer);
                    break;
            }
        }
    }

    private void bookRoom(Customer customer) {
        System.out.print("Enter minimum budget: ");
        double minBudget = scanner.nextDouble();
        System.out.print("Enter maximum budget: ");
        double maxBudget = scanner.nextDouble();
        System.out.print("Enter number of persons: ");
        int persons = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter required accessories (comma-separated, e.g., WiFi,TV): ");
        String[] accessories = scanner.nextLine().split(","); // yeh regex hain joki spilt karta hain string ko array main
        List<String> accessoryList = Arrays.asList(accessories);

        List<Room> availableRooms = roomManager.findAvailableRooms(minBudget, maxBudget, persons, accessoryList);
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available matching your criteria.");
            return;
        }

        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < availableRooms.size(); i++) {
            Room room = availableRooms.get(i);
            System.out.printf("%d. Room %d (%s) - $%.2f, Accessories: %s\n",
                    i + 1, room.getRoomNo(), room.getType(), room.getPrice(), room.getAccessories());
        }

        System.out.print("Select a room (1-" + availableRooms.size() + "): ");
        int roomChoice = getValidIntInput(1, availableRooms.size());
        Room selectedRoom = availableRooms.get(roomChoice - 1);

        // OTP Verification
        Random rand = new Random();
        int otp = rand.nextInt(9000) + 1000;
        System.out.println("Your OTP is: " + otp);
        System.out.print("Enter OTP to confirm booking: ");
        int userOtp = scanner.nextInt();
        scanner.nextLine();

        if (userOtp == otp) {
            roomManager.addBooking(new Booking(customer, selectedRoom));
            System.out.println("Room booked successfully! Added to check-in queue.");
        } else {
            System.out.println("Invalid OTP. Booking cancelled.");
        }
    }

    private void orderFood(Customer customer) {
        Order order = new Order();
        while (true) {
            System.out.println("\nMenu:");
            for (int i = 0; i < menu.size(); i++) {
                Dish dish = menu.get(i);
                System.out.printf("%d. %s - $%.2f (%s, Stock: %d)\n",
                        i + 1, dish.getName(), dish.getPrice(), dish.getDescription(), dish.getStock());
            }
            System.out.println("0. Finish Order");
            System.out.print("Select an item to add (0-" + menu.size() + "): ");

            int choice = getValidIntInput(0, menu.size());
            if (choice == 0) break;

            Dish selectedDish = menu.get(choice - 1);
            if (selectedDish.getStock() > 0) {
                order.addDish(selectedDish);
                selectedDish.setStock(selectedDish.getStock() - 1);
                System.out.println(selectedDish.getName() + " added to order.");
            } else {
                System.out.println("Sorry, " + selectedDish.getName() + " is out of stock.");
            }
        }

        if (!order.getDishes().isEmpty()) {
            System.out.print("Enter tip amount (optional, enter 0 for none): ");
            double tip = scanner.nextDouble();
            scanner.nextLine();
            order.setTip(tip);

            System.out.print("Enter special requests (optional, press enter to skip): ");
            String specialRequest = scanner.nextLine();
            if (!specialRequest.isEmpty()) {
                order.setSpecialRequest(specialRequest);
            }

            customer.addOrder(order);
            orderQueue.add(order);
            System.out.println("Order placed successfully!");
        }
    }

    private void requestService(Customer customer) {
        System.out.println("\nSelect Service:");
        System.out.println("1. Laundry");
        System.out.println("2. Cleaning");
        System.out.println("3. Wake-up Call");
        System.out.println("4. Others");
        System.out.print("Enter choice (1-4): ");

        int choice = getValidIntInput(1, 4);
        String serviceType;
        switch (choice) {
            case 1: serviceType = "Laundry"; break;
            case 2: serviceType = "Cleaning"; break;
            case 3: serviceType = "Wake-up Call"; break;
            default:
                System.out.print("Enter service description: ");
                serviceType = scanner.nextLine();
                break;
        }

        System.out.print("Enter room number: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        ServiceRequest request = new ServiceRequest(serviceType, roomNo);
        customer.addServiceRequest(request);
        serviceQueue.add(request);
        System.out.println("Service request submitted successfully!");
    }

    private void viewBill(Customer customer) {
        double total = 0;
        System.out.println("\n=== Bill for " + customer.getName() + " ===");
        
        // Room charges
        for (Booking booking : roomManager.getAllBookings()) {
            if (booking.getCustomer().equals(customer)) {
                double roomPrice = booking.getRoom().getPrice();
                System.out.printf("Room %d (%s): $%.2f\n",
                        booking.getRoom().getRoomNo(), booking.getRoom().getType(), roomPrice);
                total += roomPrice;
            }
        }

        // Food orders
        for (Order order : customer.getOrders()) {
            double orderTotal = order.getTotal();
            System.out.println("Food Order (Time: " + order.getOrderTime() + "):");
            for (Dish dish : order.getDishes()) {
                System.out.printf(" - %s: $%.2f\n", dish.getName(), dish.getPrice());
            }
            if (order.getTip() > 0) {
                System.out.printf(" - Tip: $%.2f\n", order.getTip());
            }
            total += orderTotal;
        }

        // Service requests
        for (ServiceRequest request : customer.getServiceRequests()) {
            double serviceCharge = 10.0; // Fixed service charge
            System.out.printf("Service (%s, Room %d): $%.2f\n",
                    request.getType(), request.getRoomNo(), serviceCharge);
            total += serviceCharge;
        }

        System.out.printf("\nTotal Amount: $%.2f\n", total);
        System.out.print("Generate PDF invoice? (y/n): ");
        if (scanner.nextLine().toLowerCase().equals("y")) {
            generateInvoice(customer, total);
        }
    }

    private void generateInvoice(Customer customer, double total) {
        try (PrintWriter writer = new PrintWriter("invoice_" + customer.getPhone() + ".txt")) {
            writer.println("=== Hotel Invoice ===");
            writer.println("Customer: " + customer.getName());
            writer.println("Phone: " + customer.getPhone());
            writer.println("Date: " + LocalDateTime.now());
            writer.println("\n=== Charges ===");
            
            for (Booking booking : roomManager.getAllBookings()) {
                if (booking.getCustomer().equals(customer)) {
                    writer.printf("Room %d: $%.2f\n",
                            booking.getRoom().getRoomNo(), booking.getRoom().getPrice());
                }
            }
            
            for (Order order : customer.getOrders()) {
                writer.println("Food Order:");
                for (Dish dish : order.getDishes()) {
                    writer.printf(" - %s: $%.2f\n", dish.getName(), dish.getPrice());
                }
                if (order.getTip() > 0) {
                    writer.printf(" - Tip: $%.2f\n", order.getTip());
                }
            }
            
            for (ServiceRequest request : customer.getServiceRequests()) {
                writer.printf("Service (%s): $10.00\n", request.getType());
            }
            
            writer.printf("\nTotal: $%.2f\n", total);
            System.out.println("Invoice generated as invoice_" + customer.getPhone() + ".txt");
        } catch (IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }

    private void provideFeedback(Customer customer) {
        System.out.print("Rate Food (1-5): ");
        int foodRating = getValidIntInput(1, 5);
        System.out.print("Rate Service (1-5): ");
        int serviceRating = getValidIntInput(1, 5);
        System.out.print("Rate Overall Experience (1-5): ");
        int overallRating = getValidIntInput(1, 5);
        scanner.nextLine();
        System.out.print("Enter comments (optional): ");
        String comments = scanner.nextLine();

        Feedback feedback = new Feedback(foodRating, serviceRating, overallRating, comments);
        customer.addFeedback(feedback);
        System.out.println("Feedback submitted successfully!");
    }

    private int getValidIntInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }
}

// Employee class
class Employee {
    private String id;
    private String name;
    private String password;
    private double salary;
    private List<WorkingHours> timesheet;
    private List<LeaveRequest> leaveRequests;
    private double leaveBalance;
    private String shift;

    public Employee(String id, String name, String password, double salary) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salary = salary;
        this.timesheet = new ArrayList<>();
        this.leaveRequests = new ArrayList<>();
        this.leaveBalance = 20.0; // Default leave balance
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public double getSalary() { return salary; }
    public List<WorkingHours> getTimesheet() { return timesheet; }
    public List<LeaveRequest> getLeaveRequests() { return leaveRequests; }
    public double getLeaveBalance() { return leaveBalance; }
    public String getShift() { return shift; }
    public void setPassword(String password) { this.password = password; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setLeaveBalance(double balance) { this.leaveBalance = balance; }
    public void setShift(String shift) { this.shift = shift; }
    public void addWorkingHours(WorkingHours hours) { timesheet.add(hours); }
    public void addLeaveRequest(LeaveRequest request) { leaveRequests.add(request); }
}

// WorkingHours class
class WorkingHours {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double hours;

    public WorkingHours(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.hours = java.time.Duration.between(startTime, endTime).toHours();
    }

    public double getHours() { return hours; }
    public LocalDateTime getStartTime() { return startTime; }
}

// LeaveRequest class
class LeaveRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String type;
    private String status;
    private String comment;

    public LeaveRequest(LocalDateTime startDate, LocalDateTime endDate, String type) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.status = "Pending";
    }

    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getComment() { return comment; }
    public void setStatus(String status) { this.status = status; }
    public void setComment(String comment) { this.comment = comment; }
}

// StaffManager handling employee operations
class StaffManager {
    private LinkedList<Employee> employees;
    private Queue<LeaveRequest> leaveQueue;
    private Scanner scanner;

    public StaffManager() {
        employees = new LinkedList<>();
        leaveQueue = new LinkedList<>();
        scanner = new Scanner(System.in);
        // Initialize sample employee
        employees.add(new Employee("E001", "John Doe", "password123", 2000.0));
    }

    public void staffMenu() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Employee employee = authenticate(id, password);
        if (employee == null) {
            System.out.println("Invalid credentials!");
            return;
        }

        while (true) {
            System.out.println("\nStaff Menu:");
            System.out.println("1. View Salary Details");
            System.out.println("2. Log Working Hours");
            System.out.println("3. View Extra Hours");
            System.out.println("4. Request Leave");
            System.out.println("5. View Leave Status");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput(1, 6);
            if (choice == 6) break;

            switch (choice) {
                case 1:
                    viewSalary(employee);
                    break;
                case 2:
                    logWorkingHours(employee);
                    break;
                case 3:
                    viewExtraHours(employee);
                    break;
                case 4:
                    requestLeave(employee);
                    break;
                case 5:
                    viewLeaveStatus(employee);
                    break;
            }
        }
    }

    private Employee authenticate(String id, String password) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id) && emp.getPassword().equals(password)) {
                return emp;
            }
        }
        return null;
    }

    private void viewSalary(Employee employee) {
        System.out.println("\nSalary Details for " + employee.getName());
        System.out.printf("Current Month Salary: $%.2f\n", employee.getSalary());
        double bonus = calculateBonus(employee);
        System.out.printf("Bonus: $%.2f\n", bonus);
        System.out.println("Deductions: $0.00"); // Simplified
    }

    private void logWorkingHours(Employee employee) {
        System.out.print("Enter start time (yyyy-MM-dd HH:mm): ");
        LocalDateTime start = parseDateTime(scanner.nextLine());
        System.out.print("Enter end time (yyyy-MM-dd HH:mm): ");
        LocalDateTime end = parseDateTime(scanner.nextLine());

        if (start != null && end != null && end.isAfter(start)) {
            WorkingHours hours = new WorkingHours(start, end);
            employee.addWorkingHours(hours);
            System.out.println("Working hours logged successfully!");
        } else {
            System.out.println("Invalid time input!");
        }
    }

    private void viewExtraHours(Employee employee) {
        double regularHours = 8.0; // Standard shift
        double extraHours = 0;
        for (WorkingHours wh : employee.getTimesheet()) {
            if (wh.getHours() > regularHours) {
                extraHours += (wh.getHours() - regularHours);
            }
        }
        System.out.printf("Total Extra Hours: %.2f\n", extraHours);
        System.out.println("Eligible for Bonus: " + (extraHours > 10 ? "Yes" : "No"));
    }

    private void requestLeave(Employee employee) {
        System.out.print("Enter start date (yyyy-MM-dd): ");
        LocalDateTime start = parseDateTime(scanner.nextLine() + " 00:00");
        System.out.print("Enter end date (yyyy-MM-dd): ");
        LocalDateTime end = parseDateTime(scanner.nextLine() + " 00:00");
        System.out.print("Enter leave type (e.g., Vacation, Sick): ");
        String type = scanner.nextLine();

        if (start != null && end != null && end.isAfter(start)) {
            double days = java.time.Duration.between(start, end).toDays() + 1;
            if (employee.getLeaveBalance() >= days) {
                LeaveRequest request = new LeaveRequest(start, end, type);
                employee.addLeaveRequest(request);
                leaveQueue.add(request);
                System.out.println("Leave request submitted successfully!");
            } else {
                System.out.println("Insufficient leave balance!");
            }
        } else {
            System.out.println("Invalid date input!");
        }
    }

    private void viewLeaveStatus(Employee employee) {
        System.out.println("\nLeave Requests:");
        for (LeaveRequest request : employee.getLeaveRequests()) {
            System.out.printf("Type: %s, From: %s, To: %s, Status: %s",
                    request.getType(),
                    request.getStartDate().toLocalDate(),
                    request.getEndDate().toLocalDate(),
                    request.getStatus());
            if (request.getComment() != null) {
                System.out.printf(", Comment: %s", request.getComment());
            }
            System.out.println();
        }
    }

    private double calculateBonus(Employee employee) {
        double extraHours = 0;
        for (WorkingHours wh : employee.getTimesheet()) {
            if (wh.getHours() > 8) {
                extraHours += (wh.getHours() - 8);
            }
        }
        return extraHours * 10.0; // $10 per extra hour
    }

    private LocalDateTime parseDateTime(String input) {
        try {
            return LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            return null;
        }
    }

    private int getValidIntInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    public Queue<LeaveRequest> getLeaveQueue() {
        return leaveQueue;
    }
}

// AdminManager handling admin operations
class AdminManager {
    private RoomManager roomManager;
    private StaffManager staffManager;
    private String adminPassword;
    private List<String> auditTrail;
    private Scanner scanner;

    public AdminManager(RoomManager roomManager, StaffManager staffManager) {
        this.roomManager = roomManager;
        this.staffManager = staffManager;
        this.adminPassword = "admin123";
        this.auditTrail = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void adminMenu() {
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();
        if (!password.equals(adminPassword)) {
            System.out.println("Invalid password!");
            return;
        }

        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add/Edit/Remove Rooms");
            System.out.println("2. Add/Edit/Remove Dishes");
            System.out.println("3. View All Bookings");
            System.out.println("4. View All Orders");
            System.out.println("5. View/Approve Leaves");
            System.out.println("6. Add/Modify Employee Details");
            System.out.println("7. Generate Reports");
            System.out.println("8. Change Password");
            System.out.println("9. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput(1, 9);
            if (choice == 9) break;

            switch (choice) {
                case 1:
                    manageRooms();
                    break;
                case 2:
                    manageDishes();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    manageLeaves();
                    break;
                case 6:
                    manageEmployees();
                    break;
                case 7:
                    generateReports();
                    break;
                case 8:
                    changePassword();
                    break;
            }
        }
    }

    private void manageRooms() {
        System.out.println("\n1. Add Room");
        System.out.println("2. Edit Room");
        System.out.println("3. Remove Room");
        System.out.print("Enter choice: ");

        int choice = getValidIntInput(1, 3);
        switch (choice) {
            case 1:
                System.out.print("Enter room number: ");
                int roomNo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter room type: ");
                String type = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter accessories (comma-separated): ");
                List<String> accessories = Arrays.asList(scanner.nextLine().split(","));
                roomManager.addRoom(new Room(roomNo, type, price, accessories));
                logAudit("Added Room " + roomNo);
                System.out.println("Room added successfully!");
                break;
            case 2:
                System.out.print("Enter room number to edit: ");
                Room room = roomManager.findRoomByNumber(scanner.nextInt());
                scanner.nextLine();
                if (room != null) {
                    System.out.print("Enter new price (or 0 to keep current): ");
                    double newPrice = scanner.nextDouble();
                    if (newPrice > 0) room.setPrice(newPrice);
                    scanner.nextLine();
                    System.out.print("Enter new accessories (comma-separated, or empty to keep current): ");
                    String accInput = scanner.nextLine();
                    if (!accInput.isEmpty()) {
                        room.setAccessories(Arrays.asList(accInput.split(",")));
                    }
                    logAudit("Edited Room " + room.getRoomNo());
                    System.out.println("Room updated successfully!");
                } else {
                    System.out.println("Room not found!");
                }
                break;
            case 3:
                System.out.print("Enter room number to remove: ");
                room = roomManager.findRoomByNumber(scanner.nextInt());
                scanner.nextLine();
                if (room != null && room.isAvailable()) {
                    // Note: Actual removal from BST is complex; marking as unavailable for simplicity
                    room.setAvailable(false);
                    logAudit("Removed Room " + room.getRoomNo());
                    System.out.println("Room removed successfully!");
                } else {
                    System.out.println("Room not found or currently booked!");
                }
                break;
        }
    }

    private void manageDishes() {
        // Implementation similar to manageRooms, omitted for brevity
        System.out.println("Dish management not implemented in this version.");
    }

    private void viewBookings() {
        System.out.println("\nAll Bookings:");
        for (Booking booking : roomManager.getAllBookings()) {
            System.out.printf("Customer: %s, Room: %d, Time: %s\n",
                    booking.getCustomer().getName(),
                    booking.getRoom().getRoomNo(),
                    booking.getBookingTime());
        }
    }

    private void viewOrders() {
        // Implementation requires access to CustomerManager's orderQueue
        System.out.println("Order viewing not implemented in this version.");
    }

    private void manageLeaves() {
        Queue<LeaveRequest> leaveQueue = staffManager.getLeaveQueue();
        if (leaveQueue.isEmpty()) {
            System.out.println("No pending leave requests.");
            return;
        }

        System.out.println("\nPending Leave Requests:");
        for (LeaveRequest request : leaveQueue) {
            System.out.printf("Employee: %s, Type: %s, From: %s, To: %s\n",
                    findEmployeeForRequest(request).getName(),
                    request.getType(),
                    request.getStartDate().toLocalDate(),
                    request.getEndDate().toLocalDate());
            System.out.print("1. Approve, 2. Reject, 3. Skip: ");
            int choice = getValidIntInput(1, 3);
            if (choice == 3) continue;

            System.out.print("Enter comment (optional): ");
            String comment = scanner.nextLine();
            request.setComment(comment);
            request.setStatus(choice == 1 ? "Approved" : "Rejected");
            if (choice == 1) {
                Employee emp = findEmployeeForRequest(request);
                double days = java.time.Duration.between(
                        request.getStartDate(), request.getEndDate()).toDays() + 1;
                emp.setLeaveBalance(emp.getLeaveBalance() - days);
            }
            logAudit("Processed leave request for " + findEmployeeForRequest(request).getId());
            leaveQueue.remove(request);
            break;
        }
    }

    private Employee findEmployeeForRequest(LeaveRequest request) {
        for (Employee emp : staffManager.getEmployees()) {
            if (emp.getLeaveRequests().contains(request)) {
                return emp;
            }
        }
        return null;
    }

    private void manageEmployees() {
        System.out.println("\n1. Add Employee");
        System.out.println("2. Modify Employee");
        System.out.print("Enter choice: ");

        int choice = getValidIntInput(1, 2);
        if (choice == 1) {
            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            staffManager.getEmployees().add(new Employee(id, name, password, salary));
            logAudit("Added Employee " + id);
            System.out.println("Employee added successfully!");
        } else {
            System.out.print("Enter employee ID to modify: ");
            String id = scanner.nextLine();
            for (Employee emp : staffManager.getEmployees()) {
                if (emp.getId().equals(id)) {
                    System.out.print("Enter new salary (or 0 to keep current): ");
                    double salary = scanner.nextDouble();
                    if (salary > 0) emp.setSalary(salary);
                    scanner.nextLine();
                    System.out.print("Enter new shift (or empty to keep current): ");
                    String shift = scanner.nextLine();
                    if (!shift.isEmpty()) emp.setShift(shift);
                    System.out.print("Reset password? (y/n): ");
                    if (scanner.nextLine().toLowerCase().equals("y")) {
                        System.out.print("Enter new password: ");
                        emp.setPassword(scanner.nextLine());
                    }
                    logAudit("Modified Employee " + id);
                    System.out.println("Employee updated successfully!");
                    return;
                }
            }
            System.out.println("Employee not found!");
        }
    }

    private void generateReports() {
        System.out.println("\nReports:");
        // Revenue Report
        double totalRevenue = 0;
        for (Booking booking : roomManager.getAllBookings()) {
            totalRevenue += booking.getRoom().getPrice();
        }
        System.out.printf("Total Revenue (Rooms): $%.2f\n", totalRevenue);

        // Staff Attendance
        System.out.println("\nStaff Attendance:");
        for (Employee emp : staffManager.getEmployees()) {
            double totalHours = emp.getTimesheet().stream().mapToDouble(WorkingHours::getHours).sum();
            System.out.printf("%s: %.2f hours\n", emp.getName(), totalHours);
        }

        logAudit("Generated reports");
    }

    private void changePassword() {
        System.out.print("Enter new password: ");
        adminPassword = scanner.nextLine();
        logAudit("Changed admin password");
        System.out.println("Password changed successfully!");
    }

    private void logAudit(String action) {
        auditTrail.add(LocalDateTime.now() + ": " + action);
    }

    private int getValidIntInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }
}