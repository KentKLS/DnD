package Equipements.Potions;

import Equipements.Equipment;

import java.util.HashMap;
import Enum.*;

public class Potion extends Equipment {

    private EnumPotions potionType;

    public String getPotionName() {

        return potionType.getName();
    }

    public String getPotionDesc(){
        return potionType.getDescription();
    }

    public int getPotionValue(){
        return potionType.getValue();
    }
    
    public Potion(){
        this.potionType =EnumPotions.getRandom();
        this.equipementDesc = potionType.getDescription();
        this.equipementType = "potion";
        this.equipementName = potionType.getName();
    }

    public EnumPotions getPotionType() {
        return potionType;
    }

    @Override
    public String toString() {
        return "This potion is a "+potionType.getName()+" it has a value of "+ potionType.getValue();
    }
}
