package cn.edu.whut.sept.zuul.Monster;

import java.util.HashMap;

public class Monsters {
    private HashMap<String, Monster> allMonster;

    public Monsters(HashMap<String, Monster> allMonster) {
        this.allMonster = allMonster;
    }

    public Monsters() {
        allMonster = new HashMap<>();
    }

    public void addMonster(Monster monster){
        allMonster.put(monster.getName(),monster);
    }
    public void deleteMonster(String monsterName){
        allMonster.remove(monsterName);
    }
}
