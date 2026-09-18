# 🏠 Project Statement

## 1. Problem Statement

Managing hostel room and roommate changes manually can become difficult when the number of students increases. Students may need to change their rooms or roommates due to compatibility issues, personal preferences, changes in hostel arrangements, or other valid reasons. When these requests are handled through paper records, verbal communication, or informal messages, important information can be missed or recorded incorrectly.

Manual management can lead to several problems, such as:

* Loss or misplacement of room swap requests.
* Duplicate or repeated requests from students.
* Difficulty tracking whether a request is pending, accepted, or rejected.
* Incorrect room assignments due to manual updates.
* Difficulty checking which rooms are currently occupied.
* Additional effort for hostel administrators when processing requests.
* Lack of a centralized record of students, rooms, and swap requests.

To address these issues, this project develops a **Java-based console application** for managing hostel students, rooms, and room swap requests. The application organizes the information using Java classes and collections and provides a structured workflow for creating and processing room swap requests.

The system allows students to be registered and searched, rooms to be viewed and managed, and swap requests to be created between students. An administrator can then review pending requests and either accept or reject them. When a request is accepted, the room assignments of the two students are automatically exchanged by the system.

---

## 2. Scope

The scope of the current project is to provide a simple, modular, and command-line-based solution for basic hostel room and roommate swap management.

The application provides the following functionality:

### Student Management

* Add new student records.
* Store student details such as student ID, name, email, and current room.
* View the list of registered students.
* Search for a student using their Student ID.
* Validate student information before adding records.

### Room Management

* Add and store hostel room information.
* Display available rooms and their current status.
* Identify whether a room is occupied or available.
* Associate students with their current room assignments.

### Room Swap Management

* Create a room swap request between two registered students.
* Generate a unique request ID for each request.
* Store the details of both students involved in the request.
* Display all submitted swap requests.
* Track the status of each request.

### Administrator Management

* Allow an administrator to process pending swap requests.
* Accept valid room swap requests.
* Reject requests when required.
* Prevent already processed requests from being processed again.

### Validation and Error Handling

The system performs basic validation to reduce incorrect operations. It handles situations such as:

* Invalid Student IDs.
* Invalid Request IDs.
* Self-swap attempts.
* Invalid menu choices.
* Empty or invalid student information.
* Invalid room information.
* Attempts to process an already accepted or rejected request.
* Invalid numeric input.

The application stores all information **temporarily in memory using Java `ArrayList` collections**. The data is available only while the program is running. The current version does not include a database, file-based permanent storage, login system, notifications, or a graphical user interface.

---

## 3. Target Users

The main users of the system are:

### 👨‍🎓 Students

Students can use the system to:

* View student and room information.
* Search for student records.
* Create a room swap request with another student.
* Track the status of submitted requests.

### 👨‍💼 Hostel Administrators

Administrators can use the system to:

* Manage student and room records.
* View room availability.
* Review submitted room swap requests.
* Accept or reject pending requests.
* Ensure that approved swaps are correctly reflected in student room assignments.

---

## 4. High-Level Features

The major features of the Roommate / Room Swapping System are:

### 4.1 Student Registration and Management

The application allows student records to be added and maintained in the system. Each student has information such as a unique Student ID, name, email, and current room assignment.

### 4.2 Student Search

The system provides a search facility that allows a student record to be found using the Student ID. This makes it easier to locate specific records without manually checking the complete student list.

### 4.3 Room Management

The application maintains a list of hostel rooms and displays their current occupancy status. This allows administrators to identify rooms that are occupied or available.

### 4.4 Room Swap Request Creation

Students can submit a request to exchange their current rooms with another student. The system checks whether both students exist and prevents invalid operations such as requesting a swap with themselves.

### 4.5 Request Tracking

Every room swap request receives a unique Request ID. The system stores the request along with the students involved and its current status, such as **Pending, Accepted, or Rejected**.

### 4.6 Administrator Approval

An administrator can review pending requests and choose to accept or reject them. This creates a controlled approval process instead of changing room assignments immediately when a request is created.

### 4.7 Automatic Room Exchange

When an administrator accepts a valid swap request, the system exchanges the current room values of the two students. This reduces the possibility of manually assigning the wrong room.

### 4.8 Input Validation

The system checks user input and displays appropriate error messages when invalid information is entered. This improves reliability and prevents common input-related errors.

### 4.9 Modular Java Design

The application is divided into multiple classes, including:

* `Student`
* `Room`
* `SwapRequest`
* `Admin`
* `StudentManager`
* `RoomManager`
* `SwapManager`
* `RoomSwapSystem`

Each class has a specific responsibility, making the project easier to understand, maintain, and extend.

---

## 5. Project Limitations

The current version is intentionally designed as a beginner-friendly Java console application. Therefore, it has some limitations:

* Data is not permanently stored and is lost when the program closes.
* There is no database connection.
* There is no student or administrator login/authentication.
* The application does not send notifications or emails.
* There is no graphical or web interface.
* Room allocation rules are basic and do not include advanced roommate preferences.
* Multiple users cannot access the system simultaneously.

These limitations provide opportunities for future improvements.

---

## 6. Expected Outcome

The expected outcome of the project is a functional Java console application that provides a structured method for managing hostel students, rooms, and room swap requests.

The project demonstrates how **object-oriented programming, classes and objects, encapsulation, constructors, methods, collections, conditional statements, loops, switch statements, and exception handling** can be combined to solve a practical problem.

The final system should make room swap management more organized by maintaining student and room information in one application and providing a clear process from **request creation → request review → approval/rejection → room exchange**.
