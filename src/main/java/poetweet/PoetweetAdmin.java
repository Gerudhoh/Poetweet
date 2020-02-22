package poetweet;

public class PoetweetAdmin extends Menu {
    private static final MenuOptionsFactory MENU_OPTIONS_FACTORY = new MenuOptionsFactory();

    /**
     * This is the constructor for the class that runs the program.
     */
    public PoetweetAdmin() {
        super(MENU_OPTIONS_FACTORY.createPoetweetAdminMenuOptions());
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
        IReturnable userSelection;
        printWelcome();

        while (true) {
            try {
                userSelection = runMenu();
            } catch (Exceptions.QuitException qe) {
                 break;
            }

            if (userSelection == null) {
                printErrorMessage();
            }
        }
    }
}
