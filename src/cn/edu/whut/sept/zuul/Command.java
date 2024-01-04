package cn.edu.whut.sept.zuul;

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * 读入命令，将输入的命令分别分为commandWord和secondWord
     * @param firstWord 第一个命令
     * @param secondWord 第二个命令词
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * 获取命令词
     * @return 返回commandWord
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * 获取命令词后的词
     * @return 返回secondWord
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 判断命令是否已知
     * @return 若commandWord不存在则返回true，否则返回false
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * 判断第二词是否存在
     * @return 若secondWord存在则返回true，否则返回false
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
