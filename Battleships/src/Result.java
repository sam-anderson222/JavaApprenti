public class Result {
    private boolean status;
    private String message;

    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getter functions
    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
