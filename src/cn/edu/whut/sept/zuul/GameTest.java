package cn.edu.whut.sept.zuul;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;
    private PrintStream console;
    private ByteArrayOutputStream bytes;

    // 预处理
    @Before
    public void beforetest() throws Exception {
        bytes = new ByteArrayOutputStream();
        game = new Game();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    // 后处理
    @After
    public void aftertest() throws Exception {
        System.setOut(console);
    }

    @Test
    public void testGo() throws Exception {
        Method processCommand = game.getClass().getDeclaredMethod("processCommand", Command.class);
        processCommand.setAccessible(true);
        Command testCmd = new Command("go", null);
        processCommand.invoke(game, testCmd);
        String expected = "Go where?";
        assertEquals(expected, bytes.toString().trim());
    }

    @Test
    public void testHelp() throws Exception {
        Method processCommand = game.getClass().getDeclaredMethod("processCommand", Command.class);
        processCommand.setAccessible(true);
        Command testCmd = new Command("help", null);
        processCommand.invoke(game, testCmd);
        //此处\r\n是为了符合windows系统控制台输出的换行符
        String expected = "You are lost. You are alone. You wander\r\n" +
                "around at the university.\r\n" +
                "\r\n" +
                "Your command words are:\r\n" +
                "help  go  quit";
        assertEquals(expected, bytes.toString().trim());
    }

    @Test
    public void testQuit() throws Exception {
        Method processCommand = game.getClass().getDeclaredMethod("processCommand", Command.class);
        processCommand.setAccessible(true);
        Command testCmd = new Command("quit", null);
        Object result = processCommand.invoke(game, testCmd);
        boolean expected = true;
        assertEquals(expected, result);
    }
}
