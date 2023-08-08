package Exceptions;

public class NotAvailableException extends Exception {

    public NotAvailableException() {
    }

    @Override
    public String toString() {
        return String.format("This Room Is Not Available !");
    }
}