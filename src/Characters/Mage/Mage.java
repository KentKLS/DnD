package Characters.Mage;

import Enum.EnumType;
import Characters.Character;
import Equipements.Defense.Scepter;
import Equipements.Offense.Spell;

public class Mage extends Character {
    public Mage(String name) {
        this.type = EnumType.mage;
        this.name = name;
        this.hp = 6;
        this.ap = 15;
        this.equipementOffensif = new Spell("Fireball", 20);
        this.equipementDefensif = new Scepter("Wooden Staff", 10);
    }
}
