package Equipements.Defense;

import Enum.EnumShields;

public class Shield extends EquipementDefensif {
    private EnumShields shield;

    public String getShieldName() {
        return shield.getName();
    }

    public String getShieldDesc() {
        return shield.getDescription();
    }

    public int getShieldValue() {
        return shield.getValue();
    }

    public Shield() {

        this.shield = EnumShields.getRandom();
        this.deflvl = shield.getValue();
        this.equipementDesc = shield.getDescription();
        this.equipementName = shield.getName();

    }

    public Shield(String name, int deflvl) {
        this.equipementName = name;
        this.deflvl = deflvl;
    }

    @Override
    public String toString() {
        return "The name of the Shield: " + this.equipementName + " Defense of the Shield: " + this.deflvl;
    }
}
