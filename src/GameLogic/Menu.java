package GameLogic;

import Enum.EnumType;
import Characters.Mage.Mage;
import Characters.Personnage;
import Characters.Warrior.Warrior;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import Enum.EnumTextColor;
public class Menu {

    public static final String ANSI_RED = "\u001B[31m";

    private final String[] defaultName = {"Daniel", "Damian", "Danny", "David", "Diego", "Dylan", "Derek", "Damien", "Dori"};
    private Game game;
    private final ArrayList<Mage> magesList;
    private final ArrayList<Warrior> warriorsList;
    private Scanner scn = new Scanner(System.in);

//    public void createDefaultWarrior() {
//        int rdm = (int) (Math.random() * defaultName.length) + 1;
//        String name = defaultName[rdm];
//
//        createCharMenu();
//    }

    public void createDefaultChar() {
        int rdm = (int) (Math.random() * defaultName.length);
        String name = defaultName[rdm];
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            Mage mage = new Mage("Default " + name);
            magesList.add(mage);
            System.out.println("\n Mage created with success \n ");
        } else {
            Warrior warrior = new Warrior("Default " + name);
            warriorsList.add(warrior);
            System.out.println("\n Warrior created with success \n ");
        }
        createCharMenu();
    }

    public void createWarrior() {
        String charName = getStringAnswer("Choose the name of your character:");
        Warrior warrior = new Warrior(charName);
        warriorsList.add(warrior);
        System.out.println("\n Warrior " + warrior.getName() + " created with success \n ");

        createCharMenu();
    }

    public void createMage() {
        String charName = getStringAnswer("Choose the name of your character:");
        Mage mage = new Mage(charName);
        magesList.add(mage);
        System.out.println("\n Mage " + mage.getName() + " created with success \n ");
        createCharMenu();
    }

    /**
     *
     */
    public Menu() {
        game = new Game();
        this.warriorsList = new ArrayList<>();
        this.magesList = new ArrayList<>();
    }

    public void mainMenu() {
        int answer = getIntAnswer(EnumTextColor.light_yellow +"Choose your next action wisely"+ EnumTextColor.reset  + EnumTextColor.light_white +"\n1.Create A new Character "+ EnumTextColor.reset+"\n 2.Display already created Characters\n 3.Start a new game \n 4.Exit the Game  ");
        switch (answer) {
            case 1 -> createCharMenu();
            case 2 -> displayCharsMenu();
            case 3 -> startMenu();
            case 4 -> System.out.println("Left the game");
            default -> {
                System.out.println("\n\n Please type 1 2 3 or 4 \n\n");
                mainMenu();
            }
        }
    }

    public void displayCharsMenu() {
        if (warriorsList.isEmpty() && magesList.isEmpty()) {
            System.out.println("\n Nothing to display, redirecting to main menu \n\n");
            mainMenu();

        } else {
            displayChars();
            int answer = getIntAnswer("Do you wish to: \n 1.Delete a character \n 2.Go back to main menu \n 3.Go back to character creation menu ");
            switch (answer) {
                case 1 -> deleteCharMenu();
                case 2 -> mainMenu();
                case 3 -> createCharMenu();
                default -> {
                    System.out.println("\n\nPlease type 1 or 2\n\n");
                    displayCharsMenu();
                }
            }
        }
    }

    public void displayChars() {
        System.out.println("All Warriors:");
        for (int i = 0; i < warriorsList.size(); i++) {
            Warrior war = warriorsList.get(i);
            System.out.printf("%s. %s%n", i, war.getName());
        }
        System.out.println("All Mages");
        for (int i = 0; i < magesList.size(); i++) {
            Mage mage = magesList.get(i);
            System.out.printf("%s. %s%n", i, mage.getName());
        }
    }

    public void deleteCharMenu() {
        int type = getIntAnswer("Is the character your wish to delete: \n 1.A mage \n 2.A Warrior");
        int index = getIntAnswer("Please enter the number of the character you wish to delete");
        switch (type) {
            case 1 -> {
                Mage charToDel = this.magesList.get(index);
                deleteChar(charToDel, index);
                createCharMenu();
            }
            case 2 -> {
                Warrior charToDel = this.warriorsList.get(index);
                deleteChar(charToDel, index);
                createCharMenu();
            }
            default -> {
                System.out.println("please type 1 or 2");
                deleteCharMenu();
            }
        }
    }

    public void deleteChar(Personnage character, int index) {
        int answer = getIntAnswer("Are you sure you wanna delete the character named " + character.getName() + "\n 1.Yes \n 2.No");
        if (answer == 1) {
            if (character.getType().equals(EnumType.mage)) {
                magesList.remove(index);
            } else if (character.getType().equals(EnumType.warrior)) {
                warriorsList.remove(index);
            }
        }

    }

    public void createCharMenu() {
        int answer = getIntAnswer("Do you wish to:\n 1.create a Default Character \n 2.Name your own Character \n 3.See list of already created characters \n 4.Go back to the main menu");
        switch (answer) {
            case 1 -> createDefaultChar();
            case 2 -> createChar();
            case 3 -> displayCharsMenu();
            case 4 -> mainMenu();
            default -> {
                System.out.println("\n\nPlease type 1 2 3 or 4\n\n");
                createCharMenu();
            }
        }
    }

//    public void mageOrWar() {
//        int answer = getIntAnswer("Do you wish to create: \n 1.A Mage \n 2.A Warrior \n 3.Cancel creation and go back to main menu");
//        switch (answer) {
//            case 1 -> createDefaultMage();
//            case 2 -> createDefaultWarrior();
//            case 3 -> mainMenu();
//            default -> {
//                System.out.println("\n\nPlease type 1 2  or 3\n\n");
//                mageOrWar();
//            }
//        }
//    }

    /**
     *
     */
    public void createChar() {
        int type = getIntAnswer("Do you wish to create: \n 1.A Mage \n 2.A Warrior \n 3.Go back to the main menu");
        switch (type) {
            case 1 -> createMage();
            case 2 -> createWarrior();
            case 3 -> mainMenu();
            default -> {
                System.out.println("\n\nPlease type 1 2  or 3\n\n");
                createChar();
            }
        }
    }


    public void startMenu() {
        if (this.warriorsList.isEmpty() && this.magesList.isEmpty()) {
            System.out.println("\nYou don't have any character created yet, redirecting you to character creation menu..\n\n");
            createChar();
        }
        int answer = getIntAnswer("Hello Adventurer, I'm Godrick and i will be your DungeonMaster today \n first i want to make sure, are you ready ? \n from this point onward you won't be able to modify the character you choose so beware \n 1.Yes sir, i'm ready for the Adventure \n 2.No, i need more time to get ready, be right back !");
        switch (answer) {
            case 1 -> confirmedStart();
            case 2 -> mainMenu();
            default -> {
                System.out.println("\n\n Please type 1 or 2 \n\n");
                startMenu();
            }
        }
    }

    public void confirmedStart() {
        int answer = getIntAnswer("We are about to start our Journey, but first you have to pick your character, or would you rather have me do it ? \n 1.Choose a character \n 2.Let the DM choose your character");
        switch (answer) {
            case 1 -> {
                Personnage playerChar = typeSelectMenu();
                System.out.println("Hmm, so you selected "+ playerChar.getName()+"...meh");
                charConfirmationMenu(playerChar);
            }
            case 2 -> {
                Personnage playerChar = randomTypeSelect();
                System.out.println("Hmm, so for you i selected " + playerChar.getName());
                charConfirmationMenu(playerChar);
            }
            default -> {
                System.out.println("\n\n Please type 1 or 2 \n\n");
                confirmedStart();
            }
        }
    }
    public void charConfirmationMenu(Personnage playerChar){
        int answer = getIntAnswer("\n Do you wish to: \n1.Choose an other character \n2.See the character sheet of the character you chose \n 3.GODDAMN START THE MOTHERFUCKING ADVENTURE ALREADY");
    switch (answer){
        case 1 -> confirmedStart();
        case 2 -> {
            playerChar.getDetails();
            String buffer = getStringAnswer("Do");
        }
        case 3 -> {}
        default -> {
            System.out.println("please choose 1 2 or 3");
         charConfirmationMenu(playerChar);
        }
    }
    }

    public Personnage typeSelectMenu() {
        if (this.warriorsList.isEmpty()) {

            System.out.println("You only have Mages created, you will have to chose a Mage\n");
            return selectMage();
        } else if (this.magesList.isEmpty()) {

            System.out.println("You only have Warriors created, you will have to chose a Warrior\n");
            return selectWarrior();
        } else {
            int answer = getIntAnswer("You have both Warriors and Mages already created, which class do you wish to pick from: \n 1.Mages \n 2.Warriors");
            switch (answer) {
                case 1 -> {
                    return selectWarrior();
                }
                case 2 -> {
                    return selectMage();
                }
                default -> {
                    System.out.println("\n\n Please type 1 or 2 \n\n");
                    return typeSelectMenu();
                }
            }
        }
    }

    public Warrior selectWarrior() {
        for (int i = 0; i < warriorsList.size(); i++) {
            System.out.printf("%s. %s%n", i, warriorsList.get(i));
        }
        int index = getIntAnswer("Choose your pick in the list above, and write the number of the character you chose below");
        return warriorsList.get(index);
    }

    public Mage selectMage() {
        for (int i = 0; i < magesList.size(); i++) {
            System.out.printf("%s. %s%n", i, magesList.get(i));
        }
        int index = getIntAnswer("Choose your pick in the list above, and write the number of the character you chose below");
        return magesList.get(index);

    }

    public Personnage randomTypeSelect() {
        int type = (int) (Math.random() * 2) + 1;
        switch (type) {
            case 1 -> {
                Mage mage = randomMageSelect();
                return mage;
            }
            case 2 -> {
                Warrior war = randomWarSelect();
                return war ;
            }
            default -> {
                System.out.println("pleaseSelect a proper answer (1 or 2)");
                return randomTypeSelect();
            }
        }
    }

    public Mage randomMageSelect() {
        int choice = (int) (Math.random() * magesList.size());
        System.out.println(this.magesList.get(choice));
        return this.magesList.get(choice);
    }

    public Warrior randomWarSelect() {
        int choice = (int) (Math.random() * warriorsList.size());
        return this.warriorsList.get(choice);
    }


    public void start() {
        boolean start = false;
        while (!start) {
            String answer = getStringAnswer("Type Start to start the game");
            if (answer.equals("Start")) {
                start = true;
                game.gameTurn();
            }
        }
    }


    public String getStringAnswer(String question) {
        System.out.println(question);
        scn = new Scanner(System.in);
        return scn.nextLine();
    }


    public int getIntAnswer(String question) {
        System.out.println(question);
        return scn.nextInt();
    }


    /**
     *
     */
    public void restartChoice() {
        int answer = getIntAnswer("Would you like to: \n 1.Go back to main menu \n 2.Go back to the start of your adventure \n 3.Quit the game");
        switch (answer) {
            case 1 -> mainMenu();
            case 2 -> startMenu();
            case 3 -> {
            }
            default -> {
                System.out.println("\n\nPlease type 1 2 or 3 \n\n");
                restartChoice();
            }
        }

    }
}
