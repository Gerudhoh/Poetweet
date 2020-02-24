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
}
