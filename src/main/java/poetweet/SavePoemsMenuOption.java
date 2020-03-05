package poetweet;

import java.util.ArrayList;

public final class SavePoemsMenuOption implements IMenuOption {
    private ArrayList<PrintablePoem> _poems;
    private PoemSaver _poemSaver;

    /**
     * Constructor.
     * @param poems All the poems we'll want to save.
     * @param poemSaver the poemsaver.
     */
    public SavePoemsMenuOption(ArrayList<PrintablePoem> poems, PoemSaver poemSaver) {
        _poems = poems;
        _poemSaver = poemSaver;
    }

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
    public MenuOptionResult runMenuOption(String userInput) {
        var result = MenuOptionResult.VALID_OPTION_FAILURE;
        if (userInput.toLowerCase().equals("all")) {
            _poemSaver.savePoems(_poems);
            result = MenuOptionResult.VALID_OPTION_SUCCESS;
        }
        return result;
    }
}
