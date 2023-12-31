package cn.edu.whut.sept.zuul.Items;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * The Items class represents a collection of items.
 */
public class Items {

    private HashMap<String, Item> items;
    /**
     * Constructs an empty Items object.
     */
    public Items() {
        items = new HashMap<>();
    }
    /**
     * Constructs an Items object with the specified items.
     *
     * @param items The items to initialize the collection with.
     */
    public Items(HashMap<String, Item> items) {
        this.items = items;
    }
    /**
     * Displays all the items in the collection.
     * If there are no items, it prints a message indicating that the place has no items.
     */
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

    /**
     * Returns the HashMap of items.
     *
     * @return The HashMap of items.
     */
    public HashMap<String, Item> getItems() {
        return items;
    }

    /**
     * Returns the item with the specified name.
     *
     * @param name The name of the item.
     * @return The item with the specified name, or null if not found.
     */
    public Item getItemsByName(String name) {
        return items.get(name);
    }

    /**
     * Adds an item to the collection.
     *
     * @param name The name of the item.
     * @param item The item to add.
     */
    public void addItem(String name, Item item) {
        items.put(name, item);
    }
    /**
     * Deletes an item from the collection.
     *
     * @param name The name of the item to delete.
     */
    public void deleteItem(String name) {
        items.remove(name);
    }
}
