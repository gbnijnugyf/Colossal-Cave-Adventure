package cn.edu.whut.sept.zuul.Players;

import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.ItemAttack;
import cn.edu.whut.sept.zuul.Items.ItemDefense;
import cn.edu.whut.sept.zuul.Items.Items;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
//      public Player(String name, int health, int weight, String roomName, Items items) {
        player = new Player("John");
        item1 = new ItemAttack("Sword", 3,3);
        item2 = new ItemDefense("Shield", 2,3);
    }

    @Test
    public void testGetName() {
        assertEquals("John", player.getName());
    }

    @Test
    public void testGetHealth() {
        assertEquals(10, player.getHealth());
    }

    @Test
    public void testGetWeight() {
        assertEquals(5, player.getWeight());
    }

    @Test
    public void testGetRoomName() {
        assertEquals("outside", player.getRoomName());
    }

    @Test
    public void testSetName() {
        player.setName("Jane");
        assertEquals("Jane", player.getName());
    }

    @Test
    public void testSetHealth() {
        player.setHealth(15);
        assertEquals(15, player.getHealth());
    }

    @Test
    public void testSetRoomName() {
        player.setRoomName("kitchen");
        assertEquals("kitchen", player.getRoomName());
    }

    @Test
    public void testAddItem() {
        player.addItem(item1);
        Items items = player.getItems();
        assertTrue(items.getItemsByName("Sword")!=null);
        assertEquals(2, player.getWeight());
    }

    @Test
    public void testDeleteItem() {
        player.addItem(item1);
//        player.addItem(item2);
        player.deleteItem("Sword");
        Items items = player.getItems();
        assertFalse(items.getItemsByName("Sword")!=null);
        assertEquals(5, player.getWeight());
    }
}