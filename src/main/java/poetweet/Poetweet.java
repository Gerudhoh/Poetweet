package poetweet;

import poetweet.Exceptions.QuitException;

public class Poetweet extends Menu {
    private static final MenuOptionsFactory MENU_OPTIONS_FACTORY = new MenuOptionsFactory();

    /**
     * This is the constructor for the class that runs the program.
     */
    public Poetweet() {
        super(MENU_OPTIONS_FACTORY.createPoetweetMenuOptions());
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
        IReturnable userSelection;
        printWelcome();

        while (true) {
            try {
                userSelection = runMenu();
            } catch (QuitException qe) {
                break;
            }

            if (userSelection == null) {
                printErrorMessage();
            }
        }
    }

}
