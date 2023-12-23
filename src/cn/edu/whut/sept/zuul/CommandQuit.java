package cn.edu.whut.sept.zuul;

public class CommandQuit extends CommandWord{
    public CommandQuit(Game gameInfo, CommandWords allCmd) {
        super(gameInfo,allCmd);
    }

    /**
     * 重写isQuit方法，该命令返回true，确认退出
     * @return
     */
    @Override
    public boolean isQuit() {
        return true;
    }
}
