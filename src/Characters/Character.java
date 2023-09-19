package Characters;

import Equipements.Defense.EquipementDefensif;
import Equipements.Equipment;
import Equipements.Offense.EquipementOffensif;
import Enum.EnumType;

public abstract class Character {
    protected EnumType type;
    public int def;

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    protected String name;
    protected int hp;
    protected int ap;
    protected Equipment equipementOffensif;
    protected Equipment equipementDefensif;

    public EnumType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setEquipementOffensif(Equipment equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public void setEquipementDefensif(Equipment equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public Equipment getEquipementOffensif() {
        return equipementOffensif;
    }

    public Equipment getEquipementDefensif() {
        return equipementDefensif;
    }

    @Override
    public String toString() {
        return "Votre personnage s'appelle" + this.name;
    }

    public String getDetails() {
        return "Votre personnage s'appelle " + this.name + "\nVotre personnage est un " + this.type + "\nStats: \n Health Point: " + this.hp + "\n Attack Powaa: " + this.ap+"\n Defense: "+this.getDef() + "\nEquipments: \n Main Hand: " + this.equipementOffensif + "\n Off Hand: " + this.equipementDefensif;
    }

    public void loseHP(int value) {
        this.hp -= value;
    }
    public void gainHP(int value) {
        this.hp += value;
    }
    public void gainAP(int value){
        this.ap += value;
    }
    public void loseAP(int value){
        this.ap -= value;
    }
    public void gainDef(int value){
        this.def += value;
    }
    public void loseDef(int value){
        this.def -= value;
    }
}


