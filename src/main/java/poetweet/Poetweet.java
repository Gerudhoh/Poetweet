package poetweet;

public class Poetweet {
    private static MenuOptionsFactory menuOptionsFactory = new MenuOptionsFactory();

    /**
     * This is the main.
     */
    public static void main (String args[]) {
        var menuOptions = menuOptionsFactory.CreateMenuOptions();
        var mainMenu = new Menu(menuOptions);

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
