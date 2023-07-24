import java.util.ArrayList;

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
    private static int MAX_NUM_GUESTS = 4;

    // creates an empty room
    public DoubleRoom() {
        super();
    }

    public void bookRoom(ArrayList<Customer> guests) {
        if (guests.size() <= MAX_NUM_GUESTS) {
            super.bookRoom(guests);
        } else {
            // TODO MIGHT CHANGE TO EXCEPTION
            System.out.println("Tried to book more than maximum amount of guests");
        }

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
