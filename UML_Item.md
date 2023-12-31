~~~mermaid
classDiagram
    class Item {
        <<abstract>>
        - String name
        - itemType type
        + String getName()
        + itemType getType()
        + int use()
        + void drop()
    }

    class ItemAttack {
        - int power
        + ItemAttack(String name, int power)
        + int use()
    }

    class ItemDefense {
        - int power
        + ItemDefense(String name, int power)
        + int use()
    }

    class Items {
        - HashMap<String, Item> items
        + Items(HashMap<String, Item> items)
        + void showAllItems()
        + void addItem(String name, Item item)
    }

    Item <|-- ItemAttack
    Item <|-- ItemDefense
    Items o-- Item
~~~