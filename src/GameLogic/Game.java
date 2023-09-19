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
    private final String BLUECHAR = EnumText.blue.getColorValue();
    private int playerPos = 1;
    private int turnPlayed;
    private int tableLength;
    public Character playerCharacter;

    private ArrayList<Case> gameBoard;

    public void populateGameBoard() {
        this.gameBoard.add(new CaseEmpty());
        this.gameBoard.add(new CaseEnemy(this.menu));
        this.gameBoard.add(new CaseEquipment(this.menu));
        this.gameBoard.add(new CasePotion(this.menu));
    }

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

public int diceRoll(){
        return 1;
}

    public int coinFlip() {
        return (int) (Math.random() * 2 + 1);
    }


    public Game(Character playerChar) {
        this.playerCharacter = playerChar;
        this.gameBoard = new ArrayList<>();
        this.menu = new Menu();
    }

    public void setSpecificTableLength() {
        this.tableLength = gameBoard.size();
    }

    public void gameTurn() throws CharOutOfBoundException {
        int dice = this.diceRoll();
        System.out.println(BLUECHAR + "Dice throw value: " + dice);
        this.playerPos = playerPos + dice;
        if (playerPos > tableLength) {
            throw new CharOutOfBoundException("Character went out of bound");
        }
        gameBoard.get(playerPos).interaction(playerCharacter);
        turnPlayed++;
    }

    public void combatInteraction(Enemy enemy) {
        while (enemy.getHP() > 0 || playerCharacter.getHp() > 0) {
            int playerAP = playerCharacter.getAp() + playerCharacter.getEquipementOffensif().getAttlvl();
            enemy.loseHP(playerAP);
            System.out.println(playerCharacter.getName() + "hit " + enemy.getEnemyName() + "dealing " + playerAP + "damage");
            if (enemy.getHP() <= 0) {
                System.out.println("The ennemy is dead congratulations !");
                menu.lootInteractionMenu(enemy.getLoot());
            } else {
                playerCharacter.loseHP(enemy.getEnemyAP());
                System.out.println(enemy.getEnemyName() + "hit " + playerCharacter.getName() + "dealing " + playerAP + "damage");
                checkDeath();

            }
        }
    }

    public void checkDeath() {
        if (playerCharacter.getHp() <= 0) {
            System.out.println("\nYou died, RIP " + playerCharacter.getName());
            menu.restartChoice();
        }
    }

    public void switchEquipment(Equipment equipment) {
        if (equipment.getEquipementType().equals("offense")) {
            System.out.println("You successfully exchanged " + playerCharacter.getEquipementOffensif().getEquipementName() + " for " + equipment.getEquipementName());
            playerCharacter.setEquipementOffensif(equipment);
        } else {
            System.out.println("You successfully exchanged " + playerCharacter.getEquipementDefensif().getEquipementName() + " for " + equipment.getEquipementName());
            playerCharacter.setEquipementDefensif(equipment);
        }
    }

    public void drinkPot(Equipment potion) {
        if (potion.getEquipementName().equals(EnumPotions.DEFENSE.getName())) {
            System.out.println("You feel protected");
            playerCharacter.gainDef(EnumPotions.DEFENSE.getValue());
        } else if (potion.getEquipementName().equals(EnumPotions.HEALTH.getName())) {
            System.out.println("You gain some Health Point back ");
            playerCharacter.gainHP(EnumPotions.HEALTH.getValue());
        } else if (potion.getEquipementName().equals(EnumPotions.RAGE.getName())) {
            if (playerCharacter.getType().equals(EnumType.warrior)) {
                playerCharacter.gainAP(EnumPotions.RAGE.getValue());
                System.out.println("You feel like you have gained power");
            } else {
                System.out.println("Nothing Happened");
            }
        } else if (potion.getEquipementName().equals(EnumPotions.POWER.getName())) {
            if (playerCharacter.getType().equals(EnumType.mage)) {
                playerCharacter.gainAP(EnumPotions.POWER.getValue());
                System.out.println("You feel like you have gained power");
            } else {
                System.out.println("Nothing Happened");
            }
        } else if (potion.getEquipementName().equals(EnumPotions.POISON.getName())) {
            System.out.println("It's disgusting, you feel nauseous and end up vomiting blood");
            playerCharacter.loseHP(EnumPotions.POISON.getValue());
            checkDeath();
        }

    }

    public void tryToFlee(Enemy enemy) {
        int rdm = (int) (Math.random() * 3);
        switch (rdm) {
            case 0 -> {
                System.out.println("You managed to flee unscathed");
                menu.gameDiceThrowMenu();
            }
            case 1 -> {
                int random = (int) (Math.random() * 9) + 1;
                playerCharacter.loseHP(random);
                System.out.println("You manage to flee but the enemy manage to hit you on your way out \n You lost " + random + "HP");
                checkDeath();
                menu.gameDiceThrowMenu();
            }
            case 2 -> {
                combatInteraction(enemy);
            }
        }
    }

    public void charConfirmation(){

    }

}
