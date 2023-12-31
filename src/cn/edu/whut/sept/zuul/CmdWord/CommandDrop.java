package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Items.Item;

public class CommandDrop extends CommandWord{

    /**
     * 构造函数传入执行命令需要获取的信息
     *
     * @param gameInfo 游戏信息
     * @param allCmd   命令集合
     */
    public CommandDrop(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    @Override
    public void doCommand(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to pick...
            System.out.println("drop what?");
            return;
        }

        String itemName = command.getSecondWord();

        // Try to drop
        Item pickItem = gameInfo.getPlayer().getItems().getItemsByName(itemName);

        if (pickItem == null) {
            System.out.println("There is no item!");
        }  else {
            gameInfo.getPlayer().deleteItem(itemName);
            System.out.println("throw away "+pickItem.getName()+" successfully");
        }
    }
}
