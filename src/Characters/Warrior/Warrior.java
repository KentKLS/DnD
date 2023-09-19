package Characters.Warrior;

import Characters.Character;
import Equipements.Defense.Shield;
import Enum.EnumType;
import Equipements.Offense.Weapon;

public class Warrior extends Character {

    public Warrior(String name) {
        this.type = EnumType.warrior;
        this.name = name;
        this.hp = 10;
        this.ap = 10;
        this.equipementOffensif = new Weapon("Basic Sword", 15);
        this.equipementDefensif = new Shield("Wooden Shield", 15);

    }

}
