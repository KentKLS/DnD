package Characters.Mage;
import Enum.EnumType;
import Characters.Personnage;
import Equipements.Defense.Philter;
import Equipements.Offense.Spell;
public class Mage extends Personnage {
    public Mage(){
        this.type = EnumType.mage;
        this.name = "Default Dan";
        this.hp = 6;
        this.ap= 15;
        this.equipementOffensif= new Spell();
        this.equipementDefensif= new Philter();
    }
    public Mage(String name){
        this.type = EnumType.mage;
        this.name = name;
        this.hp = 6;
        this.ap= 15;
        this.equipementOffensif= new Spell();
        this.equipementDefensif= new Philter();
    }
}
