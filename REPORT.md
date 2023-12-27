# 软件工程实训任务一——主要任务说明

## 任务目的

* 理解软件代码规范的重要性
* 理解代码变化对软件质量带来的影响
* 掌握基于Git的个人代码版本维护方法
* 掌握MarkDown文件编写方法

## 任务内容

* 阅读、理解和标注样例代码
* 分析和学习代码质量特征、设计方法和编程风格
* 运用所学方法，对开源代码进行标注
* 对样例工程进行简单功能扩充和维护

## 阅读样例工程

我首先阅读了Game这个类。

### Game类解释

Game类是"World-of-Zuul"这个应用程序的主要类。

##### 属性

- parser：用于解析用户输入的命令的解析器对象。
- currentRoom：表示当前所在的房间对象。

##### 方法

- Game()：构造函数，创建游戏实例并初始化内部数据和解析器。
- createRooms()：创建所有房间对象并连接它们的出口，构建迷宫。
- play()：游戏主循环，不断读取用户命令并执行，直到用户输入退出命令。
- printWelcome()：向用户输出欢迎信息。
- processCommand(Command command)：处理用户输入的游戏指令。
- printHelp()：输出游戏帮助信息，列出可用的命令。
- goRoom(Command command)：执行"go"指令，根据指定的方向移动到相邻的房间。
- quit(Command command)：执行"quit"指令，退出游戏。

##### 相关理解

在这个游戏中，玩家可以探索由多个房间组成的迷宫。玩家可以输入不同的命令来执行相应的操作，如移动到相邻房间、获取帮助信息和退出游戏等。游戏的核心逻辑集中在play()
方法中，它不断接收用户输入的命令并调用相应的方法进行处理。游戏通过创建房间对象并连接它们的出口来构建迷宫。玩家可以使用"go"命令来移动到相邻的房间，还可以使用"quit"命令退出游戏。
<hr>
在Game类中有两个属性分别是Parser类类型和Room类类型。
<hr>

### Parser类解释

Parser类用于解析用户输入的命令。

##### 属性

- commands: 用于存放当前命令
- reader: 用于读取用户输入

##### 方法

- Parser()
  ：构造函数，用于初始化commands和reader对象。commands对象是CommandWords类的实例，用于管理游戏中的有效命令。reader对象是用于读取用户输入的Scanner对象，它从标准输入流中读取用户输入的命令。
- getCommand(): Command：该方法用于获取用户输入的命令并返回一个Command对象。它首先提示用户输入命令符号（">"
  ），然后读取用户输入的一行命令。接下来，它使用Scanner对象将输入行分解成单词，并将第一个单词存储在word1变量中，第二个单词存储在word2变量中。最后，它检查word1是否是有效的命令，如果是，则创建一个Command对象并返回，否则创建一个没有命令的Command对象并返回。
- showCommands(): void：该方法用于显示所有有效的命令。它调用CommandWords类的showAll()方法来打印所有有效命令。

##### 相关理解

在这段代码中，Parser类负责解析用户输入的命令，并与CommandWords类一起使用来验证和处理这些命令。它还提供了一个方法来显示游戏中可用的命令列表。
<hr>

### Room类解释

Room类用于表示游戏中的一个房间。

##### 属性

- description：房间的描述信息，用字符串表示。
- exits：存储房间的出口信息的HashMap。键是出口的方向（如"north"、"south"、"east"、"west"等），值是该方向上相邻的房间对象。

##### 方法

- Room(String description)：构造函数，用于创建一个房间对象。需要传入房间的描述信息，并初始化exits为一个空的HashMap。
- setExit(String direction, Room neighbor)：设置房间的出口。传入出口的方向和相邻的房间对象作为参数，将其添加到exits中。
- getShortDescription(): String：获取房间的简短描述信息。返回存储在description属性中的字符串。
- getLongDescription(): String：获取房间的详细描述信息。返回一个包含房间描述和出口信息的字符串。
- getExitString(): String：获取房间的出口信息字符串。遍历exits中的键（即出口方向），将其连接为一个字符串，并返回。
- getExit(String direction): Room：根据给定的出口方向，获取该方向上相邻的房间对象。返回exits中对应方向的房间对象。

##### 相关理解

Room类用于描述游戏中的房间。每个房间对象具有描述、出口和与之相关的方法，可用于设置出口、获取房间描述和出口信息等操作。房间对象通过exits属性来管理与之相邻的其他房间。房间可以有多个出口，每个出口都由一个方向和对应的相邻房间组成。
<hr>
在parser解析器中用于存放当前命令使用的是CommandWords类
<hr>

### CommandWords类解释

CommandWords类用于管理游戏中的有效命令。

##### 属性

- validCommands：一个字符串数组，存储了有效的命令。

##### 方法

- isCommand(String aString):
  boolean：该方法用于检查给定的字符串参数是否是有效的命令。它会遍历存储在validCommands数组中的所有命令，如果找到匹配的命令，则返回true，否则返回false。
- showAll(): void：该方法用于显示所有有效的命令。它会遍历validCommands数组，并将每个命令打印到控制台上，以空格分隔。

#### 相关理解

CommandWords类用于管理游戏中的有效命令。它提供了方法来检查给定的字符串是否是有效的命令，并显示所有有效的命令列表。有效的命令存储在validCommands数组中，可以根据需要进行修改和扩展。

<hr>
而在命令信息的传输过程中，使用的是Command类进行信息传递
<hr>

### Command类解释

##### 属性

- commandWord：表示命令的第一个单词，用字符串表示。
- secondWord：表示命令的第二个单词，用字符串表示。

##### 方法

- Command(String firstWord, String secondWord)
  ：构造函数，用于创建一个Command对象。需要传入命令的第一个单词和第二个单词，并将它们分别赋值给commandWord和secondWord属性。

- getCommandWord(): String：获取命令的第一个单词。返回存储在commandWord属性中的字符串。

- getSecondWord(): String：获取命令的第二个单词。返回存储在secondWord属性中的字符串。

- isUnknown(): boolean：判断命令是否未知（即commandWord为null）。如果命令未知，返回true；否则返回false。

- hasSecondWord(): boolean：判断命令是否有第二个单词（即secondWord不为null）。如果命令有第二个单词，返回true；否则返回false。

#### 相关理解

Command类用于表示用户输入的命令。每个Command对象包含命令的第一个单词和第二个单词，并提供了一些方法用于获取这些单词和判断命令的属性（如是否未知、是否有第二个单词等）。该类可以用于处理用户输入的命令，并在游戏中执行相应的操作。

### 画出UML类图
~~~mermaid
classDiagram
Game..>Command
Game "1" o-- "1" Parser
Game "1" o-- "1" Room
Parser "1" --> "1" CommandWords
Parser ..> Command:create
Game ..> Room:create
class Command{
    -String commandWord
    -String secondWord
    +Command(firstWord:String, secondWord:String)
    +getCommandWord() String
    +getSecondWord() String
    +isUnknown() boolean
    +hasSecondWord() boolean
}
class CommandWords{
    -String[] validCommands
    +CommandWords()
    +isCommand(aString:String) boolean
    +showAll()
}
class Game{
    -Parser parser 
    -Room currentRoom
    -createRooms()
    +play()
    -printWelcome()
    -processCommand(command:Command) boolean
    -printHelp()
    -goRoom(command:Command)
    -quit(command:Command) boolean
}
class Parser{
    -CommandWords commands
    -Scanner reader
    +Parser()
    +getCommand() Command
    +showCommands()
}
class Room{
    -String description
    -HashMap~String, Room~ exits
    +Room(description:String)
    +setExit(direction:String, neighbor:Room)
    +String getShortDescription()
    +String getLongDescription()
    -String getExitString()
    +getExit(direction:String) Room
}
class Main{
    +main(args:String[])*
}
~~~


## 扩充和维护样例工程

* 对样例代码中的功能设计进行分析，找出若干设计缺陷和改进点，并进行修正或扩充，并集成到工程代码中；
* 可借助代码质量分析工具或代码规范检查工具对代码质量进行分析，发现潜在问题；

### 改进

* 根据面向对象的设计原则，我将命令单独创建为CommandWord类，而CommandWords类中含有属性cmdWords，其类型为HashMap<String, CommandWord> 用于存放所有命令。并创建成员函数private
  void createCommands()，在构造函数中调用用于创建命令，createCommands() 的逻辑就是将CommandWord类型（CommandWord的子类）命令逐一添加进cmdWords中

```
cmdWords.put("quit",new CommandQuit(gameInfo,this));
cmdWords.put("help",new CommandHelp(gameInfo,this));
cmdWords.put("go",new CommandGo(gameInfo,this));
```

从代码中可以看到添加的命令类型都是以命令命名的类，均为CommandWord子类。CommandWord类中包含两个属性三个方法。

```java
/**
 * isQuit用于特殊处理quit命令——需要返回退出信息，而其他命令均不返回退出信息，所以默认reaturn false
 * doCommand函数需要子类实现。不同的命令需要用不同的方式实现，而实现这些命令过程中需要用到游戏信息和所有命令信息，
 * 因此CommandWord中需要包含Game和CommandWords类型的属性以便于子类执行命令时调用。
 */
public class CommandWord {
    protected Game gameInfo;
    protected CommandWords allCmd;
    /**
     * 构造函数传入执行命令需要获取的信息
     * @param gameInfo 游戏信息
     * @param allCmd 命令集合
     */
    public CommandWord(Game gameInfo, CommandWords allCmd) {
        this.gameInfo = gameInfo;
        this.allCmd = allCmd;
    }
    public void doCommand(Command command) {
    }
    public boolean isQuit() {
        return false;
    }
}
```
### 画出UML类图
~~~mermaid
classDiagram
    class CommandWord {
        - gameInfo: Game
        - allCmd: CommandWords
        + CommandWord(gameInfo: Game, allCmd: CommandWords)
        + doCommand(command: Command): void
        + isQuit(): boolean
    }

    class CommandQuit {
        + CommandQuit(gameInfo: Game, allCmd: CommandWords)
        + isQuit(): boolean
    }

    class CommandHelp {
        + CommandHelp(gameInfo: Game, allCmd: CommandWords)
        + doCommand(command: Command): void
    }

    class CommandGo {
        + CommandGo(gameInfo: Game, allCmd: CommandWords)
        + doCommand(command: Command): void
    }

    class CommandWords {
        + showAll(): void
    }

    CommandWord <|-- CommandQuit
    CommandWord <|-- CommandHelp
    CommandWord <|-- CommandGo
    Parser o-- CommandWords
    Game <.. Parser
    CommandWords *-- CommandWord
~~~

### 测试
* 我完成上述修改后，对game中的processCommand方法进行了单元测试，测试用例为三个命令词“go”、“help”和“quit”。go和help预期输出为字符串，quit预期输出直接为退出游戏的true。三个测试用例均成功通过

## 功能扩充点
    * 样例工程“world-of-zuul”具备最基本的程序功能，该项目具有极大的扩展空间，各位同学可选择或自行设计系统结构优化或功能扩充需求，完成3项左右的功能扩充实现；

   > 可供参考的结构优化或功能扩充项包括但不限于以下内容：
   >
   > 1. 扩展游戏，使得一个房间里可以存放任意数量的物件，每个物件可以有一个描述和一个重量值，玩家进入一个房间后，可以通过“look”命令查看当前房间的信息以及房间内的所有物品信息；
   > 2. 在游戏中实现一个“back”命令，玩家输入该命令后会把玩家带回上一个房间；
   > 3. 在游戏中实现一个更高级的“back”命令，重复使用它就可以逐层回退几个房间，直到把玩家带回到游戏的起点；
   > 4. 在游戏中增加具有传输功能的房间，每当玩家进入这个房间，就会被随机地传输到另一个房间；
   > 5. 在游戏中新建一个独立的Player类用来表示玩家，并实现下列功能需求：
        >    * 一个玩家对象应该保存玩家的姓名等基本信息，也应该保存玩家当前所在的房间；
        >
    * 玩家可以随身携带任意数量的物件，但随身物品的总重量不能操过某个上限值；
   > * 在游戏中增加两个新的命令“take”和“drop”，使得玩家可以拾取房间内的指定物品或丢弃身上携带的某件或全部物品，当拾取新的物件时超过了玩家可携带的重量上限，系统应给出提示；
       >
    * 在游戏中增加一个新的命令“items”, 可以打印出当前房间内所有的物件及总重量，以及玩家随身携带的所有物件及总重量；
   > * 在某个或某些房间中随机增加一个magic cookie（魔法饼干）物件，并增加一个“eat cookie”命令，如果玩家找到并吃掉魔法饼干，就可以增长玩家的负重能力；
   > 6. 扩充游戏基本架构，使其支持网络多人游戏模式，具备玩家登陆等功能；
   > 7. 为单机或网络版游戏增加图形化用户界面，用过可以通过图形化界面执行游戏功能；
   > 8. 可以为游戏增加数据库功能，用于保存游戏状态和用户设置；
   > 9. ......

5. 编写测试用例
    * 针对功能改进和扩充，在项目结构中编写单元测试用例，对代码执行单元测试；

## 任务输出

1. 以UML图表示的样例工程软件结构；
2. 在所有源代码文件中完成源代码标注和扩充，并通过git提交到代码库；；
3.

每位同学在项目根目录下创建一个名称为REPORT.md的文件（与README.md文件同级），以markdown语法格式编写本实训任务的报告，主要包含样例工程的代码结构分析（可以用UML类图及文字进行说明），以及自己改进的功能实现说明；
