package cn.edu.whut.sept.zuul;

public class CommandHelp extends CommandWord{
    public CommandHelp(Game gameInfo, CommandWords allCmd) {
        super(gameInfo,allCmd);
    }

    /**
     * 重写方法，利用父类的allCmd展示所有命令
     * @param command
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
