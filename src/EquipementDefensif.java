public class EquipementDefensif {
    private String equipementType ;
    private String equipementName ;
    private int deflvl;


    public EquipementDefensif(String type) {
        if (type.equals("Guerrier")) {
            this.equipementType = "Bouclier";
            this.equipementName = "Aegis";
            this.deflvl = 40;
        } else {
            this.equipementType = "Philtre";
            this.equipementName = "Morgana's potion";
            this.deflvl = 20;
        }
    }
    @Override
    public String toString() {
        return "\n  Type d'arme: "+this.equipementType+ "\n  Nom de l'arme: "+this.equipementName + "\n  Défense donné par l'arme: " + this.deflvl;
    }
}
