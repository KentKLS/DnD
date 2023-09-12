public class Game {
    private Personnage personnage;
    private int playerPos = 1;
    private int tableLength = 64;

    public int getPlayerPos() {
        return this.playerPos;
    }

    public int diceRoll() {
        return (int) (Math.random() * 6 + 1);
    }

    public void gameTurn() {
        while (this.playerPos < this.tableLength) {
            System.out.println("\nDébut du tour:\n Vous etes sur la case " + playerPos + "/64");
            int dice = this.diceRoll();
            System.out.println("\n Valeur du Jet: "+dice+"\n");
            int playerPos = this.getPlayerPos();
            this.playerPos = playerPos + dice;

            if (this.playerPos < this.tableLength) {
                System.out.println("Fin du Tour: \n Vous etes sur la case " + this.playerPos + "/64");
            } else {
                System.out.println("Fin du Tour: \n Vous etes arrivé a la fin ! GG!");
                Menu menu = new Menu();
                menu.restart();
            }
        }
    }
}
