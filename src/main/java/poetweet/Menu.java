package poetweet;

public class Menu {

    /**
     * Prints the welcome message
     */
    public void printWelcome(){
        System.out.println("Welcome to");
        System.out.println("   .-.                                                 ");
        System.out.println("  (_) )-.                /                         /   ");
        System.out.println("     /   \\  .-._. .-.---/---`)    (   .-.   .-.---/--- ");
        System.out.println("    /     )(   )./.-'_ /    /  .   )./.-'_./.-'_ /     ");
        System.out.println(" .-/  `--'  `-' (__.' /    (_.' `-' (__.' (__.' /      ");
        System.out.println("(_/                                                    ");
    }

    /**
     * Tell the user all it can do with this beautiful system
     *
     * @return true If the user quits the program, else returns false.
     */

    public boolean runProgram(){
        System.out.println("Welcome to Poetweet!");
        return true;
    }
}
