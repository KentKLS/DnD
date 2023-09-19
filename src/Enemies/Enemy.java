package Enemies;
import  Enum.EnumEnemy;
import Equipements.Equipment;
import Equipements.EquipmentFactory;
import GameLogic.Cases.Case;

public class Enemy {
    private Equipment loot;
    private EnumEnemy enemy;

    public Equipment getLoot() {
        return loot;
    }

    private int HP;
    public Enemy(){
        this.enemy = EnumEnemy.getRandom();
        this.HP = enemy.getHP();
        this.loot= EquipmentFactory.createRandomLoot();
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getEnemyAP(){
        return enemy.getAP();
    }

    public String getEnemyName(){
        return enemy.getName();
    }
    @Override
    public String toString() {
        return "The enemy is a "+enemy.getName()+"\nHidden stats:\n HP: "+enemy.getHP()+"\n AP: "+enemy.getAP()+"\n This enemy loot:"+this.loot;
    }
    public void loseHP(int value) {
        this.HP -= value;
    }

}
