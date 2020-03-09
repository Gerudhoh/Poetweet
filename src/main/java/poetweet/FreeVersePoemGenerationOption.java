package poetweet;

import java.util.ArrayList;
import java.util.Arrays;

public final class FreeVersePoemGenerationOption extends PoemGenerationOption {
    private FreeVersePoem _poem;
    private IPoemGenerator _poemGenerator;
    private static final int NUM_ARGS = 3;

    /**
     * Creates a HaikuGenerationOption object.
     * @param poem A poem, for storing the completed poem.
     * @param poems an arraylist of all the poems created.
     * @param poemGenerator the poem generator object (rhyming or non-rhyming)
     */
    public FreeVersePoemGenerationOption(
            FreeVersePoem poem,
            ArrayList<PrintablePoem> poems,
            IPoemGenerator poemGenerator) {
        super(poem, poems);
        _poem = poem;
        _poemGenerator = poemGenerator;
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
     * Gets the option description (For printing the menu).
     * @return A short description of the Free verse poem Generation Option.
     */
    public String getOptionDescription() {
        return "Generate a Free Verse Poem based off someone's tweets";
    }

    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return The haiku.
     */
    public MenuOptionResult runMenuOption(String userInput) {
        var inputVariables = userInput.split(":");

        if (inputVariables.length < NUM_ARGS) {
            return MenuOptionResult.VALID_OPTION_FAILURE;
        }

        var twitterHandle = inputVariables[0];

        createFreeformPoemObject(inputVariables);

        var result = _poemGenerator.generatePoem(_poem, twitterHandle);

        if (!result) {
            return MenuOptionResult.VALID_OPTION_FAILURE;
        }

        var poem = new PrintablePoem(_poem, PoemTypes.FREEVERSE, twitterHandle);
        addNewPoemToList(poem);

        return MenuOptionResult.VALID_OPTION_SUCCESS;
    }

    private void createFreeformPoemObject(String[] inputVariables) {
        var numLines = Integer.parseInt(inputVariables[1]);
        var numSyllables = Integer.parseInt(inputVariables[2]);

        var syllables = new Integer[numLines];
        Arrays.fill(syllables, numSyllables);

        var rhymes = new Integer[numLines];
        Arrays.fill(rhymes, 0);

        _poem = new FreeVersePoem(numLines, syllables, rhymes);
        setPoem(_poem);
    }
}
