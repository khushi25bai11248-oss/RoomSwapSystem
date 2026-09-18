public class Room {
    private String roomNumber;
    private String roomType;
    private boolean occupied;

    // constructor
    public Room(String roomNumber, String roomType, boolean occupied) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.occupied = occupied;
    }

    // function to return room no
    public String getRoomNumber() {
        return roomNumber;
    }

    // function to return room type
    public String getRoomType() {
        return roomType;
    }

    // function to check if the room is occupied
    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void displayRoom() {
        System.out.println("Room: " + roomNumber + " | Type: " + roomType
                + " | Status: " + (occupied ? "Occupied" : "Available"));
    }
}
