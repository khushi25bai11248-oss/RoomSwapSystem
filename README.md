# Roommate / Room Swapping System

A Java command-line application for managing hostel students, rooms, and room-swap requests. Students and rooms are held in memory while the program is running, and a hostel administrator can approve or reject pending requests.

## Overview

Manual room-change requests can be difficult to track and may lead to duplicate processing or incorrect room assignments. This project provides a small, modular workflow for:

1. Recording student and room information.
2. Looking up students and checking room availability.
3. Creating a pending swap request between two students.
4. Letting an administrator accept or reject the request.
5. Exchanging the students' room assignments when a request is accepted.

The application is designed as an educational Java project demonstrating classes, encapsulation, object relationships, collections, validation, loops, conditionals, and exception handling. It has no graphical interface and does not require a database or external service.

## ✨Features

-Register new students by entering their ID, name, email, and current room number.

-View the details of all registered students along with their assigned rooms.

-Find students using their exact ID or by searching their name without worrying about letter case.

-Add hostel rooms by specifying the room number, room type, and availability status.

-View all rooms and check whether a particular room is occupied or available.

-Submit room-swapping requests between two registered students.

-View all swap requests and track their status as Pending, Accepted, or Rejected.

-Approve a pending swap request and automatically exchange the rooms assigned to both students.

-Reject a pending request without making any changes to the students' room assignments.

-Prevent invalid operations such as duplicate student IDs, repeated room numbers, swapping with oneself, incorrect menu choices, and processing the same request more   than once.

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal or command prompt
- No external libraries, database, build tool, or network connection

Check that Java is installed:

```bash
java -version
javac -version
```

## Compile and Run

From the project root, compile all source files:

```bash
javac src/*.java
```

Start the application:

```bash
java -cp src RoomSwapSystem
```

The compiler places `.class` files in `src/`. They are generated build artifacts and are not required to edit the source code.

To remove compiled classes after a run:

```bash
find src -name '*.class' -delete
```

## Using the Application

The program starts with sample data and repeatedly displays this menu:

| Option | Action | Description |
| --- | --- | --- |
| 1 | Add Student | Registers a student against an existing room. |
| 2 | View All Students | Displays every student and current room. |
| 3 | Search Student | Searches by exact ID or a name fragment. |
| 4 | View Rooms | Displays each room and its stored status. |
| 5 | Add Room | Adds a room with a unique room number. |
| 6 | Check Room Availability | Reports whether a room is available or occupied. |
| 7 | Create Room Swap Request | Creates a pending request between two students. |
| 8 | View Swap Requests | Displays all requests and their statuses. |
| 9 | Process Swap Request (Admin) | Accepts or rejects a pending request. |
| 10 | Exit | Closes the scanner and ends the program. |

### Normal Request Flow

1. A student chooses **Create Room Swap Request** and enters two registered student IDs.
2. `StudentManager` searches for both students. The request is rejected if either ID is unknown or both IDs refer to the same student.
3. `SwapManager` creates a `SwapRequest` with the next available ID and the status `Pending`.
4. An administrator chooses **Process Swap Request**, selects the request ID, and chooses `Accept` or `Reject`.
5. For an accepted request, `SwapManager` temporarily stores the first student's room, exchanges both `currentRoom` values, and changes the request status to `Accepted`.
6. For a rejected request, no student data changes and the status becomes `Rejected`.
7. A request whose status is no longer `Pending` cannot be processed again.

### Seeded Data

Each application run begins with the following records:

| Room | Type | Status |
| --- | --- | --- |
| A-101 | Single | Occupied |
| A-102 | Single | Occupied |
| A-103 | Single | Available |
| B-201 | Double | Occupied |
| B-202 | Double | Available |

| Student ID | Name | Email | Room |
| ---: | --- | --- | --- |
| 101 | Dhriti | dhriti@gmail.com | A-101 |
| 102 | Sofia | sofia@gmail.com | A-102 |
| 103 | Riya | riya@gmail.com | B-201 |

## 📜Application Rules

- Student IDs must be positive integers and unique.
- Student names and email addresses cannot be empty.
- A student's room must already exist when the student is added.
- Room numbers and room types cannot be empty.
- Room numbers must be unique, compared without regard to letter case.
- A swap requires two existing students and cannot be a self-swap.
- New requests start with `Pending` status and receive sequential IDs beginning at `1`.
- Only pending requests can be accepted or rejected.
- Accepting a request exchanges the `currentRoom` values of the two students.
- Processing a request does not update the separate `Room.occupied` flag. Room availability therefore remains the manually stored room status, while student assignments are tracked independently.
- All records are lost when the program exits.

### ⌨️Input Behavior

- Numeric prompts continue asking until the user enters a valid integer.
- Empty names, email addresses, room numbers, and room types are rejected.
- Student searches accept an exact numeric ID or a case-insensitive name fragment.
- Room lookup is case-insensitive, so `a-101` and `A-101` refer to the same room.
- An invalid menu option displays an error and returns to the main menu.

## Architecture

`RoomSwapSystem` is the entry point and coordinates the console menu, input, and managers:

- **`Student`** represents a student's ID, name, email, and current room.
- **`Room`** represents a room number, type, and stored occupied flag.
- **`SwapRequest`** links two `Student` objects and stores a request ID and status.
- **`StudentManager`** stores students in an `ArrayList`, validates new students, and performs searches.
- **`RoomManager`** stores rooms in an `ArrayList`, prevents duplicate room numbers, and checks availability.
- **`SwapManager`** creates requests, assigns IDs, and performs accept/reject operations.
- **`Admin`** applies the administrator's selected action to a request.

The application uses object references rather than copying students into requests. Consequently, an accepted request updates the same `Student` objects shown by the student menu.

### 🔗Data Relationships

```text
RoomSwapSystem
├── StudentManager ── ArrayList<Student>
├── RoomManager ───── ArrayList<Room>
├── SwapManager ───── ArrayList<SwapRequest>
└── Admin

SwapRequest ── references Student 1 and Student 2
```

The `Room` object stores its own `occupied` flag, while each `Student` stores a `currentRoom` string. These are separate pieces of state. Accepting a swap changes the students' room strings only; it does not automatically change any `Room.occupied` value.

## 📁Project Structure

```text
RoomSwapProject/
├── src/
│   ├── Admin.java            # Administrator request actions
│   ├── Room.java             # Room data model
│   ├── RoomManager.java      # Room collection and availability logic
│   ├── RoomSwapSystem.java   # Console entry point and menu
│   ├── Student.java          # Student data model
│   ├── StudentManager.java   # Student collection and search logic
│   ├── SwapManager.java      # Request creation and processing
│   └── SwapRequest.java      # Swap request data model
├── screenshots/              # Project screenshots, if provided
├── DIAGRAMS.md               # Diagram descriptions
├── README.md                 # Project documentation
└── statement.md              # Problem statement and scope
```

## Example Workflow

1. Start the application with `java -cp src RoomSwapSystem`.
2. Choose `7` to create a room-swap request.
3. Enter student ID `101`, then student ID `102`.
4. Note the generated request ID, which is `1` in a fresh run.
5. Choose `9` to open admin processing.
6. Enter request ID `1` and choose `1` to accept it.
7. Choose `2` to verify that Dhriti now has `A-102` and Sofia now has `A-101`.
8. Choose `8` to verify that request `1` is marked `Accepted`.

Useful negative tests include entering a non-numeric menu value, adding a duplicate student ID, searching for an unknown student, creating a request with the same student twice, rejecting a nonexistent request, and processing an already accepted request.

### 💬Example Console Interaction

```text
Enter your choice: 6
Enter your Student ID: 101
Enter other student's ID: 102
Swap request created successfully. Request ID: 1

Enter your choice: 9
Enter Request ID: 1
Enter 1 to Accept or 2 to Reject: 1
Room swap successful. Rooms were exchanged.
```

After acceptance, viewing the students shows:

```text
Dhriti  -> A-102
Sofia   -> A-101
```

## Testing Checklist

Run the program from a fresh start and verify:

- The five seeded rooms and three seeded students are displayed.
- A valid student can be added to an existing room.
- A duplicate student ID is rejected.
- A student using an unknown room is rejected.
- A room can be found using different letter casing.
- A duplicate room number is rejected.
- A valid swap request receives a sequential ID and `Pending` status.
- A self-swap and a request with an unknown student are rejected.
- Accepting a pending request exchanges both students' room assignments.
- Rejecting a pending request leaves both room assignments unchanged.
- An accepted or rejected request cannot be processed a second time.
- Non-numeric input does not terminate the program.

## Limitations

- Data is stored only in `ArrayList` instances and is not persisted.
- There is no login or distinction between student and administrator sessions.
- The console does not automatically synchronize room occupancy with student assignments.
- Room capacity, eligibility rules, timestamps, notifications, and approval history are not implemented.
- The project currently has no automated unit-test suite; testing is performed through the console workflow above.
