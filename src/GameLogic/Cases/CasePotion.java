package GameLogic.Cases;

import Characters.Character;
import Enemies.Enemy;
import Equipements.Potions.Potion;
import GameLogic.Menu;

public class CasePotion implements Case{
    private Menu menu;

    public CasePotion(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void interaction(Character playerChar){
        Potion potion = new Potion();
        System.out.println("You enter what seems to be an alchemist den, on the table in front of you there is "+potion.getEquipementDesc());
        menu.potionInteractionMenu(potion);
    }
}
