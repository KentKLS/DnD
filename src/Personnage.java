import javax.xml.namespace.QName;

public class Personnage {
    private String type;
    private String name;
    private int hp;
    private int ap;
    private EquipementOffensif  equipementOffensif ;
    private EquipementDefensif  equipementDefensif;

// Constucteur sans paramètres
    public Personnage() {
        this.type = "Guerrier";
        this.name = "Default Danny";
        this.hp = 10;
        this.ap = 10;
        this.equipementOffensif = new EquipementOffensif(this.type);
        this.equipementDefensif = new EquipementDefensif(this.type);
    }
//Constructeur avec 1 paramètre nom
    public Personnage(String name) {
        this.name= name;
        this.type = "Magicien";
        this.hp = 6;
        this.ap = 15;
        this.equipementOffensif = new EquipementOffensif(this.type);
        this.equipementDefensif = new EquipementDefensif(this.type);
    }
//Constructeur avec 2 paramètres nom et type
    public Personnage(String name, String type) {
        this.name= name;
        this.type = type;
        if (type.equals("Guerrier")) {
            this.hp = 10;
            this.ap = 10;
        } else {
            this.hp = 6;
            this.ap = 15;
        }
        this.equipementDefensif = new EquipementDefensif(this.type);
        this.equipementOffensif = new  EquipementOffensif(this.type);
    }

    // Methode toString pour "ecrire" l'objet
    @Override
    public String toString() {
        return "Votre personnage s'appelle "+this.name+"\nVotre personnage est un "+this.type+"\nStats: \n Health Point: "+this.hp+"\n Attack Powaa: "+this.ap+"\nEquipements: \n Main Hand: "+this.equipementOffensif+"\n Off Hand: "+ this.equipementDefensif;
    }
}

