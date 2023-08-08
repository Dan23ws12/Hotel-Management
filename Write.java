import java.io.ObjectOutputStream;

import MVC.Hotel;

import java.io.FileOutputStream;

public class Write implements Runnable {
    Hotel hotel_ob;

    Write(Hotel hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        } catch (Exception e) {
            System.out.println("Error in writing " + e);
        }

    }

    public void readHotel() {

    }

    public void writeHotel() {

    }
}
