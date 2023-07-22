import java.util.ArrayList;
import java.io.Serializable;

public class SingleRoom implements Serializable {
    String name;
    String contact;
    String gender;
    ArrayList<Food> food = new ArrayList<>();

    public SingleRoom() {
        this.name = "";
    }

    public SingleRoom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}