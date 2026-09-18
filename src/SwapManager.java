import java.util.ArrayList;
//importing package
public class SwapManager 
{
    private ArrayList<SwapRequest> requests;
    private int nextRequestId;

    public SwapManager() {
        requests = new ArrayList<>();
        nextRequestId = 1;
    }

//function to swap request
    public SwapRequest createRequest(Student student1, Student student2) {
        if (student1 == null || student2 == null || student1 == student2) {
            return null;
        }
        SwapRequest request = new SwapRequest(nextRequestId, student1, student2);
        requests.add(request);
        nextRequestId++;//updating the value
        return request;
    }

    public SwapRequest findRequestById(int requestId) {
        for (SwapRequest request : requests) {
            if (request.getRequestId() == requestId) {
                return request;
            }
        }
        return null;
    }
//function to accept request
    public boolean acceptRequest(int requestId) {
        SwapRequest request = findRequestById(requestId);
        if (request == null || !request.getStatus().equals("Pending")) {
            return false;
        }
        Student student1 = request.getStudent1();
        Student student2 = request.getStudent2();
        String temporaryRoom = student1.getCurrentRoom();
        student1.setCurrentRoom(student2.getCurrentRoom());
        student2.setCurrentRoom(temporaryRoom);
        request.setStatus("Accepted");
        return true;
    }
//function to reject request
    public boolean rejectRequest(int requestId) {
        SwapRequest request = findRequestById(requestId);
        if (request == null || !request.getStatus().equals("Pending")) {
            return false;
        }
        request.setStatus("Rejected");
        return true;
    }
//displaying request
    public void displayRequests() {
        if (requests.isEmpty()) {
            System.out.println("No swap requests found.");
            return;
        }
        for (SwapRequest request : requests) {
            request.displayRequest();
        }
    }

    public ArrayList<SwapRequest> getRequests() {
        return requests;
    }
}
