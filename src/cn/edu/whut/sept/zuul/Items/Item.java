package cn.edu.whut.sept.zuul.Items;

enum itemType//物品类型分为进攻和防御两种
{
    ATTACK, DEFENSE;
}

/**
 * Items类为物品父类
 * 有用属性name物品名、type物品类型
 * 方法：可以使用use和丢弃drop
 */
public class Item {
    protected String name;//名称
    protected itemType type;
    protected int weight;

    public String getName() {
        return name;
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
