package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    /**
     * 初始化Parser类，创建commands命令对象和reader扫描输入对象
     */
    public Parser() {
        commands = new CommandWords();
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
     * 调用commandWords对象的showAll方法展示所有命令
     */
    public void showCommands() {
        commands.showAll();
    }
}
