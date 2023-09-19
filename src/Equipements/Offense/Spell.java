package Equipements.Offense;
import Enum.EnumSpells;
public class Spell extends EquipementOffensif {
    private EnumSpells spell;

    public String getSpellName(){ return spell.getName();}
    public String getSpellDesc(){return spell.getDescription();}
    public int getSpellValue(){return spell.getValue();}

    public Spell() {
        this.spell = EnumSpells.getRandom();
        this.attlvl = spell.getValue();
        this.equipementDesc = spell.getDescription();
        this.equipementName = spell.getName();
    }
    public Spell(String name, int attlvl) {
        this.equipementName = name;
        this.equipementDesc = "The simplest spell you could learn";
        this.attlvl = attlvl;
    }

    @Override
    public String toString() {
        return "Name of the Spell: "+ this.equipementName+" Attack Power of the Spell: "+this.attlvl;
    }
}
