package restaurant;

import java.util.ArrayList;

public class Food {
    public static ArrayList<Food> menu = new ArrayList<>();
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        menu.add(this);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
