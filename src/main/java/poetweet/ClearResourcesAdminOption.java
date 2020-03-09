package poetweet;

public final class ClearResourcesAdminOption implements IMenuOption {
    private DirectoryClearer _directoryClearer;

    /**
     * Constructor.
     * @param directoryClearer A directory clearer.
     */
    public ClearResourcesAdminOption(DirectoryClearer directoryClearer) {
        _directoryClearer = directoryClearer;
    }

    /**
     * Gets the option instructions.
     * @return Prompt for user consent
     */
    public String getOptionInstructions() {
        return "Do you want to clear the resources folder. (yes/no)";
    }

    /**
     * Gets the error message in case the operation failed.
     * @return A general diagnosis of what went wrong.
     */
    public String getErrorMessage() {
        return "To run this option, just type \'yes\' when it asks if you want to clear the resources folder.";
    }

    /**
     * Describes the action undertaken by this menu option (For printing the menu).
     * @return A short description of the menu option
     */
    public String getOptionDescription() {
        return "Clean up Resources folder";
    }

    /**
     * The success message of the option.
     * @return The string that the option produced after execution.
     */
    public String getOptionResult() {
        return "Cleared up all the resource files!";
    }

    /**
     * Executes the "clean up resources folder" admin user option.
     * @param userInput whatever information the user provided the system
     * @return A coded value about the command's success.
     */
    public MenuOptionResult runMenuOption(String userInput) {

        if (userInput.indexOf("yes") < 0) {
            return MenuOptionResult.VALID_OPTION_FAILURE;
        }

        _directoryClearer.clearDirectory("./resources");

        return MenuOptionResult.VALID_OPTION_SUCCESS;
    }
}
