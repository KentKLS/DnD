package Equipements.Offense;

import Equipements.Defense.EquipementDefensif;

public abstract class EquipementOffensif {
    protected String equipementType;
    protected String equipementName;
    protected int attlvl;

    /**
     *
     * @param type
     */
//    public EquipementOffensif(String type) {
//        if (type.equals("Guerrier")) {
//            this.equipementType = "Arme";
//            this.equipementName = "Excalibur";
//            this.attlvl = 20;
//        } else {
//            this.equipementType = "Sort";
//            this.equipementName = "Fireball";
//            this.attlvl = 34;
//        }
//    }
//    public EquipementOffensif(){
//
//    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n  Type d'arme: "+this.equipementType+ "\n  Nom de l'arme: "+this.equipementName + "\n  AP donné par l'arme: " + this.attlvl;
    }
}
