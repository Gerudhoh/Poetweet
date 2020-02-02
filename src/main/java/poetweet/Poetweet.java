package poetweet;

public class Poetweet {
    /**
     * This is the main.
     */
    public static void main (String args[]) {
        Menu mainMenu = new Menu();

        mainMenu.printWelcome();

        var userSelection = MenuOptionResults.START;
        while(userSelection != MenuOptionResults.QUIT){
            userSelection = mainMenu.runProgram();

            if(userSelection == MenuOptionResults.INVALID_OPTION){
                mainMenu.printErrorMessage();
            }
        }

    }

}
