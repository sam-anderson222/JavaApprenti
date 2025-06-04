public class ResultInt {
    private final boolean status;
    private final int message;

    public ResultInt(boolean status, int message){
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public int getNumber() {
        return message;
    }
}

