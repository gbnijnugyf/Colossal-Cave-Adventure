package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;

public class CommandQuit extends CommandWord {
    public CommandQuit(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    /**
     * 重写isQuit方法，该命令返回true，确认退出
     *
     * @return 返回true
     */
    @Override
    public boolean isQuit() {
        return true;
    }
}
