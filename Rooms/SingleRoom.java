package Rooms;

import java.util.ArrayList;

import Exceptions.InvalidValueException;
import Exceptions.NotAvailableException;
import Exceptions.OverBookedException;
import Users.Customer;

/*
 * 
*/
public class SingleRoom extends Room {
    private static String[] features = { "AC", "FREE BREAKFAST", "SINGLE BED", "ROOM SERVICE", "GYM" };
    private int MAX_NUM_GUESTS = 2;

    public SingleRoom() {
        super();
    }

    /*
     * If the room is not empty and the number of guest occupying the room is not
     * over the maximum, the
     * room is booked, all guests in the guest list occupy this room.
     * Otherwise, appropriate exceptions are thrown
     */
    @Override
    public void book(ArrayList<Customer> guests)
            throws OverBookedException, InvalidValueException, NotAvailableException {
        this.bookHelper(guests, MAX_NUM_GUESTS);
    }

    /*
     * prints or displays the features any single room has
     * (presently prints might make a GUI later)
     */
    @Override
    public void displayFeatures() {
        String msg = "This single room room has ";
        for (String feature : features) {
            msg += String.format("%s, ", feature);
        }
        msg += "\n";
        System.out.println(msg);
    }

}