package Rooms;

import java.util.ArrayList;

import Exceptions.InvalidValueException;
import Exceptions.NotAvailableException;
import Exceptions.OverBookedException;
import Users.Customer;

/*
 * DoubleRoom class
 * 
 * A class representing a room with double beds
 * This room has a list of features such as AC, Gym
 * and this room can accept up to two guests
 * All guests must checkout at the same time
 *  
*/
public class DoubleRoom extends Room {
    private static String[] features = { "AC", "FREE BREAKFAST", "DOUBLE BED", "ROOM SERVICE", "GYM" };
    private int MAX_NUM_GUESTS = 4;

    // creates an empty room
    public DoubleRoom() {
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
     * prints or displays the features any double room has
     * (presently prints might make a GUI later)
     */
    @Override
    public void displayFeatures() {
        String msg = "This double room room has ";
        for (String feature : features) {
            msg += String.format("%s, ", feature);
        }
        msg += "\n";
        System.out.println(msg);
    }
}
