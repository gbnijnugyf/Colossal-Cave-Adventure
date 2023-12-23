~~~mermaid
classDiagram
Game..>Command
Game "1" o-- "1" Parser
Game "1" o-- "1" Room
Parser "1" --> "1" CommandWords
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
    -String[] validCommands$
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

