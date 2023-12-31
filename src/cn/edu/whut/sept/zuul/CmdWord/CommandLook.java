package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;

public class CommandLook extends CommandWord{
    /**
     * 构造函数传入执行命令需要获取的信息
     *
     * @param gameInfo 游戏信息
     * @param allCmd   命令集合
     */
    public CommandLook(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    @Override
    public void doCommand(Command command) {
        super.doCommand(command);
        gameInfo.getCurrentRoom().getItems();
    }
}
