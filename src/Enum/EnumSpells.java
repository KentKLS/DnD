package Enum;

import java.util.Random;

public enum EnumSpells {
    ICELANCE("Icelance","a spell book titled: Icelance",18),
    TRASH("Summon Light","a spell book, its name seems to have been erased by time",1),

    OP("Summon Lightning","an old spell book, its name seems to have been erased by time",45),

    FROSTBOLT("Frost Bolt","a spell book titled: 'Frost Bolt' By ArchMage Heister",28),

    DISINTEGRATE("Disintegrate","a spell book with an indecipherable runic title",34),
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
    EnumSpells(String s, String s1, int i) {
        this.name = s;
        this.description = s1;
        this.value= i;

    }
    public static EnumSpells getRandom(){
        return values()[(new Random()).nextInt(values().length)];
    }

}
