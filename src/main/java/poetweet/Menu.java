package poetweet;

import java.util.ArrayList;

public class Menu {
    private InputParser inputParser;
    // Ideally this would be a hashmap<String, Function>
    // where the string is the thing to do and the function is the things that does it
    private ArrayList<String> menuItems;

    public Menu(){
        inputParser = new InputParser();
        menuItems = new ArrayList<>(){{
            add("Input a Twitter Handle to Pull their Tweets");

            // Keep this at the bottom
            add("Quit");
        }};
    }

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
     * Prints a clarification statement for the user
     */
    public void printErrorMessage(){
        System.out.println("\nSorry, it seems like you didn't select a valid menu option.");
        System.out.println("Please select a number corresponding to an option from the list below:\n");
    }

    /**
     * Tell the user all it can do with this beautiful system
     *
     * @return MenuOptions.VALID_OPTION or MenuOptions.INVALID_OPTION depending on the validity of the option selected by the user
     *  or MenuOptions.QUIT if the user wants to quit the program
     */

    public MenuOptions runProgram(){
        printMenuItems();
        System.out.println("What would you like to do? (1-" + menuItems.size() + ")");

        var input = inputParser.getParsedInput();

        if(input == menuItems.size()){
            return MenuOptions.QUIT;
        }

        return MenuOptions.INVALID_OPTION;
    }

    /**
     * Prints the menu options- basically what can you do with the program
     */
    private void printMenuItems(){
        int i = 1;
        for (var item : menuItems) {
            System.out.println(i++ + ". " + item);
        }
    }
}
