package Enum;

import java.util.Random;

public enum EnumShields {
    AEGIS("Athena's Aegis","a huge shining shield radiating with power",40),
    METAL("Simple Metal Shield","a shield seemingly made of metal",25 ),
    ALU("Aluminium Shield Replica","a shiny shield seemingly made of metal",5),
    PRIDWEN("Arthur's Pridwen","a shield with a coat of arms representing a golden dragon",35),
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

    EnumShields(String s, String s1, int i) {
        this.name = s;
        this.description = s1;
        this.value= i;

    }
    public static EnumShields getRandom(){
        return values()[(new Random()).nextInt(values().length)];
    }


}
