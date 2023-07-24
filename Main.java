import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            File f = new File("backup");
            if (f.exists()) {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                // Hotel.hotel_ob = (Hotel) ois.readObject();
                ois.close();
                fin.close();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            char wish;
        } catch (Exception e) {
            System.out.println("Not a valid input");
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
