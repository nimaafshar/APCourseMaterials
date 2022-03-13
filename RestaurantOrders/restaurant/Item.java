package restaurant;

import java.util.Objects;

public class Item {
    private Food food;
    private int count;
    private String description;

    public Item(Food food, int count, String description) throws Exception {
        this.food = Objects.requireNonNull(food, "food should not be Null");
        if (count <= 0) {
            throw new Exception("count should be positive");
        }
        this.count = count;
        this.description = description;

    }

    public int getCount() {
        return count;
    }

    public Food getFood() {
        return food;
    }

    public String getDescription() {
        return description;
    }
}
