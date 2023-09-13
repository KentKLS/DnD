package Characters.Warrior;

import Characters.Personnage;
import Equipements.Defense.Shield;
import Enum.EnumType;
import Equipements.Offense.EquipementOffensif;
import Equipements.Offense.Weapon;

public class Warrior extends Personnage {

    public Warrior(){
        this.type = EnumType.warrior;
        this.name = "Default Danny";
        this.hp = 10;
        this.ap= 10;
        this.equipementOffensif= new Weapon();
        this.equipementDefensif= new Shield();
    }

    public Warrior(String name){
        this.type = EnumType.warrior;
        this.name = name;
        this.hp = 10;
        this.ap= 10;
        this.equipementOffensif= new Weapon();
        this.equipementDefensif= new Shield();
    }

}
