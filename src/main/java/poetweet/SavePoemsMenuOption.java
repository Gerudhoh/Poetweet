package poetweet;

public final class SavePoemsMenuOption implements IMenuOption {

    /**
     * Getter for what you tell the user to do.
     * @return
     */
    @Override
    public String getOptionInstructions() {
        return "Which poems do you want to save? Options: all";
    }

    /**
     * This lets the user know that something went wrong.
     * @return The error message.
     */
    @Override
    public String getErrorMessage() {
        return "Unable to save poems to files. Try again and ensure you type \'all\' to save the poems";
    }

    @Override
    public String getOptionDescription() {
        return "Save Poems to Files.";
    }

    /**
     * The opposite of an error message, this lets the user know it did the thing.
     * @return The success notification.
     */
    @Override
    public String getOptionResult() {
        return "Saving poems!";
    }

    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return A coded value about the command's success.
     */
    @Override
    public IReturnable runMenuOption(String userInput) {
        if (userInput.toLowerCase().equals("all")) {
            return new PoemSaver();
        }
        return null;
    }
}
