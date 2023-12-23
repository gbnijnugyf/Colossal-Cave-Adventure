package cn.edu.whut.sept.zuul;

public class CommandGo extends CommandWord{
    public CommandGo(Game gameInfo, CommandWords allCmd) {
        super(gameInfo,allCmd);
    }

    /**
     * 重写doCommand利用传入的command和父类的gameInfo执行go命令
     * @param command
     */
    @Override
    public void doCommand(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = gameInfo.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            gameInfo.setCurrentRoom(nextRoom);
            System.out.println(gameInfo.getCurrentRoom().getLongDescription());
        }
    }
}
