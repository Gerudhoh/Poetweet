package poetweet;

import java.util.ArrayList;

public class Menu {
    private InputParser inputParser;
    //TODO: make this a hashmap<String, MenuOption>
    // where the string is the thing to do and the object that corresponds to it
    // And maybe I send in the objects to this class in an arrayList????
    private ArrayList<String> menuItems;
    //TODO: Get rid of this
    private TwitterScraper twitterScraper;

    public Menu(){
        inputParser = new InputParser();
        twitterScraper = new TwitterScraper();
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

    public MenuOptionResults runProgram(){
        printMenuItems();
        System.out.println("What would you like to do? (1-" + menuItems.size() + ")");

        var input = inputParser.getParsedInput();

        if(input == 1){
            System.out.println(twitterScraper.getOptionInstructions());
            var handle = inputParser.getInput();
            System.out.println("pulling tweets from " + handle);
            var result = twitterScraper.pullTweetsFromTwitterHandle(handle);
            System.out.println("Result = " + result);
            return MenuOptionResults.VALID_OPTION;
        }

        if(input == menuItems.size()){
            return MenuOptionResults.QUIT;
        }

        return MenuOptionResults.INVALID_OPTION;
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
