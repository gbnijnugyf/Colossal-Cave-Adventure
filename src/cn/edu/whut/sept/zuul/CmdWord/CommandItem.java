package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Items.Item;

import java.util.HashMap;

public class CommandItem extends CommandWord{
    /**
     * 构造函数传入执行命令需要获取的信息
     *
     * @param gameInfo 游戏信息
     * @param allCmd   命令集合
     */
    public CommandItem(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    @Override
    public void doCommand(Command command) {
        super.doCommand(command);

        HashMap<String, Item> temp = gameInfo.getPlayer().getItems().getItems();
        if (temp.size() == 0) {
            System.out.println("you has no item.");
            return;
        }
        System.out.print("you have items: ");
        for (String itemName : temp.keySet()) {
            System.out.print(itemName + " ");
        }
        System.out.println();
    }
}
