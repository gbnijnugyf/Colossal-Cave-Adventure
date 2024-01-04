package cn.edu.whut.sept.zuul.Items;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    private Item item;

    @Before
    public void setUp() {
        item = new Item("Sword", itemType.ATTACK, 3, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Sword", item.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(itemType.ATTACK, item.getType());
    }

    @Test
    public void testGetWeight() {
        assertEquals(10, item.getWeight());
    }

    @Test
    public void testGetPower() {
        assertEquals(3, item.getPower());
    }

    @Test
    public void testUse() {
        int result = item.use();
        assertEquals(0, result);
    }

    @Test
    public void testDrop() {
        // No assertion needed for void methods
        item.drop();
    }
}