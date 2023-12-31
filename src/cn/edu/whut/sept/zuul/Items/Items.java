package cn.edu.whut.sept.zuul.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {

    private HashMap<String, Item> items;

    public Items() {
        items = new HashMap<>();
    }

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

    public HashMap<String, Item> getItems() {
        return items;
    }

    /**
     * @param name
     * @return
     */
    public Item getItemsByName(String name) {
        return items.get(name);
    }

    public void addItem(String name, Item item) {
        items.put(name, item);
    }
    public void deleteItem(String name) {
        items.remove(name);
    }
}
