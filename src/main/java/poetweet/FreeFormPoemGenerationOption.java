package poetweet;

import java.util.ArrayList;
import java.util.Arrays;

public class FreeFormPoemGenerationOption extends PoemGenerationOption {
    private FreeFormPoem _poem;
    private IPoemGenerator _poemGenerator;
    private static final int NUM_ARGS = 3;

    /**
     * Creates a HaikuGenerationOption object.
     * @param poem A poem, for storing the completed poem.
     * @param poems an arraylist of all the poems created.
     */
    public FreeFormPoemGenerationOption(
            FreeFormPoem poem,
            ArrayList<PrintablePoem> poems,
            IPoemGenerator poemGenerator) {
        super(poem, poems);
        _poem = poem;
        _poemGenerator = poemGenerator;
    }

    /**
     * Gets the option description (For printing the menu).
     * @return A short description of the Free form poem Generation Option.
     */
    public String getOptionDescription() {
        return "Generate a Free Form Poem based off someone's tweets";
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

        var poem = new PrintablePoem(_poem, PoemTypes.FREEFORM, twitterHandle);
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

        _poem = new FreeFormPoem(numLines, syllables, rhymes);
    }
}
