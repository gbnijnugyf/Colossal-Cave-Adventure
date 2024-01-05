package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Items.Item;

public class CommandPick extends CommandWord {
    /**
     * 构造函数传入执行命令需要获取的信息
     *
     * @param gameInfo 游戏信息
     * @param allCmd   命令集合
     */
    public CommandPick(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    /**
     * Executes the pick command.
     *
     * @param command The command to execute.
     */
    @Override
    public void doCommand(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to pick...
            System.out.println("Pick what?");
            return;
        }

        String itemName = command.getSecondWord();

        // Try to pick up
        Item pickItem = gameInfo.getCurrentRoom().getItems().getItemsByName(itemName);

        if (pickItem == null) {
            System.out.println("There is no item!");
        }
//        else if (gameInfo.getPlayer().getWeight()< pickItem.getWeight()) {
//            System.out.println("you can't carry too much!");
//        }
        else {
            if (gameInfo.getPlayer().addItem(pickItem)) {
                gameInfo.getCurrentRoom().deleteItem(pickItem.getName());
                System.out.println("pick up " + pickItem.getName() + " successfully");
            } else {
                System.out.println("you can't carry too much!");
            }
        }
    }
}
