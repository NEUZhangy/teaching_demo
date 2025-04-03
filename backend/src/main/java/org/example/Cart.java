package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    private double total;

    public Cart() {
        this.total = 0;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.countPrice();
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.countPrice();
        }
        return total;
    }

    public List<Item> getCartItems() {
        return items;
    }
}
