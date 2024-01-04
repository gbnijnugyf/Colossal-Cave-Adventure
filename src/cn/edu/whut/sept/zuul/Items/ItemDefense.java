package cn.edu.whut.sept.zuul.Items;

public class ItemDefense extends Item {

    public ItemDefense(String name, int power, int weight) {
        super(name, itemType.DEFENSE, power, weight);
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
