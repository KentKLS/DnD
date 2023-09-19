package Enum;

import java.util.Random;

public enum EnumScepters {
    WAND("Harry's Wand","a... stick ? i doubt it's a simple stick..",20),

    NECRO("Necronomicon","a dusty old book, it seems to be radiating evil energy",25),

    STAFF("Merlin's Staff","a beautiful ornated staff, it seems powerful",30),

    STICK("A Simple Stick","a... stick ? is it only a simple stick??",1),

    ORB("Demon Orb","an orb emanating a dark purple glow",18),

    GLOVE("Tyrael's Glove","a single white glove covered in blue glowing runes",20),

            ;
    private final String name;

    private final String description;
    private final int value;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    EnumScepters(String s, String s1, int i ){
        this.name = s;
        this.description = s1;
        this.value= i;
    }
    public static EnumScepters getRandom(){
        return values()[(new Random()).nextInt(values().length)];
    }
}
