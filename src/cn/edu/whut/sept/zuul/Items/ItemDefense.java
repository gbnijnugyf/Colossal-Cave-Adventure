package cn.edu.whut.sept.zuul.Items;

public class ItemDefense extends Item {
    private int power;//力量

    public ItemDefense(String name, int power,int weight) {
        this.power = power;
        this.name = name;
        this.weight = weight;
        this.type = itemType.DEFENSE;
    }

    @Override
    public int use() {
        return power;
    }
}
