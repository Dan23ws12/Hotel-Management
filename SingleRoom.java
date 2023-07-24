import java.util.ArrayList;

/*
 * 
*/
public class SingleRoom extends Room {
    private static String[] features = { "AC", "FREE BREAKFAST", "SINGLE BED", "ROOM SERVICE", "GYM" };
    private static int MAX_NUM_GUESTS = 2;

    public SingleRoom() {
        super();
    }

    /*
     * 
    */
    @Override
    public void bookRoom(ArrayList<Customer> guests) {
        if (guests.size() <= MAX_NUM_GUESTS) {
            super.bookRoom(guests);
        } else {
            // TODO MIGHT CHANGE TO EXCEPTION
            System.out.println("Tried to book more than maximum amount of guests");
        }
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