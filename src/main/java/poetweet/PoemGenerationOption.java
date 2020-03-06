package poetweet;

import java.util.ArrayList;

public abstract class PoemGenerationOption implements IMenuOption {
    private Poem _poem;
    private ArrayList<PrintablePoem> _poems;

    /**
     * Constructor.
     * @param poems A list of all the poems we've created.
     */
    public PoemGenerationOption(Poem poem, ArrayList<PrintablePoem> poems) {
        _poem = poem;
        _poems = poems;
    }

    /**
     * Gets the option instructions.
     * @return What the user needs to do to generate a haiku.
     */
    public String getOptionInstructions() {
        return "Please input the twitter handle of the person whose tweets you want to turn into a poem.";
    }

    /**
     * Returns an error message.
     * @return the error message.
     */
    public String getErrorMessage() {
        var errorMessage = "Something went wrong, and the tweets were not able to be pulled. \n";
        errorMessage +=  " Please make sure that the twitter account you want to see is public.";
        return errorMessage;
    }
    /**
     * Gets the option description (For printing the menu).
     * @return A short description of the Haiku Generation Option.
     */
    public abstract String getOptionDescription();

    /**
     * Gets the result of the haiku generation- the haiku.
     * @return the haiku that was generate
     */
    public String getOptionResult() {
        return "Your Poem:\n" +  _poem.toString();
    }

    /**
     * Add a newly generated poem to the list of all poems.
     * @param poem the poem to add.
     */
    protected void addNewPoemToList(PrintablePoem poem) {
        _poems.add(poem);
    }

    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return The haiku.
     */
    public abstract MenuOptionResult runMenuOption(String userInput);
}
