package poetweet;

public class AdminActivitiesOption implements IMenuOption {

    /**
     * Gets the option instructions.
     * @return Prompt for user consent
     */
    public String getOptionInstructions() {
        return "Do you want to perform admin activities? (yes/no)";
    }

    /**
     * Gets the error message in case the operation failed.
     * @return A general diagnosis of what went wrong.
     */
    public String getErrorMessage() {
        return "Yikes sis!";
    }

    /**
     * Describes the action undertaken by this menu option (For printing the menu).
     * @return A short description of the menu option
     */
    public String getOptionDescription() {
        return "Perform Admin Activities";
    }

    /**
     * The success message of the option.
     * @return The string that the option produced after execution.
     */
    public String getOptionResult() {
        return "Cleared up all the resource files!";
    }

    /**
     * Executes the admin user option.
     * @param userInput whatever information the user provided the system
     * @return A coded value about the command's success.
     */
    public MenuOptionResults runMenuOption(String userInput) {
        // TODO: Call a method on another class that gets rid of the resource files.
        return MenuOptionResults.VALID_OPTION_SUCCESS;
    }
}
