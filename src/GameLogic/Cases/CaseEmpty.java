package GameLogic.Cases;

import Characters.Character;
import Enemies.Enemy;
import GameLogic.Cases.Case;
import GameLogic.Menu;

public class CaseEmpty implements Case {

    private Menu menu;

    public CaseEmpty(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void interaction(Character playerChar){
        System.out.println("Here is what the room look like, at some point this part will be randomly chosen from a list of 'Setting Description'");
        menu.afterInteractionMenu();
    }
}
