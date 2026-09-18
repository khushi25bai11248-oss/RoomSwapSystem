import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // function to add student deatils
    public boolean addStudent(Student student) {
        if (student == null || student.getStudentId() <= 0
                || student.getName().trim().isEmpty()
                || student.getEmail().trim().isEmpty()) {
            return false;
        }
        if (findStudentById(student.getStudentId()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    // function to find stundet id
    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // function to display student
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            student.displayStudent();
        }
    }

    // function to search student
    public void searchStudent(String searchText) {
        boolean found = false;
        for (Student student : students) {
            if (String.valueOf(student.getStudentId()).equals(searchText)
                    || student.getName().toLowerCase().contains(searchText.toLowerCase())) {
                student.displayStudent();
                found = true;
            }
        }
        // to check if in record or not
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
