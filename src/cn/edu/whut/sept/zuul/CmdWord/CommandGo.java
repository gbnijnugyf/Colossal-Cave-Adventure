package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Room;

public class CommandGo extends CommandWord {
    public CommandGo(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    /**
     * 重写doCommand利用传入的command和父类的gameInfo执行go命令
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     *
     * @param command
     */
    @Override
    public void doCommand(Command command) {

        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = gameInfo.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            gameInfo.setCurrentRoom(nextRoom);
            System.out.println(gameInfo.getCurrentRoom().getLongDescription());
        }
    }
}
