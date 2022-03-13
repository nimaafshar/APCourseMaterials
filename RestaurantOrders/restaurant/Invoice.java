package restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private static float tax_rate = (float) 9.4;

    private short state;
    private Customer costumer;
    private LocalDateTime submitTime;
    public ArrayList<Item> items;

    public Invoice(Customer costumer) {
        this.state = -1;
        this.costumer = costumer;
        this.submitTime = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        if (state < 0) {
            this.items.add(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeItem(Item item) {
        if (this.state < 0) {
            for (Item i : this.items) {
                if (i.getFood().getName().equals(item.getFood().getName()))
                    this.items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void nextStage() {
        this.state++;
    }

    public short getState() {
        return state;
    }

    public Customer getCostumer() {
        return costumer;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item i : this.items) {
            totalPrice += i.getFood().getPrice() * i.getCount();
        }
        totalPrice = (int) Math.ceil((1 + tax_rate/100) * (double) totalPrice);
        return totalPrice;
    }
}
