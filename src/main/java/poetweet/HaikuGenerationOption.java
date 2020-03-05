package poetweet;

import java.util.ArrayList;

public class HaikuGenerationOption extends PoemGenerator implements IMenuOption {
    private Haiku _haiku;

    /**
     * Creates a HaikuGenerationOption object.
     * @param haiku A Haiku, for storing the completed poem.
     * @param poems A list of all the poems we've created.
     * @param twitterScraper A TwitterScraper, for pulling tweets.
     * @param tweetParser A TwitterParser, for parsing tweets.
     */
    public HaikuGenerationOption(
            Haiku haiku,
            ArrayList<PrintablePoem> poems,
            TwitterScraper twitterScraper,
            TweetParser tweetParser) {
        super(poems, twitterScraper, tweetParser);
        _haiku = haiku;
    }

    /**
     * Gets the option instructions.
     * @return What the user needs to do to generate a haiku.
     */
    public String getOptionInstructions() {
        return "Please input the twitter handle of the person whose tweets you want to turn into a Haiku.";
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
    public String getOptionDescription() {
        return "Generate a Haiku based off someone's tweets";
    }

    /**
     * Gets the result of the haiku generation- the haiku.
     * @return the haiku that was generate
     */
    public String getOptionResult() {
        return "Your Haiku:\n" +  _haiku.toString();
    }

    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return The haiku.
     */
    public MenuOptionResult runMenuOption(String userInput) {
        var generatedPoemSuccess = generatePoem(_haiku, userInput);

        if (!generatedPoemSuccess) {
            return MenuOptionResult.VALID_OPTION_FAILURE;
        }

        var poem = new PrintablePoem(_haiku, PoemTypes.HAIKU, userInput);
        addNewPoemToList(poem);

        return MenuOptionResult.VALID_OPTION_SUCCESS;
    }
}
