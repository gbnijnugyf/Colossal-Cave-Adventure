package cn.edu.whut.sept.zuul.Players;


import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.Items;
/**
 * The Player class represents a player in the game.
 */
public class Player {
    private String name;//玩家姓名
    private int health;//玩家生命值
    private int weight;//玩家可负重
    private String roomName;//玩家当前所在房间
    private Items items;//玩家当前持有的物品
    /**
     * Constructs a new Player object.
     */
    public Player() {
    }
    /**
     * Constructs a new Player object with the specified parameters.
     *
     * @param name     The name of the player.
     * @param health   The health of the player.
     * @param weight   The carrying weight limit of the player.
     * @param roomName The name of the room the player is in.
     * @param items    The items the player is holding.
     */
    public Player(String name, int health, int weight, String roomName, Items items) {
        this.name = name;
        this.health = health;
        this.weight = weight;
        this.roomName = roomName;
        this.items = items;
    }

    /**
     * Sets the name of the player.
     *
     * @param name The name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the health of the player.
     *
     * @return The health of the player.
     */
    public int getHealth() {
        return health;
    }
    /**
     * Returns the carrying weight limit of the player.
     *
     * @return The carrying weight limit of the player.
     */
    public int getWeight() {
        return weight;
    }
    /**
     * Returns the name of the room the player is in.
     *
     * @return The name of the room the player is in.
     */
    public String getRoomName() {
        return roomName;
    }
    /**
     * Sets the health of the player.
     *
     * @param health The health of the player.
     */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
     * Sets the carrying weight limit of the player.
     *
     * @param weight The carrying weight limit of the player.
     */
    private void setWeight(int weight) {
        this.weight = weight;
    }
    /**
     * Sets the name of the room the player is in.
     *
     * @param roomName The name of the room the player is in.
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    /**
     * Sets the items the player is holding.
     *
     * @param items The items the player is holding.
     */
    public void setItems(Items items) {
        this.items = items;
    }
    /**
     * Adds an item to the player's inventory.
     *
     * @param item The item to add.
     */
    public void addItem(Item item) {
        items.addItem(item.getName(), item);
        setWeight(this.weight - item.getWeight());
    }
    /**
     * Deletes an item from the player's inventory.
     *
     * @param itemName The name of the item to delete.
     */
    public void deleteItem(String itemName) {
        setWeight(this.weight + items.getItemsByName(itemName).getWeight());
        items.deleteItem(itemName);
    }
    /**
     * Returns the items the player is holding.
     *
     * @return The items the player is holding.
     */
    public Items getItems() {
        return items;
    }

}

