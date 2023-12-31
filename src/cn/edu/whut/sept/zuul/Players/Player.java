package cn.edu.whut.sept.zuul.Players;


import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.Items;

public class Player {
    private String name;//玩家姓名
    private int health;//玩家生命值
    private int weight;//玩家可负重
    private String roomName;//玩家当前所在房间
    private Items items;//玩家当前持有的物品

    public Player() {
    }

    public Player(String name, int health, int weight, String roomName, Items items) {
        this.name = name;
        this.health = health;
        this.weight = weight;
        this.roomName = roomName;
        this.items = items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getWeight() {
        return weight;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.addItem(item.getName(), item);
        setWeight(this.weight - item.getWeight());
    }

    public void deleteItem(String itemName) {
        setWeight(this.weight + items.getItemsByName(itemName).getWeight());
        items.deleteItem(itemName);
    }

    public Items getItems() {
        return items;
    }

}

