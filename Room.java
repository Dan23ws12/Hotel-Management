import java.util.HashMap;
import java.util.ArrayList;

/*
 * This class represents a Room
 * All rooms has a guest that has booked the room, the features the room has
 * and a list of all the food the guest has ordered in the room.
 * The features of the room is stored in a hashmap, example
 * A room can have a feature AC, if it doesn't AC is stored in the hashmap hasFeature
 * with a value of 0 (no AC), if the room does has AC hashmap will store AC with
 * the number of ACs as a value.
 * Convention is feature is stored with value 0 if room doesn't have said feature, >=1 if
 * feature comes with the room
*/
public class Room {
    private Customer guest;
    private static String[] basicFeatures = { "AC", "FREE BREAKFAST", "SINGLE BED", "DOUBLE BED" };
    private static HashMap<String, Integer> hasFeature = new HashMap<String, Integer>();
    private ArrayList<Food> foodLst;

    public Room(Customer guest) {
        this.guest = guest;
        this.foodLst = new ArrayList<Food>();
    }

    public static void setFeatures() {
        hasFeature.put("ROOM SERVICE", 1);
        // rooms always come with room services
        for (String feature : basicFeatures) {
            hasFeature.put(feature, 0);
        }
    }

    public void printFeatures() {
        String msg = "This room has ";
        for (String feature : hasFeature.keySet()) {
            msg += String.format("%s: %d", feature, hasFeature.get(feature));
        }
        System.out.println(msg);
    }

    public Customer getCustomer() {
        return this.guest;
    }

    public ArrayList<Food> getFood() {
        return this.foodLst;
    }

    public void addFood() {

    }
}
