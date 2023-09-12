public class EquipementOffensif {
    private String equipementType;
    private String equipementName;
    private int attlvl;

    public EquipementOffensif(String type) {
        if (type.equals("Guerrier")) {
            this.equipementType = "Arme";
            this.equipementName = "Excalibur";
            this.attlvl = 20;
        } else {
            this.equipementType = "Sort";
            this.equipementName = "Fireball";
            this.attlvl = 34;
        }

    }

    @Override
    public String toString() {
        return "\n  Type d'arme: "+this.equipementType+ "\n  Nom de l'arme: "+this.equipementName + "\n  AP donné par l'arme: " + this.attlvl;
    }
}
