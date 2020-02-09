package poetweet;

public class Poetweet {
    private MenuOptionsFactory _menuOptionsFactory;

    /**
     * This is the constructor.
     */
    public Poetweet() {
        _menuOptionsFactory = new MenuOptionsFactory();
    }

    /**
     * This is the main.
     * @param args All mains have this in Java.
     */
    public static void main(String[] args) {
        var poetweet = new Poetweet();
        poetweet.runProgram();
    }

    /**
     * Work-around for the dumb Java static main thingy.
     */
    public void runProgram() {
        var menuOptions = _menuOptionsFactory.createMenuOptions();
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
