
public class NotAvailableException extends Exception {
    private int roomNo;

    public NotAvailableException(int roomNum) {
        this.roomNo = roomNum;
    }

    @Override
    public String toString() {
        return String.format("THE ROOM NO:%d IS Not Available !", this.roomNo);
    }
}