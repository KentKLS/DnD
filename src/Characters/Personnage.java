package Characters;

import Equipements.Defense.EquipementDefensif;
import Equipements.Offense.EquipementOffensif;
import Enum.EnumType;

import javax.xml.namespace.QName;

public abstract class Personnage {
    protected EnumType type;
    protected String name;
    protected int hp;
    protected int ap;
    protected EquipementOffensif equipementOffensif ;
    protected EquipementDefensif equipementDefensif;

    public EnumType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }

    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
    }
    /**
     *
     */
//    public Personnage() {
//        this.type = "Guerrier";
//        this.name = "Default Danny";
//        this.hp = 10;
//        this.ap = 10;
//        this.equipementOffensif = new EquipementOffensif(this.type);
//        this.equipementDefensif = new EquipementDefensif(this.type);
//    }

    /**
     *
     * @param name
     */
//    public Personnage(String name) {
//        this.name= name;
//        this.type = "Magicien";
//        this.hp = 6;
//        this.ap = 15;
//        this.equipementOffensif = new EquipementOffensif(this.type);
//        this.equipementDefensif = new EquipementDefensif(this.type);
//    }

    /**
     *
     * @param name
     * @param type
     */
//    public Personnage(String name, String type) {
//        this.name= name;
//        this.type = type;
//        if (type.equals("Guerrier")) {
//            this.hp = 10;
//            this.ap = 10;
//        } else {
//            this.hp = 6;
//            this.ap = 15;
//        }
//        this.equipementDefensif = new EquipementDefensif(this.type);
//        this.equipementOffensif = new EquipementOffensif(this.type);
//    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "name:"+this.name +" type:"+ this.type+" HP:"+this.hp+" AP:"+this.ap;
    }
    public String getDetails() {
        return "Votre personnage s'appelle "+this.name+"\nVotre personnage est un "+this.type+"\nStats: \n Health Point: "+this.hp+"\n Attack Powaa: "+this.ap+"\nEquipments: \n Main Hand: "+this.equipementOffensif+"\n Off Hand: "+ this.equipementDefensif;
    }
}

