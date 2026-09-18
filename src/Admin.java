public class Admin {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
//to process request
    public String processRequest(SwapManager swapManager, int requestId, int action) {
        SwapRequest request = swapManager.findRequestById(requestId);
        if (request == null) {
            return "Request not found.";
        }
        if (!request.getStatus().equals("Pending")) {
            return "This request has already been processed.";
        }
        if (action == 1 && swapManager.acceptRequest(requestId)) {
            return "Room swap successful. Rooms were exchanged.";
        }
        if (action == 2 && swapManager.rejectRequest(requestId)) {
            return "Swap request rejected.";
        }
        return "Invalid processing choice. Please choose 1 or 2.";
    }
}
