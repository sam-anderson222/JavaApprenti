public class ResultStr {
    private final boolean status;
    private final String message;

    public ResultStr(boolean status, String message){
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
