package Equipements;

import Equipements.Defense.*;
import Equipements.Offense.*;
import Equipements.Potions.*;

import java.util.Random;

public class EquipmentFactory {
    private static final Random random = new Random();

    public static Equipment createRandomLoot() {
        int choice = random.nextInt(5);

        switch (choice) {
            case 0:
                return new Shield();
            case 1:
                return new Scepter();
            case 2:
                return new Spell();
            case 3:
                return new Weapon();
            case 4:
                return new Potion();
            default:
                return null;
        }
    }

    public static Equipment createRandomMageEquipment() {
        int choice = random.nextInt(2);
        switch (choice) {
            case 0:
                return new Spell();
            case 1:
                return new Scepter();
            default:
                return null;
        }
    }
    public static Equipment createRandomWarEquipment() {
        int choice = random.nextInt(2);
        switch (choice) {
            case 0:
                return new Shield();
            case 1:
                return new Weapon();
            default:
                return null;
        }
    }

}

