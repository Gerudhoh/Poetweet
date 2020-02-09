package poetweet;

public class PoetweetAdmin {
    private MenuOptionsFactory _menuOptionsFactory;

    /**
     * This is the constructor for the class that runs the program.
     */
    public PoetweetAdmin() {
        _menuOptionsFactory = new MenuOptionsFactory();
    }

    /**
     * This is the main.
     * @param args All mains have this in Java.
     */
    public static void main(String[] args) {
        var poetweetAdmin = new PoetweetAdmin();
        poetweetAdmin.runProgram();
    }

    /**
     * Work-around for the dumb Java static main thingy.
     */
    public void runProgram() {
        var menuOptions = _menuOptionsFactory.createPoetweetAdminMenuOptions();
        var mainMenu = new Menu(menuOptions);

        mainMenu.printWelcome();

        var userSelection = MenuOptionResults.START;
        while (userSelection != MenuOptionResults.QUIT) {
            userSelection = mainMenu.runProgram();

            if (userSelection == MenuOptionResults.INVALID_OPTION) {
                mainMenu.printErrorMessage();
            }
        }
    }
}
