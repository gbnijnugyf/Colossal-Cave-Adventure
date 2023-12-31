package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.Items;

import java.util.Set;
import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits; //用于存放空间出口
    private Items items;//用于存放空间物品

    /**
     * 初始化Room类，添加描述和空间出口
     *
     * @param description
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new Items(new HashMap<>());
    }

    /**
     * 添加一个空间出口
     *
     * @param direction 空间描述（名称）
     * @param neighbor  该空间的相邻空间
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * 添加一个物品
     *
     * @param name 物品名称
     * @param item 物品对象
     */
    public void setItem(String name, Item item) {
        items.addItem(name, item);
    }

    /**
     * 获取该空间物品
     */
    public void getItems() {
        items.showAllItems();
    }

    /**
     * 获取该空间描述
     *
     * @return 返回空间描述
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * 增加提示结合空间描述
     *
     * @return 返回结合提示词后的描述字符串
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * 获取该空间所有出口
     *
     * @return 返回Exits：空间所有出口的字符串
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        //遍历加入字符串
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 根据描述获取空间出口
     *
     * @param direction 描述
     * @return 返回空间出口
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}


