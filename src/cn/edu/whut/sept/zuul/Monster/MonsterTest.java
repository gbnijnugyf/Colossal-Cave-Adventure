package cn.edu.whut.sept.zuul.Monster;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {
    private Monster monster;

    @Before
    public void setUp() {
        monster = new Monster("Goblin", 20, 5);
    }

    @Test
    public void testGetName() {
        assertEquals("Goblin", monster.getName());
    }

    @Test
    public void testGetHealth() {
        assertEquals(20, monster.getHealth());
    }

    @Test
    public void testGetPower() {
        assertEquals(5, monster.getPower());
    }

    @Test
    public void testSetName() {
        monster.setName("Orc");
        assertEquals("Orc", monster.getName());
    }

    @Test
    public void testSetHealth() {
        monster.setHealth(30);
        assertEquals(30, monster.getHealth());
    }

    @Test
    public void testSetPower() {
        monster.setPower(10);
        assertEquals(10, monster.getPower());
    }
}