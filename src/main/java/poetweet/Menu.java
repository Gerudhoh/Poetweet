package poetweet;

import java.util.ArrayList;

public class Menu {
    private InputParser _inputParser;
    private ArrayList<IMenuOption> _menuItems;

    /**
     * Constructor for the menu.
     * @param menuItems The items on the menu.
     */
    public Menu(ArrayList<IMenuOption> menuItems) {
        _inputParser = new InputParser();
        _menuItems = menuItems;
    }

    /**
     * Prints the welcome message.
     */
    public void printWelcome() {
        System.out.println("Welcome to");
        System.out.println("   .-.                                                 ");
        System.out.println("  (_) )-.                /                         /   ");
        System.out.println("     /   \\  .-._. .-.---/---`)    (   .-.   .-.---/--- ");
        System.out.println("    /     )(   )./.-'_ /    /  .   )./.-'_./.-'_ /     ");
        System.out.println(" .-/  `--'  `-' (__.' /    (_.' `-' (__.' (__.' /      ");
        System.out.println("(_/                                                    ");
    }

    /**
     * Prints a clarification statement for the user.
     */
    public void printErrorMessage() {
        System.out.println("\nSorry, it seems like you didn't select a valid menu option.");
        System.out.println("Please select a number corresponding to an option from the list below:\n");
    }

    /**
     * Tell the user all it can do with this beautiful system.
     *
     * @return MenuOptions.VALID_OPTION or MenuOptions.INVALID_OPTION depending on the validity of
     *  the option selected by the user, or MenuOptions.QUIT if the user wants to quit the program
     */
    public MenuOptionResults runProgram() {
        printMenuItems();
        System.out.println("What would you like to do? (1-" + _menuItems.size() + ")");

        var input = _inputParser.getParsedInput();

        if (input > 0 && input <= _menuItems.size()) {
            var selectedOption = _menuItems.get((input - 1));
            return runMenuOption(selectedOption);
        }

        return MenuOptionResults.INVALID_OPTION;
    }

    /**
     * Runs the menu option that the user selected.
     *
     * @param option is the MenuOption object that the user selected
     * @return MenuOptions.VALID_OPTION_SUCCESS or MenuOptions.VALID_OPTION_FAILURE depending on whether
     * the menu option executed successfully
     */
    private MenuOptionResults runMenuOption(IMenuOption option) {
        System.out.println(option.getOptionInstructions());
        var input = _inputParser.getInput();
        var result = option.runMenuOption(input);

        if (result == MenuOptionResults.VALID_OPTION_FAILURE) {
            System.out.println(option.getErrorMessage());
        }

        return result;
    }

    /**
     * Prints the menu options- basically what can you do with the program.
     */
    private void printMenuItems() {
        int i = 1;
        for (var item : _menuItems) {
            System.out.println(i++ + ". " + item.getOptionDescription());
        }
    }
}
