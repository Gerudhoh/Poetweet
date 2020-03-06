package poetweet;

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
}

