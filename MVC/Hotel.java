package MVC;

import java.io.Serializable;
import java.util.HashMap;

import Rooms.Room;
import Rooms.DoubleRoom;
import Rooms.SingleRoom;
import Exceptions.EmptyRoomException;
import Exceptions.InvalidValueException;
import Exceptions.NotAvailableException;
import Exceptions.OverBookedException;
import Users.Customer;

import java.util.ArrayList;

interface Observable {
    public void notifyObservers();

    public void attach(Observer observer);

    public void detach(Observer observer);

}

/*
 * A class representing the state of a hotel by storing all the rooms
 * There are 8 single and double rooms in this hotel.
 * Each room has a room number, single rooms are numbered 1-8, double rooms are
 * numbered 9-16
 */
public class Hotel implements Serializable, Observable {
    private HashMap<Integer, Room> hotelRooms;
    private HashMap<Integer, Integer[]> roomFeatureState;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private static int NUM_DOUBLE_ROOMS = 8;
    private static int NUM_SINGLE_ROOMS = 8, DOUBLE_ROOM_START_NO = NUM_SINGLE_ROOMS + 1;
    // double rooms number start at 9 = 8 (number of single rooms) + 1
    private static int TOTAL_NUM_ROOMS = NUM_DOUBLE_ROOMS + NUM_SINGLE_ROOMS;

    public Hotel() {
        this.hotelRooms = new HashMap<Integer, Room>();
        this.roomFeatureState = new HashMap<Integer, Integer[]>();
        this.startHotel();
    }

    /*
     * if the hotel just starts maps all room numbers to their respective rooms
     */
    public void startHotel() {
        Integer[] featureArr = { 0, 0, 0 };
        for (int i = 1; i <= NUM_SINGLE_ROOMS; i++) {
            this.hotelRooms.put(i, new SingleRoom());
            this.roomFeatureState.put(i, featureArr);
        }
        for (int i = DOUBLE_ROOM_START_NO; i <= TOTAL_NUM_ROOMS; i++) {
            this.hotelRooms.put(i, new DoubleRoom());
            this.roomFeatureState.put(i, featureArr);
        }

    }

    /*
     * this function books room associated with the given room number and
     * occupied by the two guests
     */
    public void bookRoom(int roomNum, ArrayList<Customer> guests)
            throws NotAvailableException, OverBookedException, InvalidValueException {
        Room room = this.hotelRooms.get(roomNum);
        room.book(guests);
    }

    public void checkIn(int roomNum, ArrayList<Customer> guests) {

    }

    /*
     * This function cleans and checks out all customers in the room associated the
     * given number
     */
    public float checkOut(int roomNum) throws InvalidValueException, EmptyRoomException {
        Room room = getRoomAtNo(roomNum);
        return room.checkout();
    }

    /*
     * this function returns the room that has the given room number
     * throws an exception if no room is given said number
     * 
     * @param roomNum: a positive number
     */
    public Room getRoomAtNo(int roomNum) throws InvalidValueException {
        if ((roomNum < 0) || (roomNum > TOTAL_NUM_ROOMS)) {
            throw new InvalidValueException("room number ", Integer.toString(roomNum));
        }
        return hotelRooms.get(roomNum);
    }

    public void order(int roomNum, Food food) throws InvalidValueException, EmptyRoomException {
        Room room = this.getRoomAtNo(roomNum);
        room.addFood(food);
    }

    /*
     * returns a list of all the rooms a customer has booked
     */
    public ArrayList<Room> getBookedRooms(Customer cust) {
        ArrayList<Room> bookedRooms = new ArrayList<Room>();
        for (Room room : hotelRooms.values()) {
            ArrayList<Customer> guests = room.getGuests();
            if (guests.contains(cust)) {
                bookedRooms.add(room);
            }
        }

        return bookedRooms;
    }

    protected HashMap<Integer, Integer[]> getFeatureState() {
        return this.roomFeatureState;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /*
     * adds an observer to the list of observers
     */
    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    /*
     * removes an observer to the list of observers
     */
    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }
}