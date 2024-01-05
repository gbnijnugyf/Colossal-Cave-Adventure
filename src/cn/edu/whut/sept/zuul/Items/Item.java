package cn.edu.whut.sept.zuul.Items;

/**
 * Items类为物品父类
 * 有用属性name物品名、type物品类型
 * 方法：可以使用use和丢弃drop
 */
public class Item {
    protected String name;//名称
    protected itemType type;
    protected int weight;
    protected int power;

    public Item(String name, itemType type, int power, int weight) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public itemType getType() {
        return type;
    }

    public int use() {
        return 0;
    }

    public void drop() {
    }
}
