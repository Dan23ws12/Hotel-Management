import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * A class representing the state of a hotel by storing all the rooms
 * There are 8 single and double rooms in this hotel.
 * Each room has a room number, single rooms are numbered 1-8, double rooms are numbered 9-16
*/
public class Hotel implements Serializable {
    private HashMap<Integer, Room> hotelRooms;
    private static int NUM_DOUBLE_ROOMS = 8;
    private static int NUM_SINGLE_ROOMS = 8, DOUBLE_ROOM_START_NO = NUM_SINGLE_ROOMS + 1;
    // double rooms number start at 9 = 8 (number of single rooms) + 1
    private static int TOTAL_NUM_ROOMS = NUM_DOUBLE_ROOMS + NUM_SINGLE_ROOMS;

    public Hotel() {
        this.hotelRooms = new HashMap<Integer, Room>();
        this.startHotel();
    }

    /*
     * if the hotel just starts maps all room numbers to their respective rooms
     */
    public void startHotel() {
        for (int i = 1; i <= NUM_SINGLE_ROOMS; i++) {
            this.hotelRooms.put(i, new SingleRoom());
        }
        for (int i = DOUBLE_ROOM_START_NO; i <= TOTAL_NUM_ROOMS; i++) {
            this.hotelRooms.put(i, new DoubleRoom());
        }

    }

    /*
     * this function books a double room associated with the given room number and
     * occupied by the two guests
     */
    public void allocateRoom(int roomNum, ArrayList<Customer> guests) throws NotAvailableException {
        Room room = this.hotelRooms.get(roomNum);
        if (room.isEmpty()) {
            room.bookRoom(guests);
        } else {
            throw new NotAvailableException(roomNum);
        }
    }

    /*
     * This function cleans and checks out all customers in the room associated the
     * given number
     */
    public void deallocateRoom(int roomNum) throws InvalidValueException {
        Room room = getRoomAtNo(roomNum);
        if (!room.isEmpty()) {
            room.clean();
            room.reset();
        } else {
            System.out.println(String.format("room no: %d is empty", roomNum));
        }
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

    public void order(int roomNum, Food food) throws InvalidValueException {
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

}