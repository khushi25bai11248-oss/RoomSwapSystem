import java.util.ArrayList;

//taking rooms as array
public class RoomManager {
    private ArrayList<Room> rooms;

    public RoomManager() {
        rooms = new ArrayList<>();
    }

    // function to add room
    public boolean addRoom(Room room) {
        if (room == null || room.getRoomNumber().trim().isEmpty()
                || room.getRoomType().trim().isEmpty()
                || findRoom(room.getRoomNumber()) != null) {
            return false;
        }
        rooms.add(room);
        return true;
    }

    // functions to find room
    public Room findRoom(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    // function to find if the room is available
    public boolean isRoomAvailable(String roomNumber) {
        Room room = findRoom(roomNumber);
        return room != null && !room.isOccupied();
    }

    // function to display rooms
    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
            return;
        }
        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
