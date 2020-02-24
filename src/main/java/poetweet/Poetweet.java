package poetweet;

import java.util.ArrayList;

public class Poetweet extends Menu {
    private static final MenuOptionsFactory MENU_OPTIONS_FACTORY = new MenuOptionsFactory();
    private ArrayList<ReturnablePoem> _poems;

    /**
     * This is the constructor for the class that runs the program.
     */
    public Poetweet() {
        super(MENU_OPTIONS_FACTORY.createPoetweetMenuOptions());
        _poems = new ArrayList<>();
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
     * Main loop of the program, overriden to save poems.
     */
    @Override
    public void runProgram() {
        IReturnable returnedObject;
        printWelcome();
        var running = true;

        while (running) {
            try {
                returnedObject = runMenu();
            } catch (Exceptions.QuitException qe) {
                break;
            } catch (Exceptions.PoetweetIOException pioe) {
                System.out.println(pioe.getMessage());
                returnedObject = null;
            } catch (Exceptions.NotEnoughTweetsException nete) {
                System.out.println(nete.getMessage());
                returnedObject = null;
            }

            if (returnedObject == null) {
                printErrorMessage();
                continue;
            }

            if (returnedObject instanceof ReturnablePoem) {
                _poems.add((ReturnablePoem) returnedObject);
            }

            if (returnedObject instanceof IPoemUsingReturnable) {
                ((IPoemUsingReturnable) returnedObject).execute(_poems);
            }
        }
    }
}

