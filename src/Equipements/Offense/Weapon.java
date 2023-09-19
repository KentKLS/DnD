package Equipements.Offense;

import Equipements.Offense.EquipementOffensif;
import Enum.EnumWeapons;
public class Weapon extends EquipementOffensif {
    public String equipementType = "Weapon";
    public  EnumWeapons weapon;

    public String getWeaponName(){return weapon.getName();}
    public String getWeaponDesc(){return weapon.getDescription();}
    public int getWeaponValue(){return weapon.getValue();}

    public Weapon() {
        this.weapon= EnumWeapons.getRandom();
        this.attlvl = weapon.getValue();
        this.equipementDesc = weapon.getDescription();
        this.equipementName = weapon.getName();

    }
    public Weapon(String name, int attlvl) {
        this.equipementName = name;
        this.attlvl = attlvl;
    }

    @Override
    public String toString() {
        return "Name of the Weapon: "+ this.equipementName +" Attack Power of the Weapon:"+this.attlvl;
    }
}
