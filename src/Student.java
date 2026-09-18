public class Student {
    private int studentId;
    private String name;
    private String email;
    private String currentRoom;

    // constructor
    public Student(int studentId, String name, String email, String currentRoom) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.currentRoom = currentRoom;
    }

    // taking input
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    //  display the input from the student
    public void displayStudent() {
        System.out.println("--------------------------------");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Name         : " + name);
        System.out.println("Email        : " + email);
        System.out.println("Current Room : " + currentRoom);
        System.out.println("--------------------------------");
    }
}
