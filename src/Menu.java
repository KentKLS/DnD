import java.util.Scanner;

public class Menu {
    private Game game;
    public Menu(){
        game = new Game();
    }
    public void createChar(){
        boolean isInProgress = true;
        while (isInProgress) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quel type de personnage souhaitez vous créer ? \n Magicien ou Guerrier ?");
            String charType = scanner.nextLine();
            System.out.println("Choisissez le nom de votre Personnage ?");
            String charName = scanner.nextLine();
            Personnage newChar = new Personnage(charName, charType);
            System.out.println(newChar);
            System.out.println("Souhaitez vous modifier votre personnage ?");
            String choix = scanner.nextLine();
             if (choix.equals("non")) {
                isInProgress = false;
            } else if (!choix.equals("oui")) {
                System.out.println("répondez par oui ou non pls");
            }
        }
    }
    public void start(){
        boolean start = false;
        Scanner scanner = new Scanner(System.in);
        while (!start) {
            System.out.println("Type Start to start the game");
            String answer = scanner.nextLine();
            if (answer.equals("Start")){
                start = true;
                game.gameTurn();
            }
        }
    }
    public void restart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to restart the game ?");
        String answer = scanner.nextLine();
        if (answer.equals("yes")){
            game = new Game();
            createChar();
            start();
        }
    }
}
