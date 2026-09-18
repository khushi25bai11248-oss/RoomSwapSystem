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

    // function for returning room no.
    public String getRoomNumber() {
        return roomNumber;
    }

    // function for returning room type
    public String getRoomType() {
        return roomType;
    }

    // function for checking if the room is occupied
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
