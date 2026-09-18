import java.util.Scanner;

public class RoomSwapSystem {
    private Scanner scanner;
    private StudentManager studentManager;
    private RoomManager roomManager;
    private SwapManager swapManager;
    private Admin admin;

    public RoomSwapSystem() {
        scanner = new Scanner(System.in);
        studentManager = new StudentManager();
        roomManager = new RoomManager();
        swapManager = new SwapManager();
        admin = new Admin("Hostel Administrator");
        addSampleData();
    }

    //  objects creation
    public static void main(String[] args) {
        RoomSwapSystem system = new RoomSwapSystem();
        system.run();
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayRooms();
                    break;
                case 5:
                    addRoom();
                    break;
                case 6:
                    checkRoomAvailability();
                    break;
                case 7:
                    createSwapRequest();
                    break;
                case 8:
                    displayRequests();
                    break;
                case 9:
                    processSwapRequest();
                    break;
                case 10:
                    System.out.println("Thank you for using Room Swap System!");
                    break;
                default:
                    System.out.println("Invalid menu choice. Please choose 1 to 10.");
            }
        } while (choice != 10);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("======================================");
        System.out.println("       ROOMMATE / ROOM SWAP SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. View Rooms");
        System.out.println("5. Add Room");
        System.out.println("6. Check Room Availability");
        System.out.println("7. Create Room Swap Request");
        System.out.println("8. View Swap Requests");
        System.out.println("9. Process Swap Request (Admin)");
        System.out.println("10. Exit");
        System.out.println("======================================");
    }
    // to display options

    private void addStudent() {
        System.out.println("\n--- Add Student ---");
        int id = readInt("Enter Student ID: ");
        if (id <= 0) {
            System.out.println("Invalid Student ID. It must be positive.");
            return;
        }
        String name = readText("Enter Student Name: ");
        // entering student name
        String email = readText("Enter Email: ");
        // entering student email
        String roomNumber = readText("Enter Current Room: ");
        // entering student room no
        if (name.isEmpty() || email.isEmpty()) {
            System.out.println("Student name and email cannot be empty.");
            return;
        }
        if (roomManager.findRoom(roomNumber) == null) {
            System.out.println("Invalid room number. Please choose an existing room.");
            return;
        }
        Student student = new Student(id, name, email, roomNumber);
        if (studentManager.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student ID already exists or student data is invalid.");
        }
    }

    private void displayStudents() {
        System.out.println("\n--- All Students ---");
        studentManager.displayStudents();
    }

    private void searchStudent() {
        System.out.println("\n--- Search Student ---");
        String searchText = readText("Enter Student ID or name: ");
        if (searchText.isEmpty()) {
            System.out.println("Search text cannot be empty.");
            return;
        }
        studentManager.searchStudent(searchText);
    }

    private void displayRooms() {
        System.out.println("\n--- Room List ---");
        roomManager.displayRooms();
    }

    private void addRoom() {
        System.out.println("\n--- Add Room ---");
        String roomNumber = readText("Enter Room Number: ");
        String roomType = readText("Enter Room Type: ");
        int occupiedChoice = readInt("Is the room occupied? (1 = Yes, 2 = No): ");
        if (roomNumber.isEmpty() || roomType.isEmpty()
                || (occupiedChoice != 1 && occupiedChoice != 2)) {
            System.out.println("Invalid room details.");
            return;
        }
        Room room = new Room(roomNumber, roomType, occupiedChoice == 1);
        if (roomManager.addRoom(room)) {
            System.out.println("Room added successfully!");
        } else {
            System.out.println("Room number already exists or room data is invalid.");
        }
    }

    private void checkRoomAvailability() {
        System.out.println("\n--- Check Room Availability ---");
        String roomNumber = readText("Enter Room Number: ");
        Room room = roomManager.findRoom(roomNumber);
        if (room == null) {
            System.out.println("Invalid room number. Room not found.");
        } else if (roomManager.isRoomAvailable(roomNumber)) {
            System.out.println("Room " + roomNumber + " is available.");
        } else {
            System.out.println("Room " + roomNumber + " is occupied.");
        }
    }

    private void createSwapRequest() {
        System.out.println("\n--- Create Room Swap Request ---");
        int firstId = readInt("Enter your Student ID: ");
        int secondId = readInt("Enter other student's ID: ");
        Student firstStudent = studentManager.findStudentById(firstId);
        Student secondStudent = studentManager.findStudentById(secondId);
        if (firstStudent == null || secondStudent == null) {
            System.out.println("One or both students were not found.");
            return;
        }
        if (firstStudent == secondStudent) {
            System.out.println("You cannot swap with yourself.");
            return;
        }
        SwapRequest request = swapManager.createRequest(firstStudent, secondStudent);
        if (request != null) {
            System.out.println("Swap request created successfully. Request ID: "
                    + request.getRequestId());
        }
    }

    private void displayRequests() {
        System.out.println("\n--- Swap Requests ---");
        swapManager.displayRequests();
    }

    private void processSwapRequest() {
        System.out.println("\n--- Admin Request Processing ---");
        if (swapManager.getRequests().isEmpty()) {
            System.out.println("No requests available.");
            return;
        }
        swapManager.displayRequests();
        int requestId = readInt("Enter Request ID: ");
        if (swapManager.findRequestById(requestId) == null) {
            System.out.println("Invalid Request ID. Request not found.");
            return;
        }
        int action = readInt("Enter 1 to Accept or 2 to Reject: ");
        System.out.println("Admin " + admin.getName() + ": "
                + admin.processRequest(swapManager, requestId, action));
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private void addSampleData() {
        roomManager.addRoom(new Room("A-101", "Single", true));
        roomManager.addRoom(new Room("A-102", "Single", true));
        roomManager.addRoom(new Room("A-103", "Single", false));
        roomManager.addRoom(new Room("B-201", "Double", true));
        roomManager.addRoom(new Room("B-202", "Double", false));

        studentManager.addStudent(new Student(101, "Dhriti", "dhriti@gmail.com", "A-101"));
        studentManager.addStudent(new Student(102, "Sofia", "sofia@gmail.com", "A-102"));
        studentManager.addStudent(new Student(103, "Riya", "riya@gmail.com", "B-201"));
    }
}
