package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;

public class CommandHelp extends CommandWord {
    public CommandHelp(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    /**
     * 重写方法，利用父类的allCmd展示所有命令
     * 执行help指令，在终端打印游戏帮助信息.
     * 此处会输出游戏中用户可以输入的命令列表
     *
     * @param command 被执行的命令（处理过）
     */
    @Override
    public void doCommand(Command command) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        allCmd.showAll();
    }
}
