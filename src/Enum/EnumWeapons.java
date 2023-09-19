package Enum;

import java.util.Random;

public enum EnumWeapons {
    GUNGNIR("Odin's Gungnir", "A golden Spear, seems to have a life of it's own", 40),

    MJÖLLNIR("Thor's Mjöllnir", "an heavy looking war hammer, can you lift it ?", 35),

    EXCALIBUR("Arthur's Excalibur", "a shiny sword, it's stick from the ground as if it was stuck in it", 30),

    ALU("Aluminium Sword", "a shiny sword seemingly made of metal", 5),

    IRON("Iron Sword", "a sword seemingly made of a sturdy metal", 20),
    DÁINSLEIF("Dáinsleif","a dark blade, you can feel its thirst for blood",30),
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

    EnumWeapons(String s, String s1, int i) {
        this.name = s;
        this.description = s1;
        this.value = i;

    }
    public static EnumWeapons getRandom(){
        return values()[(new Random()).nextInt(values().length)];
    }

}

