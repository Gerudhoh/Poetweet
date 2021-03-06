package poetweet;

public class QuitOption implements IMenuOption {
    /**
     * Gets the option instructions.
     * @return What the user needs to do to quit.
     */
    public String getOptionInstructions() {
        return "Do you want to quit the application? [yes/no]";
    }

    /**
     * Gets the error message in case the operation failed.
     * @return A general diagnosis of what went wrong.
     */
    public String getErrorMessage() {
        return "Unable to quit correctly. If you want to quit, select the option again and type \'yes\'";
    }

    /**
     * Describes the action undertaken by this menu option.
     * @return The description.
     */
    public String getOptionDescription() {
        return "Quit";
    }

    /**
     * The opposite of an error message, this lets the user know it did the thing.
     * @return The success notification.
     */
    public String getOptionResult() {
        return "Quit the program successfully.";
    }

    /**
     * Quits the program.
     * @param userInput User's response to if they really wanna quit.
     * @return A coded value about the command's success.
     */
    public MenuOptionResult runMenuOption(String userInput) {
        if (userInput.toLowerCase().equals("yes")) {
            throw new Exceptions.QuitException();
        }
        return MenuOptionResult.VALID_OPTION_FAILURE;
    }
}
