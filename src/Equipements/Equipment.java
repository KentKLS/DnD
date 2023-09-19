package Equipements;

public abstract class Equipment {
    protected String equipementType ;
    protected String equipementName ;
    protected String equipementDesc ;
    protected int attlvl;

    public int getAttlvl() {
        return attlvl;
    }
    protected int deflvl;

    public int getDeflvl() {
        return deflvl;
    }

    public String getEquipementType() {
        return equipementType;
    }

    public String getEquipementName() {
        return equipementName;
    }

    public String getEquipementDesc() {
        return equipementDesc;
    }
}
