package Equipements.Defense;

public abstract class EquipementDefensif {
    protected String equipementType ;
    protected String equipementName ;
    protected int deflvl;


    /**
     *
     * @param type
     */
//    public EquipementDefensif(String type) {
//        if (type.equals("Guerrier")) {
//            this.equipementType = "Bouclier";
//            this.equipementName = "Aegis";
//            this.deflvl = 40;
//        } else {
//            this.equipementType = "Philtre";
//            this.equipementName = "Morgana's potion";
//            this.deflvl = 20;
//        }
//    }


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n  Type d'arme: "+this.equipementType+ "\n  Nom de l'arme: "+this.equipementName + "\n  Défense donné par l'arme: " + this.deflvl;
    }
}
