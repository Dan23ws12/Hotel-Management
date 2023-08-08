package Exceptions;

public class OverBookedException extends Exception {
    private int maximum;

    public OverBookedException(int max) {
        this.maximum = max;
    }

    public String toString() {
        return String.format("A maximum if %d guests can be booked in this room.", maximum);
    }
}
