public class SwapRequest // initialising variable
{
    private int requestId;
    private Student student1;
    private Student student2;
    private String status;

    // constructor
    public SwapRequest(int requestId, Student student1, Student student2) {
        this.requestId = requestId;
        this.student1 = student1;
        this.student2 = student2;
        this.status = "Pending";
    }

    // funtions to return the accepted value
    public int getRequestId() {
        return requestId;
    }

    public Student getStudent1() {
        return student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // displaying
    public void displayRequest() {
        System.out.println("--------------------------------");
        System.out.println("Request ID : " + requestId);
        System.out.println(student1.getName() + " (" + student1.getCurrentRoom() + ")");
        System.out.println("        wants to swap with");
        System.out.println(student2.getName() + " (" + student2.getCurrentRoom() + ")");
        System.out.println("Status     : " + status);
        System.out.println("--------------------------------");
    }
}
