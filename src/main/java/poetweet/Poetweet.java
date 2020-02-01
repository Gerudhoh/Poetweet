package poetweet;

public class Poetweet {
    /**
     * This is the main.
     */
    public static void main (String args[]) {
        Menu mainMenu = new Menu();

        mainMenu.printWelcome();
        mainMenu.runProgram();

        /*while(mainMenu.getRunAgain() == true){
            mainMenu.setRunAgain(false);
            mainMenu.runMenu();
        }*/

    }

}
