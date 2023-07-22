
import java.util.ArrayList;

public class DoubleRoom {
    private String name2;
    private String contact2;
    private String gender2;
    private String name;
    private String contact;
    private String gender;
    private ArrayList<Food> food = new ArrayList<>();

    public DoubleRoom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }

    public ArrayList<Food> getFood() {
        return this.food;
    }

    public String getName() {
        return this.name;
    }

    public void addFood(Food food) {
        this.food.add(food);
    }

}
