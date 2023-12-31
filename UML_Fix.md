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