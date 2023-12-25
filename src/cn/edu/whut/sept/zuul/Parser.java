package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;
    private Game gameInfo;

    /**
     * 初始化Parser类，创建commands命令对象、reader扫描输入对象和游戏信息
     */
    public Parser(Game gameInfo) {
        this.gameInfo = gameInfo;
        commands = new CommandWords(gameInfo);


        reader = new Scanner(System.in);
    }

    /**
     * 获取命令，通过扫描一行读出一行中的命令词和第二词
     *
     * @return 若命令词合法则返回两个词（即使第二词为null），否则只返回第二词
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();
        //读取一行输入
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {//若有next
            word1 = tokenizer.next();   //读取值
            if (tokenizer.hasNext()) {//若还有next
                word2 = tokenizer.next();//读取下一个值
            }
        }

        if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    /**
     * 传入命令，并交给commands类处理命令
     * @param command 传入命令
     * @return 返回处理函数返回的布尔值，表示是否退出
     */
    public boolean handleCmd(Command command) {
        return commands.handleCmd(command);
    }

}
