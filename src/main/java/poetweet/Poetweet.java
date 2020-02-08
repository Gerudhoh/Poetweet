package poetweet;

public class Poetweet {
    // TODO: Ask Judi if this is bad practice
    private static MenuOptionsFactory menuOptionsFactory = new MenuOptionsFactory();

    /**
     * This is the main.
     */
    public static void main (String args[]) {
        var menuOptions = menuOptionsFactory.CreateMenuOptions();
        var mainMenu = new Menu(menuOptions);

        /*SyllableCounter sc = new SyllableCounter();
        int myCount = sc.count("facility");
        System.out.println("count= " + myCount);*/

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
