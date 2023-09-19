package GameLogic;

import Enemies.Enemy;
import Enum.EnumType;
import Characters.Mage.Mage;
import Characters.Character;
import Characters.Warrior.Warrior;

import java.util.ArrayList;
import java.util.Scanner;

import Enum.EnumText;
import Equipements.Equipment;
import Equipements.Potions.Potion;
import Exceptions.CharOutOfBoundException;

public class Menu {

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
    private Game game;
    public Menu() {
        this.warriorsList = new ArrayList<>();
        this.magesList = new ArrayList<>();

    }

    private final String[] defaultName = {"Daniel", "Damian", "Danny", "David", "Diego", "Dylan", "Derek", "Damien", "Dori", "Daniela", "DeAndre", "Doris", "Devonte", "Dave"};
    private final ArrayList<Mage> magesList;
    private final ArrayList<Warrior> warriorsList;
    private Scanner scn = new Scanner(System.in);



    public void createDefaultChar() {
        int rdm = (int) (Math.random() * defaultName.length);
        String name = defaultName[rdm];
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            Mage mage = new Mage("Default " + name);
            magesList.add(mage);
            System.out.println(CYANCHAR + "\n Mage " + LIGHTGREENCHAR + "created with success \n " + RESETCHARMODS);
        } else {
            Warrior warrior = new Warrior("Default " + name);
            warriorsList.add(warrior);
            System.out.println(YELLOWCHAR + "\n Warrior " + LIGHTGREENCHAR + "created with success \n " + RESETCHARMODS);
        }
        CharCreationMenu();
    }

    public void createWarrior() {
        String charName = getStringAnswer(YTCHAR + "Choose the name of your character:");
        Warrior warrior = new Warrior(charName);
        warriorsList.add(warrior);
        System.out.println(YELLOWCHAR + "\n Warrior " + LIGHTPURPLECHAR + warrior.getName() + LIGHTGREENCHAR + " created with success \n " + RESETCHARMODS);
        CharCreationMenu();
    }

    public void createMage() {
        String charName = getStringAnswer(YTCHAR + "Choose the name of your character:");
        Mage mage = new Mage(charName);
        magesList.add(mage);
        System.out.println(CYANCHAR + "\n Mage " + LIGHTPURPLECHAR + mage.getName() + LIGHTGREENCHAR + " created with success \n " + RESETCHARMODS);
        CharCreationMenu();
    }

    /**
     *
     */


    public void mainMenu() {
        int answer = getIntAnswer(LIGHTYELLOWCHAR + "Choose your next action wisely" + YTCHAR + "\n 1.Create A new Character \n 2.Display already created Characters\n 3.Start a new game " + RESETCHARMODS + "\n 4.Exit the Game  ");
        switch (answer) {
            case 1 -> CharCreationMenu();
            case 2 -> displayCharsMenu();
            case 3 -> startMenu();
            case 4 -> System.out.println("Left the game");
            default -> {
                System.out.println(REDCHAR + "\n\n Please type 1 2 3 or 4 \n\n" + RESETCHARMODS);
                mainMenu();
            }
        }
    }

    public void displayCharsMenu() {
        if (warriorsList.isEmpty() && magesList.isEmpty()) {
            System.out.println(REDCHAR + "\n Nothing to display, redirecting to main menu \n\n" + RESETCHARMODS);
            mainMenu();

        } else {
            displayChars();
            int answer = getIntAnswer(YTCHAR + "Do you wish to: \n 1.Delete a character " + RESETCHARMODS + "\n 2.Go back to main menu \n 3.Go back to character creation menu ");
            switch (answer) {
                case 1 -> charDeletionMenu();
                case 2 -> mainMenu();
                case 3 -> CharCreationMenu();
                default -> {
                    System.out.println(REDCHAR + "\n\nPlease type 1 or 2\n\n" + RESETCHARMODS);
                    displayCharsMenu();
                }
            }
        }
    }

    public void displayChars() {
        if (!warriorsList.isEmpty()) {
            System.out.println(YTCHAR + "All Warriors:");
            for (int i = 0; i < warriorsList.size(); i++) {
                Warrior war = warriorsList.get(i);
                System.out.printf("%s %s. %s%s%s%n", YELLOWCHAR, i, LIGHTPURPLECHAR, war.getName(), RESETCHARMODS);
            }
        }
        if (!magesList.isEmpty()) {
            System.out.println(YTCHAR + "All Mages:");
            for (int i = 0; i < magesList.size(); i++) {
                Mage mage = magesList.get(i);
                System.out.printf("%s %s. %s%s%s%n", CYANCHAR, i, LIGHTPURPLECHAR, mage.getName(), RESETCHARMODS);
            }
        }
    }

    public void charDeletionMenu() {
        displayChars();
        if (!warriorsList.isEmpty() && !magesList.isEmpty()) {
            int type = getIntAnswer(YTCHAR + "Is the character your wish to delete: " + CYANCHAR + "\n 1.A mage " + YELLOWCHAR + "\n 2.A Warrior");
            switch (type) {
                case 1 -> delIndexMage();
                case 2 -> delIndexWarrior();
                default -> {
                    System.out.println(REDCHAR + "please type 1 or 2");
                    charDeletionMenu();
                }
            }
        } else if (warriorsList.isEmpty() && !magesList.isEmpty()) {
            delIndexMage();
        } else if (!warriorsList.isEmpty() && magesList.isEmpty()) {
            delIndexWarrior();
        }
    }

    private void delIndexMage() {
        int index = getIntAnswer(YTCHAR + "Please enter the number of the character you wish to delete");
        if (index < 0 || index > magesList.size() - 1) {
            System.out.println(REDCHAR + "\n You entered an invalid number please try again\n");
            charDeletionMenu();
        }
        Mage charToDel = this.magesList.get(index);
        deleteChar(charToDel, index);
        CharCreationMenu();
    }

    private void delIndexWarrior() {
        int index = getIntAnswer(YTCHAR + "Please enter the number of the character you wish to delete");
        if (index < 0 || index > warriorsList.size() - 1) {
            System.out.println(REDCHAR + "\n You entered an invalid number please try again\n");
            charDeletionMenu();
        }
        Warrior charToDel = this.warriorsList.get(index);
        deleteChar(charToDel, index);
        CharCreationMenu();
    }

    public void deleteChar(Character character, int index) {
        int answer = getIntAnswer(YTCHAR + "Are you sure you wanna delete the character named " + LIGHTPURPLECHAR + character.getName() + LIGHTGREENCHAR + "\n 1.Yes" + LIGHTREDCHAR + " \n 2.No" + RESETCHARMODS);
        switch (answer) {
            case 1 -> {
                if (character.getType().equals(EnumType.mage)) {
                    magesList.remove(index);
                } else if (character.getType().equals(EnumType.warrior)) {
                    warriorsList.remove(index);
                }
                System.out.println(LIGHTGREENCHAR + "Character " + LIGHTPURPLECHAR + character.getName() + LIGHTGREENCHAR + " has been succesfully deleted \n Redirecting to character creation menu");
                CharCreationMenu();
            }
            case 2 -> {
                System.out.println("Redirecting to character creation menu");
                CharCreationMenu();
            }
            default -> {
                System.out.println(REDCHAR + "\n\nPlease type 1 or 2\n\n" + RESETCHARMODS);
                deleteChar(character, index);
            }
        }
    }

    public void CharCreationMenu() {
        int answer = getIntAnswer(YTCHAR + "Do you wish to:\n 1.Create a Default Character \n 2.Name your own Character \n 3.See list of already created characters \n" + RESETCHARMODS + " 4.Go back to the main menu");
        switch (answer) {
            case 1 -> createDefaultChar();
            case 2 -> createChar();
            case 3 -> displayCharsMenu();
            case 4 -> mainMenu();
            default -> {
                System.out.println(REDCHAR + "\n\nPlease type 1 2 3 or 4\n\n" + RESETCHARMODS);
                CharCreationMenu();
            }
        }
    }

    public void createChar() {
        int type = getIntAnswer(YTCHAR + "Do you wish to create: " + CYANCHAR + "\n 1.A Mage " + YELLOWCHAR + " \n 2.A Warrior" + RESETCHARMODS + " \n 3.Go back to the character creation menu\n 4.Go back to main menu");
        switch (type) {
            case 1 -> createMage();
            case 2 -> createWarrior();
            case 3 -> displayCharsMenu();
            case 4 -> mainMenu();
            default -> {
                System.out.println(REDCHAR + "\n\nPlease type 1 2 3 or 4\n\n" + RESETCHARMODS);
                createChar();
            }
        }
    }


    public void startMenu() {
        if (this.warriorsList.isEmpty() && this.magesList.isEmpty()) {
            System.out.println(LIGHTYELLOWCHAR + "\nYou don't have any character created yet, redirecting you to character creation menu..\n\n");
            CharCreationMenu();
        }
        int answer = getIntAnswer(LIGHTYELLOWCHAR + "Hello Adventurer, I'm " + LIGHTPURPLECHAR + " Godrick " + LIGHTYELLOWCHAR + " and i will be your DungeonMaster today \n first i want to make sure, are you ready ? \n from this point onward you won't be able to modify the character you choose so beware " + YTCHAR + "\n 1.Yes sir, i'm ready for the Adventure \n 2.No, i need more time to get ready, be right back !");
        switch (answer) {
            case 1 -> confirmedStart();
            case 2 -> mainMenu();
            default -> {
                System.out.println(REDCHAR + "\n\n Please type 1 or 2 \n\n" + RESETCHARMODS);
                startMenu();
            }
        }
    }

    public void confirmedStart() {
        int answer = getIntAnswer(LIGHTYELLOWCHAR + "We are about to start our Journey, but first you have to pick your character, or would you rather have me do it ? " + YTCHAR + " \n 1.Choose a character \n 2.Let the DM choose your character");
        switch (answer) {
            case 1 -> {
                Character playerChar = typeSelectMenu();
                System.out.println(LIGHTYELLOWCHAR + "Hmm, so you selected " + playerChar.getName() + "...meh");
                charConfirmationMenu(playerChar);
            }
            case 2 -> {
                Character playerChar = randomTypeSelect();
                System.out.println(LIGHTYELLOWCHAR + "Hmm, so for you i selected " + playerChar.getName());
                charConfirmationMenu(playerChar);
            }
            default -> {
                System.out.println(LIGHTREDCHAR + "\n\n Please type 1 or 2 \n\n" + RESETCHARMODS);
                confirmedStart();
            }
        }
    }

    public void charConfirmationMenu(Character playerChar) {
        int answer = getIntAnswer(YTCHAR + "\n Do you wish to: \n1.Choose an other character \n2.See the character sheet of the character you chose \n" + BOLDCHAR + LIGHTREDCHAR + " 3.GODDAMN START THE MOTH*RFU**ING ADVENTURE ALREADY" + RESETCHARMODS);
        switch (answer) {
            case 1 -> confirmedStart();
            case 2 -> {
                System.out.println(playerChar.getDetails());
                getStringAnswer("Press enter to go back to the last menu");
                charConfirmationMenu(playerChar);
            }
            case 3 -> {
                game = new Game(playerChar);
                game.populateGameBoard();
                game.setSpecificTableLength();
                gameDiceThrowMenu();
            }
            default -> {
                System.out.println(EnumText.red + "Please choose 1 2 or 3");
                charConfirmationMenu(playerChar);
            }
        }
    }

    public Character typeSelectMenu() {
        if (this.warriorsList.isEmpty()) {
            System.out.println(YTCHAR + "You only have Mages created, you will have to chose a Mage\n");
            return selectMage();
        } else if (this.magesList.isEmpty()) {

            System.out.println(YTCHAR + "You only have Warriors created, you will have to chose a Warrior\n");
            return selectWarrior();
        } else {
            int answer = getIntAnswer(YTCHAR + "You have both Warriors and Mages already created, which class do you wish to pick from: \n 1.Mages \n 2.Warriors");
            switch (answer) {
                case 1 -> {
                    return selectWarrior();
                }
                case 2 -> {
                    return selectMage();
                }
                default -> {
                    System.out.println(REDCHAR + "\n\n Please type 1 or 2 \n\n" + RESETCHARMODS);
                    return typeSelectMenu();
                }
            }
        }
    }

    public Warrior selectWarrior() {
        for (int i = 0; i < warriorsList.size(); i++) {
            System.out.printf("%s. %s%n", i, warriorsList.get(i));
        }
        int index = getIntAnswer(YTCHAR + "Choose your pick in the list above, and write the number of the character you chose below");
        if (index < 0 || index > warriorsList.size()) {
            System.out.println(LIGHTREDCHAR + "\nYou chose a wrong number, please pick one of the number in the list given\n");
            typeSelectMenu();
        }
        return warriorsList.get(index);
    }

    public Mage selectMage() {
        for (int i = 0; i < magesList.size(); i++) {
            System.out.printf("%s. %s%n", i, magesList.get(i));
        }
        int index = getIntAnswer(YTCHAR + "Choose your pick in the list above, and write the number of the character you chose below");
        if (index < 0 || index > magesList.size()) {
            System.out.println(LIGHTREDCHAR + "\nYou chose a wrong number, please pick one of the number in the list given\n");
            typeSelectMenu();
        }
        return magesList.get(index);

    }

    public Character randomTypeSelect() {
        if (magesList.isEmpty()) {
            return randomWarSelect();
        } else if (warriorsList.isEmpty()) {
            return randomMageSelect();
        } else {
            int type = (int) (Math.random() * 2) + 1;
            switch (type) {
                case 1 -> {
                    return randomMageSelect();
                }
                case 2 -> {
                    return randomWarSelect();
                }
                default -> {
                    System.out.println(REDCHAR + "Please select a proper answer (1 or 2)" + RESETCHARMODS);
                    return randomTypeSelect();
                }
            }
        }
    }

    public Mage randomMageSelect() {
        int choice = (int) (Math.random() * magesList.size());
        return this.magesList.get(choice);
    }

    public Warrior randomWarSelect() {
        int choice = (int) (Math.random() * warriorsList.size());
        return this.warriorsList.get(choice);
    }

    public String getStringAnswer(String question) {
        System.out.println(question);
        scn = new Scanner(System.in);
        return scn.nextLine();
    }


    public int getIntAnswer(String question) {
        System.out.println(question);
        try {
            int r = scn.nextInt();
            scn.nextLine();
            return r;
        } catch (Exception e) {
            System.out.println(LIGHTREDCHAR + "\nThat's not a number, you dumdum!\n");
            scn.nextLine();
            return getIntAnswer(question);
        }
    }

    public void gameDiceThrowMenu() {
        System.out.println(YTCHAR + "\n\nNumber of turn played " + game.getTurnPlayed());
        System.out.println("You are currently on case " + game.getPlayerPos());
        getStringAnswer(LIGHTYELLOWCHAR + "\nPress enter to throw the dice and move forward");
        try {
            game.gameTurn();
            gameDiceThrowMenu();
        } catch (CharOutOfBoundException e) {
            System.out.println("Congrats you won");
            restartChoice();
        }
    }

    public void fleeOrFightMenu(Enemy enemy) {
        int answer = getIntAnswer(YELLOWCHAR + "\n What do you wanna do ? \n 1.Try to flee \n 2. Fight !");
        switch (answer) {
            case 1 -> game.tryToFlee(enemy);
            case 2 -> game.combatInteraction(enemy);
            default -> {
                System.out.println("Please type 1 or 2");
                fleeOrFightMenu(enemy);
            }
        }

    }

    public void lootInteractionMenu(Equipment equipment) {
        System.out.println(YELLOWCHAR + "After dying the ennemy vanished in a cloud of smoke leaving behind " + equipment.getEquipementDesc());
        if (equipment.getEquipementType().equals("potion")) {
            potionInteractionMenu(equipment);
        } else {
            equipmentInteractionMenu(equipment);
        }
    }

    public void equipmentInteractionMenu(Equipment equipment) {
        int answer = getIntAnswer("\n What would you like to do with it ? \n 1.Exchange it with my own equipment (Careful you can't go back on your choice) \n 2.Leave it here");
        switch (answer) {
            case 1 -> game.switchEquipment(equipment);
            case 2 -> gameDiceThrowMenu();
            default -> {
                System.out.println("Please type 1 or 2");
                equipmentInteractionMenu(equipment);
            }
        }
    }

    public void potionInteractionMenu(Equipment potion) {
        int answer = getIntAnswer("\n What would you like to do with it ? \n 1.Drink it \n 2.Leave it here");
        switch (answer) {
            case 1 -> game.drinkPot(potion);

            case 2 -> gameDiceThrowMenu();

            default -> {
                System.out.println("Please type 1 or 2");
                potionInteractionMenu(potion);
            }
        }
    }

    public void restartChoice() {
        int answer = getIntAnswer(YTCHAR + "\nWould you like to: \n 1.Go back to main menu \n 2.Go back to the start of your adventure \n 3.Quit the game");
        switch (answer) {
            case 1 -> mainMenu();
            case 2 -> startMenu();
            case 3 -> {
            }
            default -> {
                System.out.println(REDCHAR + "\n\nPlease type 1 2 or 3 \n\n" + RESETCHARMODS);
                restartChoice();
            }
        }
    }
}
