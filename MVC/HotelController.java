package MVC;

import java.util.ArrayList;

import Exceptions.InvalidValueException;
import Exceptions.NotAvailableException;
import Users.Customer;

public class HotelController {

    private Hotel hotel;
    private HotelView view;

    public HotelController(Hotel hotel, HotelView view) {
        this.hotel = hotel;
        this.view = view;
    }

    public void book(int roomNum, ArrayList<Customer> guests) {
        try {
            hotel.bookRoom(roomNum, guests);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkOut(int roomNum) {
        try {
            hotel.checkOut(roomNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void orderFood(int roomNum, Food food) {
        try {
            hotel.order(roomNum, food);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * throws an InvalidException if any of the arguments is null or an empty string
     */
    private void checkArguments(String[] args) throws InvalidValueException {
        for (String arg : args) {
            if (arg == null) {
                throw new InvalidValueException();
            }
            if (arg.equals("")) {
                throw new InvalidValueException(arg);
            }
        }
    }
}
