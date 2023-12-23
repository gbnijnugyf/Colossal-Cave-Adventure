package cn.edu.whut.sept.zuul;

public class CommandWords
{
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    /**
     * 初始化
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * 判断是否是合法命令
     * @param aString 待处理的输入串
     * @return 如果是合法命令则返回true，否则返回false
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * 展示所有命令
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
