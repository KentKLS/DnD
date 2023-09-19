package Enum;

import java.util.Random;

public enum EnumEnemy {
    DRAGON("Dragon",300,100),
    ORC("Orc",50,25),

    GOBLIN("Goblin",30,15),

    KOBOLD("Kobold",50,10),

    GRYPHON("Gryphon",100,50),

    RAT("Rat",10,3),
    DOG("Rabid Dog", 20, 8),
    SLIME("Slime", 25,3)
    ;

    private String name;
    private int HP;
    private int AP;


    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAP() {
        return AP;
    }

    EnumEnemy(String s,int i,int i1){
        this.name = s;
        this.HP = i;
        this.AP= i1;
    }
    public static EnumEnemy getRandom(){
        return values()[(new Random()).nextInt(values().length)];
    }

}
