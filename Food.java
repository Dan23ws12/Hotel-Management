
public class Food {
    private String name;
    private String type;
    int quantity;
    float price;

    Food(String name, String type, int quantity, float price) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void serveFood() {
        System.out.println(String.format("we are serving %s", this.name));
    }
}
