package cn.edu.whut.sept.zuul.CmdWord;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Items.Item;
import cn.edu.whut.sept.zuul.Items.itemType;
import cn.edu.whut.sept.zuul.Monster.Monster;
import cn.edu.whut.sept.zuul.Players.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandFight extends CommandWord {
    /**
     * 构造函数传入执行命令需要获取的信息
     *
     * @param gameInfo 游戏信息
     * @param allCmd   命令集合
     */
    public CommandFight(Game gameInfo, CommandWords allCmd) {
        super(gameInfo, allCmd);
    }

    @Override
    public void doCommand(Command command) {
        Monster monsterTemp = gameInfo.getCurrentRoom().getMonster();
        Player playerTemp = gameInfo.getPlayer();
        HashMap<String, Item> weaponTemp = gameInfo.getPlayer().getItems().getItems();

        System.out.println("Your health: " + playerTemp.getHealth());

        ArrayList<Item> attackWeapon = new ArrayList<>();
        ArrayList<Item> defenseWeapon = new ArrayList<>();

        if (weaponTemp.size() == 0) {
            System.out.println("you has no weapon!");
        } else {
            System.out.print("your weapons: ");
            for (Item item : weaponTemp.values()) {
                if (item.getType() == itemType.ATTACK) {
                    attackWeapon.add(item);
                } else if (item.getType() == itemType.DEFENSE) {
                    defenseWeapon.add(item);
                }
                System.out.print(item.getName() + "(" + item.getType() + ")" + ":" + item.getPower() + " ");
            }
        }
        System.out.println();
        System.out.println("Monster's health: " + monsterTemp.getHealth());
        System.out.println("Monster's power: " + monsterTemp.getPower());

        //计算玩家血量
        int playerBlood = playerTemp.getHealth();
        int hurt = monsterTemp.getPower();
        while (hurt > 0 && defenseWeapon.size() > 0) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < defenseWeapon.size(); i++) {
                int powerTemp = defenseWeapon.get(i).getPower();
                //找最小
                if (powerTemp < min) {
                    min = powerTemp;
                    idx = i;
                }
            }
            playerTemp.deleteItem(defenseWeapon.get(idx).getName());
            defenseWeapon.remove(idx);
            hurt -= min;
        }
        playerBlood -= hurt;
        if (playerBlood <= 0) {
            System.out.println("You lost");
            gameInfo.gameOver();
        } else {
            playerTemp.setHealth(playerBlood);
        }

        //计算怪物血量
        int monsterBlood = monsterTemp.getHealth();
        while (attackWeapon.size() > 0 && monsterBlood > 0) {
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for (int i = 0; i < attackWeapon.size(); i++) {
                int powerTemp = attackWeapon.get(i).getPower();
                if (powerTemp > max) {
                    max = powerTemp;
                    idx = i;
                }
            }
            playerTemp.deleteItem(attackWeapon.get(idx).getName());
            attackWeapon.remove(idx);
            monsterBlood -= max;
        }
        if (monsterBlood > 0) {
            System.out.println("Monster is still alive!! Health:" + monsterBlood);
            System.out.println("Your health:" + playerBlood);
            System.out.println("Run now!");
            monsterTemp.setHealth(monsterBlood);
        } else {
            System.out.println("Monster is dead!");
            System.out.println("You are win!!!");
            gameInfo.gameOver();
        }
    }
}
