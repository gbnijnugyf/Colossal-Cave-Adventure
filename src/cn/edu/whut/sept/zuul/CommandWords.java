package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.CmdWord.*;

import java.util.HashMap;

public class CommandWords {
    private final Game gameInfo;
    private final HashMap<String, CommandWord> cmdWords = new HashMap<String, CommandWord>();

    /**
     * 初始化
     *
     * @param gameInfo 游戏信息
     */
    public CommandWords(Game gameInfo) {
        this.gameInfo = gameInfo;
        createCommands();
        // nothing to do at the moment...
    }

    private void createCommands() {
        cmdWords.put("quit", new CommandQuit(gameInfo, this));
        cmdWords.put("help", new CommandHelp(gameInfo, this));
        cmdWords.put("go", new CommandGo(gameInfo, this));
        cmdWords.put("look", new CommandLook(gameInfo, this));
        cmdWords.put("item", new CommandItem(gameInfo, this));
        cmdWords.put("pick", new CommandPick(gameInfo, this));
        cmdWords.put("drop", new CommandDrop(gameInfo, this));
        cmdWords.put("fight", new CommandFight(gameInfo, this));
    }

    /**
     * 判断是否是合法命令
     *
     * @param aString 待处理的输入串
     * @return 如果是合法命令则返回true，否则返回false
     */
    public boolean isCommand(String aString) {
        return (cmdWords.get(aString) != null);
    }

    /**
     * 处理传入的命令
     *
     * @param command 传入命令
     * @return 返回是否退出
     */
    public boolean handleCmd(Command command) {
        String word = command.getCommandWord();//获取（第一个）命令词
        CommandWord cmd = cmdWords.get(word);
        if (cmd != null) {
            if (cmd.isQuit()) {
                return true;
            }
            cmd.doCommand(command);
        }
        return false;
    }

    /**
     * 展示所有命令
     */
    public void showAll() {
        for (String command : cmdWords.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
