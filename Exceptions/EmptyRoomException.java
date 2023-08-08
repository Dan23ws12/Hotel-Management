package Exceptions;

public class EmptyRoomException extends Exception {

    public EmptyRoomException() {
    }

    @Override
    public String toString() {
        return "Cannot check out of an empty room";
    }
}
