package GameLogic.Cases;

import Characters.Character;
import Enemies.Enemy;
import GameLogic.Menu;

public class CaseEnemy implements Case {

    private Menu menu;

    public CaseEnemy(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void interaction(Character playerChar) {
        Enemy enemy = new Enemy();
        System.out.println("You enter a new room and come face to face with a " + enemy.getEnemyName());
        menu.fleeOrFightMenu(enemy);
    }
}
