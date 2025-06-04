public class Result {
    private final boolean status;
    private final String message;

    public Result(boolean status, String message){
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
