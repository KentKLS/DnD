package Equipements.Defense;
import Enum.EnumScepters;

public class Scepter extends EquipementDefensif {
    public  EnumScepters scepter;

    public String getScepterDesc(){return scepter.getDescription();}

    public String getScepterName(){return scepter.getName();}

    public int getScepterValue(){ return  scepter.getValue();}
    public Scepter() {
        this.scepter = EnumScepters.getRandom();
        this.deflvl = scepter.getValue();
        this.equipementDesc = scepter.getDescription();
        this.equipementName = scepter.getName();


    }
    public Scepter(String name, int deflvl) {
        this.equipementName = name;
        this.deflvl = deflvl;
    }

    @Override
    public String toString() {
        return "Name of the OffHand Item: "+this.equipementName+" Defense of the OffHand Item:" + this.deflvl;
    }
}
