package GameLogic;

import Enum.EnumType;
import Enum.EnumPotions;
import Characters.Character;
import Enemies.Enemy;
import Enum.EnumText;
import Equipements.Equipment;
import Equipements.Offense.EquipementOffensif;
import Equipements.Offense.Weapon;
import Equipements.Potions.Potion;
import Exceptions.CharOutOfBoundException;
import GameLogic.Cases.*;

import java.util.ArrayList;

public class Game {

    private Menu menu;
    public final String BLUECHAR = EnumText.blue.getColorValue();

    private final String YTCHAR = EnumText.light_white.getColorValue();
    private final String CYANCHAR = EnumText.light_cyan.getColorValue();
    private final String RESETCHARMODS = EnumText.reset.getColorValue();
    private final String REDCHAR = EnumText.red.getColorValue();
    private final String LIGHTGREENCHAR = EnumText.light_green.getColorValue();
    private final String GREENCHAR = EnumText.green.getColorValue();
    private final String LIGHTPURPLECHAR = EnumText.light_purple.getColorValue();
    private final String LIGHTREDCHAR = EnumText.light_red.getColorValue();
    private final String LIGHTYELLOWCHAR = EnumText.light_yellow.getColorValue();
    private final String YELLOWCHAR = EnumText.yellow.getColorValue();
    private final String BOLDCHAR = EnumText.bold.getColorValue();
    private int playerPos = 0;
    private int turnPlayed;
    private int tableLength;
    public Character playerCharacter;


    public int getTurnPlayed() {
        return turnPlayed;
    }

    public int getTableLength() {
        return tableLength;
    }

    public int getPlayerPos() {
        return this.playerPos;
    }

    public Menu getMenu() {
        return menu;
    }

    public int diceRoll() {
        return (int) (Math.random() * 6) + 1;
    }

    public int coinFlip() {
        return (int) (Math.random() * 2 + 1);
    }


    public void setPlayerCharacter(Character playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    private ArrayList<Case> gameBoard;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void populateGameBoard(int size) {
        int nbCaseEmpty = (size / 6);
        int nbCaseEnemy = (size / 3);
        int nbCaseEquipment = (size / 4);
        int nbCasePotion = (size / 4);
        while (size > 0) {
            if (nbCaseEmpty > 0) {
                this.gameBoard.add(new CaseEmpty(this.menu));
                size--;
                nbCaseEmpty--;
            }
            if (nbCaseEnemy > 0) {
                this.gameBoard.add(new CaseEnemy(this.menu));
                nbCaseEnemy--;
                size--;
            }
            if (nbCasePotion > 0) {
                this.gameBoard.add(new CaseEquipment(this.menu));
                nbCasePotion--;
                size--;
            }
            if (nbCaseEquipment > 0) {
                this.gameBoard.add(new CasePotion(this.menu));
                nbCaseEquipment--;
                size--;
            }
            if (size  == 1 ){
                size--;
            }
        }
    }

    public Game() {
        this.gameBoard = new ArrayList<>();
    }

    public void setSpecificTableLength() {
        this.tableLength = gameBoard.size();
    }

    public void gameTurn() throws CharOutOfBoundException {
        int dice = this.diceRoll();
        System.out.println(BLUECHAR + "Dice roll value: " + dice);
        this.playerPos = playerPos + dice;
        if (playerPos > tableLength - 1) {
            throw new CharOutOfBoundException("Character went out of bound");
        }

        turnPlayed++;
    }

    public void caseInteraction() {
        gameBoard.get(playerPos).interaction(playerCharacter);
    }

    public void combatInteraction(Enemy enemy) {
        while (enemy.getHP() > 0 || playerCharacter.getHp() > 0) {
            int playerAP = playerCharacter.getAp() + playerCharacter.getEquipementOffensif().getAttlvl();
            enemy.loseHP(playerAP);
            System.out.println(playerCharacter.getName() + " hit " + enemy.getEnemyName() + " dealing " + playerAP + " damage");
            if (enemy.getHP() <= 0) {
                System.out.println("The ennemy is dead congratulations !");
                menu.lootInteractionMenu(enemy.getLoot());
            } else {
                playerCharacter.loseHP(enemy.getEnemyAP());
                System.out.println(enemy.getEnemyName() + " hit " + playerCharacter.getName() + " dealing " + playerAP + " damage");
                checkDeath();

            }
        }
    }

    public void checkDeath() {
        if (playerCharacter.getHp() <= 0) {
            System.out.println("\nYou died, RIP " + playerCharacter.getName());
            if (playerCharacter.getType().equals(EnumType.mage)) {
                menu.getMagesList().remove(playerCharacter);
            } else if (playerCharacter.getType().equals(EnumType.warrior)) {
                menu.getWarriorsList().remove(playerCharacter);
            }
            menu.restartChoice();
        }
    }

    public void switchEquipment(Equipment equipment) {
        if (equipment.getEquipementType().equals("offense")) {
            System.out.println("You successfully exchanged " + playerCharacter.getEquipementOffensif().getEquipementName() + " for " + equipment.getEquipementName());
            playerCharacter.setEquipementOffensif(equipment);
            menu.afterInteractionMenu();
        } else {
            System.out.println("You successfully exchanged " + playerCharacter.getEquipementDefensif().getEquipementName() + " for " + equipment.getEquipementName());
            playerCharacter.setEquipementDefensif(equipment);
            menu.afterInteractionMenu();
        }
    }

    public void drinkPot(Equipment potion) {
        if (potion.getEquipementName().equals(EnumPotions.DEFENSE.getName())) {
            System.out.println("You feel protected");
            playerCharacter.gainDef(EnumPotions.DEFENSE.getValue());
            menu.afterInteractionMenu();
        } else if (potion.getEquipementName().equals(EnumPotions.HEALTH.getName())) {
            System.out.println("You gain some Health Point back ");
            playerCharacter.gainHP(EnumPotions.HEALTH.getValue());
            menu.afterInteractionMenu();
        } else if (potion.getEquipementName().equals(EnumPotions.RAGE.getName())) {
            if (playerCharacter.getType().equals(EnumType.warrior)) {
                playerCharacter.gainAP(EnumPotions.RAGE.getValue());
                System.out.println("You feel like you have gained power");
                menu.afterInteractionMenu();
            } else {
                System.out.println("Nothing Happened");
                menu.afterInteractionMenu();
            }
        } else if (potion.getEquipementName().equals(EnumPotions.POWER.getName())) {
            if (playerCharacter.getType().equals(EnumType.mage)) {
                playerCharacter.gainAP(EnumPotions.POWER.getValue());
                System.out.println("You feel like you have gained power");
                menu.afterInteractionMenu();
            } else {
                System.out.println("Nothing Happened");
                menu.afterInteractionMenu();
            }
        } else if (potion.getEquipementName().equals(EnumPotions.POISON.getName())) {
            System.out.println("It's disgusting, you feel nauseous and end up vomiting blood");
            playerCharacter.loseHP(EnumPotions.POISON.getValue());
            checkDeath();
            menu.afterInteractionMenu();
        }

    }

    public void tryToFlee(Enemy enemy) {
        int rdm = (int) (Math.random() * 3);
        switch (rdm) {
            case 0 -> {
                System.out.println("You managed to flee unscathed");
                menu.afterInteractionMenu();
            }
            case 1 -> {
                int random = (int) (Math.random() * 9) + 1;
                playerCharacter.loseHP(random);
                System.out.println("You manage to flee but the enemy manage to hit you on your way out \n You lost " + random + "HP");
                checkDeath();
                menu.afterInteractionMenu();
            }
            case 2 -> {
                System.out.println("You tried to flee but got caught, looks like you are gonna have to fight !");
                combatInteraction(enemy);
            }
        }
    }


}
