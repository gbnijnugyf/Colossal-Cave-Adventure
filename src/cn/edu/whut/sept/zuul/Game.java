/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * <p>
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 * <p>
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.ItemAttack;
import cn.edu.whut.sept.zuul.Items.ItemDefense;
import cn.edu.whut.sept.zuul.Items.Items;
import cn.edu.whut.sept.zuul.Monster.Monster;
import cn.edu.whut.sept.zuul.Monster.Monsters;
import cn.edu.whut.sept.zuul.Players.Player;
import cn.edu.whut.sept.zuul.Record.RecordPlayer;

import java.util.*;

import static cn.edu.whut.sept.zuul.util.FindKeyByValueInHashMap.getKeyByValue;

public class Game {
    private Parser parser;

    private Room currentRoom;
    private Items allItems;
    private Monsters allMonsters;
    private HashMap<String, Room> allRoom;
    private Player player;

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game() {
        allItems = new Items();
        allMonsters = new Monsters();
        allRoom = new HashMap<>();

        createRooms();

        parser = new Parser(this);
    }

    /**
     * 加载玩家信息
     */
    private void loadPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.载入历史记录");
        System.out.println("2.新建游戏");
        System.out.println("3.退出");
        System.out.print("请选择（编号）：");
        String choice = scanner.nextLine();
        if(choice!="1"||choice!="2"){
            System.exit(0);
        }
        String playerName = "";
        //读取玩家姓名
        System.out.print("请输入玩家昵称：");
        playerName = scanner.nextLine();
        //文件路径暂定为”testFile.csv“
        RecordPlayer temp = new RecordPlayer("testFile.csv", playerName, allItems);

        switch (choice) {
            case "1":
                if (!temp.load()) {
                    System.out.println("找不到该玩家信息！");
                    System.exit(0);
                }
                this.player = temp.getPlayer();
                break;
            case "2":
                if (temp.checkIsInRecord()) {
                    System.out.println("含有相同昵称玩家信息！");
                    System.exit(0);
                } else {
                    this.player = new Player(playerName);
                }

                break;
            default:
                System.exit(0);
                break;
        }
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms() {

        ArrayList<Room> rooms = new ArrayList();
        ArrayList<Item> items = new ArrayList();
        ArrayList<Monster> monsters = new ArrayList();
        Room outside, theater, pub, lab, office;
        Item sword, shield;
        Monster satan;

        //create monster
        satan = new Monster("satan", 2, 2);
        //加入所有怪物集合
        allMonsters.addMonster(satan);

        //create item
        sword = new ItemAttack("sword", 2, 3);
        shield = new ItemDefense("shield", 3, 3);
        //加入所有物品集合
        allItems.addItem("sword", sword);
        allItems.addItem("shield", shield);

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        //加入所有房间集合
        allRoom.put("outside", outside);
        allRoom.put("theater", theater);
        allRoom.put("pub", pub);
        allRoom.put("lab", lab);
        allRoom.put("office", office);

        //加入数组;
        monsters.add(satan);
        items.add(sword);
        items.add(shield);
        rooms.add(outside);
        rooms.add(theater);
        rooms.add(pub);
        rooms.add(lab);
        rooms.add(office);

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        // initialise room items randomly
        Random rand = new Random();// 生成随机数
        int randNumber;
        for (int i = 0; i < items.size(); i++) {
            randNumber = rand.nextInt(rooms.size());
            rooms.get(randNumber).setItem(items.get(i).getName(), items.get(i));
        }
        for (int i = 0; i < monsters.size(); i++) {
            randNumber = rand.nextInt(rooms.size());
            rooms.get(randNumber).setMonster(monsters.get(i));
        }

        loadPlayer();
        currentRoom = allRoom.get(player.getRoomName());  // start game
    }

    /**
     * 游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);

        }
        System.out.println("Thank you for playing.  Good bye.");

        gameOver();
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     *
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        wantToQuit = parser.handleCmd(command);
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * 由于执行go命令需要对当前房间进行读写操作，于是设置访问器
     *
     * @return
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the current room for the player.
     *
     * @param setCurrentRoom The room to set as the current room.
     */
    public void setCurrentRoom(Room setCurrentRoom) {
        this.currentRoom = setCurrentRoom;
    }

    /**
     * Returns the player object.
     *
     * @return The player object.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Ends the game and performs necessary actions.
     * Saves the player's current room and exits the game.
     */
    public void gameOver() {
        String roomName = getKeyByValue(allRoom, currentRoom);
        this.player.setRoomName(roomName);
        RecordPlayer temp = new RecordPlayer("testFile.csv", player);
        temp.save();
        System.exit(0);
    }
}