package Enum;

import java.util.Random;

public enum EnumPotions {
    HEALTH("Health Potion", "a red glowing flask", 10),
    DEFENSE("Defense Potion", "a blue glowing flask", 10),
    POWER("Power Potion", "a flask, you can't seem to discern its content", 5),
    RAGE("Rage Potion", "a menacingly shaped flask", 10),
    POISON("Poison", "a green glowing flask", 5),

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

    public static EnumPotions getRandom(){
        return values()[(new Random()).nextInt(values().length)];
    }

    EnumPotions(String s, String s1, int i) {
        this.name = s;
        this.description = s1;
        this.value= i;

    }
}
