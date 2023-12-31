package cn.edu.whut.sept.zuul.Items;

public class ItemAttack extends Item{
    private int power;//力量
    public ItemAttack(String name, int power){
        this.power = power;
        this.name = name;
        this.type = itemType.ATTACK;
    }
    @Override
    public int use() {
        return power;
    }

}
