import GameLogic.Menu;
import Enum.EnumTextColor;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Instancie un objet GameLogic.Menu
        Menu menu = new Menu();
        System.out.println(EnumTextColor.red + "WELCOME TO THE WORLD OF DUNGEONS AND DRAGONS" + EnumTextColor.reset);
        menu.mainMenu();
    }
}
