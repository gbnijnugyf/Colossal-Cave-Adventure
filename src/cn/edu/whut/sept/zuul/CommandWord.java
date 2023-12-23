package cn.edu.whut.sept.zuul;

public class CommandWord {
    protected Game gameInfo;
    protected CommandWords allCmd;

    /**
     * 构造函数传入执行命令需要获取的信息
     * @param gameInfo 游戏信息
     * @param allCmd 命令集合
     */
    public CommandWord(Game gameInfo, CommandWords allCmd){
        this.gameInfo = gameInfo;
        this.allCmd = allCmd;
    }
    public void doCommand(Command command){}
    public boolean isQuit(){return false;}
}
