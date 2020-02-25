package poetweet;

import java.util.Arrays;

public class FreeFormPoemGenerationOption extends PoemGenerator implements IMenuOption {
    private FreeFormPoem _poem;
    private static final int NUM_ARGS = 3;

    /**
     * Creates a HaikuGenerationOption object.
     * @param poem A poem, for storing the completed poem.
     * @param twitterScraper A TwitterScraper, for pulling tweets.
     * @param tweetParser A TwitterParser, for parsing tweets.
     */
    public FreeFormPoemGenerationOption(FreeFormPoem poem, TwitterScraper twitterScraper, TweetParser tweetParser) {
        super(twitterScraper, tweetParser);
        _poem = poem;
    }

    /**
     * Gets the option instructions.
     * @return What the user needs to do to generate a haiku.
     */
    public String getOptionInstructions() {
        var instruction = "Please input the twitter handle, the poem's length & the number of syllables per line \n";
        instruction +=  "Format: TwitterHandle:NumLinesInPoem:NumSyllablesPerLine (Example: @Hozier:10:10)";
        return instruction;
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
     * @return A short description of the Free form poem Generation Option.
     */
    public String getOptionDescription() {
        return "Generate a Free Form Poem based off someone's tweets";
    }

    /**
     * Gets the result of the poem generation- the poem.
     * @return the haiku that was generate
     */
    public String getOptionResult() {
        return "Your Poem:\n" +  _poem.toString();
    }

    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return The haiku.
     */
    public IReturnable runMenuOption(String userInput) {
        var inputVariables = userInput.split(":");

        if (inputVariables.length < NUM_ARGS) {
            return new Returnables.Faiure();
        }

        var twitterHandle = inputVariables[0];

        createFreeformPoemObject(inputVariables);

        var result = generatePoem(_poem, twitterHandle);

        return result
                ? new ReturnablePoem(_poem, PoemTypes.FREEFORM, twitterHandle)
                : new Returnables.Faiure();
    }

    private void createFreeformPoemObject(String[] inputVariables) {
        var numLines = Integer.parseInt(inputVariables[1]);
        var numSyllables = Integer.parseInt(inputVariables[2]);

        var syllables = new Integer[numLines];
        Arrays.fill(syllables, numSyllables);

        var rhymes = new Integer[numLines];
        Arrays.fill(rhymes, 0);

        _poem = new FreeFormPoem(numLines, syllables, rhymes);
    }
}
