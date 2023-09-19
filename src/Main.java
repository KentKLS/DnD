import GameLogic.Game;
import GameLogic.Menu;
import Enum.EnumText;
import Art.ASCIIArt;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /**
     * @param args
     */
    public static ASCIIArt art = new ASCIIArt();
    public static void main(String[] args) {
        // Instancie un objet GameLogic.Menu
        Menu menu = new Menu();
        System.out.println(EnumText.black_bcg.getColorValue()+ art.logo +EnumText.reset.getColorValue());
        System.out.println(EnumText.light_white.getColorValue() + EnumText.bold.getColorValue() + "WELCOME TO THE WORLD OF "+EnumText.light_green.getColorValue()+" DUNGEONS"+EnumText.light_white.getColorValue()+" AND"+EnumText.red.getColorValue() +" DRAGONS"+ EnumText.reset.getColorValue());
        menu.mainMenu();
    }

}
