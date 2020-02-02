package poetweet;

public class Poetweet {
    /**
     * This is the main.
     */
    public static void main (String args[]) {
        Menu mainMenu = new Menu();

        mainMenu.printWelcome();

        var userSelection = MenuOptions.START;
        while(userSelection != MenuOptions.QUIT){
            userSelection = mainMenu.runProgram();

            if(userSelection == MenuOptions.INVALID_OPTION){
                mainMenu.printErrorMessage();
            }
        }

    }

}
