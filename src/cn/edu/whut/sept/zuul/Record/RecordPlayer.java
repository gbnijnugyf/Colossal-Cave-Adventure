package cn.edu.whut.sept.zuul.Record;

import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.Items;
import cn.edu.whut.sept.zuul.Players.Player;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordPlayer implements Record {
    private String filePath;
    private Player player;
    private Items allItems;

    /**
     * 保存玩家信息时无需得知allItems全部物品信息，则当该属性为null时执行保存操作
     *
     * @param filePath 文件路径
     * @param player   玩家完整信息
     */
    public RecordPlayer(String filePath, Player player) {
        this.filePath = filePath;
        this.player = player;
    }


    /**
     * 加载玩家信息时需要得知全部物品信息，调用该构造函数时需要加载玩家，外部可通过get方法获取玩家信息
     *
     * @param filePath   文件路径
     * @param playerName 加载玩家信息需要知道玩家姓名
     * @param allItems   所有物品信息
     */
    public RecordPlayer(String filePath, String playerName, Items allItems) {
        this.player = new Player();
        this.filePath = filePath;
        this.player.setName(playerName);
        this.allItems = allItems;
        load();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
//    public void save() {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            StringBuilder data = new StringBuilder();
//            data.append(player.getName()).append(",").append(player.getHealth()).append(",").append(player.getWeight()).append(",").append(player.getRoomName()).append(",");
//
//            if (!player.getItems().getItems().isEmpty()) {
//                StringBuilder itemsData = new StringBuilder();
//                for (Item item : player.getItems().getItems().values()) {
//                    itemsData.append(item.getName()).append(",");
//                }
//                data.append(itemsData.deleteCharAt(itemsData.length() - 1));
//            }
//
//            writer.write(data.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void save() {
        try {
            // 读取CSV文件内容到列表中
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            HashMap<String, String> newItems = new HashMap<>(); // 替换为新的玩家持有物品
            // 在列表中查找对应玩家姓名的行并更新数据
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] data = line.split(",");
                String name = data[0];

                if (name.equals(player.getName())) {

                    StringBuilder dataLine = new StringBuilder();
                    dataLine.append(player.getName()).append(",").append(player.getHealth()).append(",").append(player.getWeight()).append(",").append(player.getRoomName()).append(",");

                    if (!player.getItems().getItems().isEmpty()) {
                        StringBuilder itemsData = new StringBuilder();
                        for (Item item : player.getItems().getItems().values()) {
                            itemsData.append(item.getName()).append(",");
                        }
                        dataLine.append(itemsData.deleteCharAt(itemsData.length() - 1));
                    }

//                    // 更新生命值、负重和房间位置
//                    data[1] = String.valueOf(player.getHealth());
//                    data[2] = String.valueOf(player.getWeight());
//                    data[3] = player.getRoomName();
//                    // 更新玩家持有物品
//                    StringBuilder itemsBuilder = new StringBuilder();
//
//                    // 添加新物品
//                    for (HashMap.Entry<String, String> entry : newItems.entrySet()) {
//                        itemsBuilder.append(",");
//                        itemsBuilder.append(entry.getKey());
//                        itemsBuilder.append(":");
//                        itemsBuilder.append(entry.getValue());
//                    }
//
//                    data[4] = itemsBuilder.toString();
                    // 更新行数据
                    lines.set(i, String.valueOf(dataLine));

                    // 找到对应行后，可以退出循环
                    break;
                }
            }

            // 将更新后的内容写回CSV文件
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("玩家数据已成功更新。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];

                if (name.equals(player.getName())) {
                    int health = Integer.parseInt(data[1]);
                    int weight = Integer.parseInt(data[2]);
                    String roomName = data[3];

                    HashMap<String, String> items = new HashMap<>();
                    HashMap<String, Item> itemMap = new HashMap<>();
                    for (int i = 4; i < data.length; i++) {
                        items.put(data[i], data[i]);
                    }
                    for (String itemName : items.keySet()) {
                        itemMap.put(itemName, allItems.getItemsByName(itemName));
                    }

                    Items tempItem = new Items(itemMap);
                    // 打印读取的数据
                    System.out.println("Name: " + name);
                    System.out.println("Health: " + health);
                    System.out.println("Weight: " + weight);
                    System.out.println("Room Name: " + roomName);
                    System.out.println("Items: " + items);
                    this.player = new Player(name, health, weight, roomName, tempItem);
                    // 找到对应行后，可以退出循环
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
