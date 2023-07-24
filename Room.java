import java.util.ArrayList;

/*
 * This class represents a Room
 * All rooms has a list of guests that has booked the room, the features the room has
 * and a list of all the food the guest has ordered in the room.
 * A room is empty if it doesn't have any guests, otherwise it's occupied
 * An occupied booked cannot be booked until all the guests that booked it checks outs
 * MIGHT ADD A NOTIFICATION METHOD
*/
public class Room {
    private ArrayList<Customer> guestLst;
    private static String[] features = { "FREE BREAKFAST", "BED", "ROOM SERVICE", "GYM" };
    // a list of features a room must have
    private ArrayList<Food> foodLst;

    // creates an empty room
    public Room() {
        this.initRoom();
    }

    /*
     * books a room, the room is occupied and booked by all guests in the given
     * guest list
     */
    public void bookRoom(ArrayList<Customer> guests) {
        this.guestLst = guests;
    }

    /*
     * prints or displays the features any basic room has
     * (presently prints might make a GUI later)
     */
    public void displayFeatures() {
        String msg = "This room has ";
        for (String feature : features) {
            msg += String.format("%s, ", feature);
        }
        msg += "\n";
        System.out.println(msg);
    }

    /*
     * returns true if the room is not occupied or booked, false otherwise
     */
    public boolean isEmpty() {
        return (this.guestLst.size() == 0);
    }

    public void clean() {
        System.out.println("This room is being cleaned");
    }

    /*
     * 
    */
    public void initRoom() {
        this.guestLst = new ArrayList<Customer>();
        this.foodLst = new ArrayList<Food>();
    }

    /*
     * resets a room after a customer has checked out
     */
    public void reset() {
        if (!this.isEmpty()) {
            this.clean();
            this.initRoom();
        }
    }

    public ArrayList<Customer> getGuests() {
        return this.guestLst;
    }

    /*
     * returns a list of food a customer has ordered in the room
     */
    public ArrayList<Food> getFood() {
        return this.foodLst;
    }

    public void addFood(Food food) {
        if (!this.isEmpty()) {
            this.foodLst.add(food);
        }
    }

    public void removeFood(Food food) {
        if (!this.isEmpty()) {
            this.foodLst.remove(food);
        }
    }

}
