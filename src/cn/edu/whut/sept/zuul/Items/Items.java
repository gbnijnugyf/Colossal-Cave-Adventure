package cn.edu.whut.sept.zuul.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {
    private HashMap<String, Item> items;

    public Items(HashMap<String, Item> items) {
        this.items = items;
    }

    public void showAllItems() {
        if (items.size() == 0) {
            System.out.println("this place has no item.");
            return;
        }
        System.out.print("Items: ");
        for (String command : items.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }

    public void addItem(String name, Item item) {
        items.put(name, item);
    }
}
