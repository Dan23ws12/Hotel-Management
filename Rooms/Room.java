package Rooms;

import java.util.ArrayList;

import Exceptions.EmptyRoomException;
import Exceptions.InvalidValueException;
import Exceptions.NotAvailableException;
import Exceptions.OverBookedException;
import MVC.Food;
import Users.Customer;

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
    private static int MAX_NUM_GUESTS = 1;
    private static String[] features = { "FREE BREAKFAST", "BED", "ROOM SERVICE", "GYM" };
    // a list of features a room must have
    private ArrayList<Food> foodLst;

    // creates an empty room
    public Room() {
        this.initRoom();
    }

    /*
     * If the room is not empty and the number of guest occupying the room is not
     * over the maximum, the
     * room is booked, all guests in the guest list occupy this room.
     * Otherwise, appropriate exceptions are thrown
     */
    public void book(ArrayList<Customer> guests)
            throws OverBookedException, InvalidValueException, NotAvailableException {
        bookHelper(guests, MAX_NUM_GUESTS);
    }

    protected void bookHelper(ArrayList<Customer> guests, int maxNumGuests)
            throws OverBookedException, InvalidValueException, NotAvailableException {
        if (guests.size() == 0) {
            throw new InvalidValueException("guest list", "empty list");
        }
        if (maxNumGuests < 0) {
            throw new InvalidValueException("a number less than zero", " maximum number of guests");
        }
        if (!this.isEmpty()) {
            throw new NotAvailableException();
        }
        if (guests.size() > maxNumGuests) {
            throw new OverBookedException(MAX_NUM_GUESTS);
        } else {
            this.guestLst = guests;
        }
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
    private void initRoom() {
        this.guestLst = new ArrayList<Customer>();
        this.foodLst = new ArrayList<Food>();
    }

    /*
     * resets a room after a customer has checked out
     */
    private void reset() {
        if (!this.isEmpty()) {
            this.clean();
            this.initRoom();
        }
    }

    /*
     * this method checks out all customers from a room
     */
    public float checkout() throws EmptyRoomException {
        if (this.isEmpty()) {
            throw new EmptyRoomException();
        }
        float foodPrice = 0;
        for (Food food : foodLst) {
            foodPrice += food.getPrice();
        }
        this.reset();
        return foodPrice;
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

    public void addFood(Food food) throws EmptyRoomException {
        if (this.isEmpty()) {
            throw new EmptyRoomException();
        }
        this.foodLst.add(food);
    }

    public void removeFood(Food food) throws EmptyRoomException {
        if (this.isEmpty()) {
            throw new EmptyRoomException();
        }
        this.foodLst.remove(food);
    }

    /*
     * after food has been ordered, the food can be served
     */
    public void serveFood(int foodIndex) {
        if ((foodIndex < 0) || (foodIndex >= foodLst.size())) {
            // TODO make exception saying there's no food at that spot
        }
        Food food = foodLst.get(foodIndex);
        food.serveFood();
    }

}
