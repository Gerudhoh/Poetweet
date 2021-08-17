package poetweet;

import java.util.ArrayList;

public class HaikuGenerationOption extends PoemGenerationOption {
    private Haiku _haiku;
    private IPoemGenerator _poemGenerator;

    /**
     * Creates a HaikuGenerationOption object.
     * @param haiku A Haiku, for storing the completed poem.
     * @param poems A list of all the poems we've created.
     * @param poemGenerator the poem generator object (rhyming or non-rhyming)
     */
    public HaikuGenerationOption(Haiku haiku, ArrayList<PrintablePoem> poems, IPoemGenerator poemGenerator) {
        super(haiku, poems);
        _haiku = haiku;
        _poemGenerator = poemGenerator;
    }

    /**
     * Test.
     * @return String the Haiku
     */
    public String getHaiku() {
        return "five syllables here / then seven syllables go here / and a final five";
    }


    /**
     * Gets the option description (For printing the menu).
     * @return A short description of the Haiku Generation Option.
     */
    public String getOptionDescription() {
        return "Generate a Haiku based off someone's tweets";
    }

    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return The haiku.
     */
    public MenuOptionResult runMenuOption(String userInput) {
        var generatedPoemSuccess = _poemGenerator.generatePoem(_haiku, userInput);

        if (!generatedPoemSuccess) {
            return MenuOptionResult.VALID_OPTION_FAILURE;
        }

        var poem = new PrintablePoem(_haiku, userInput);
        addNewPoemToList(poem);

        return MenuOptionResult.VALID_OPTION_SUCCESS;
    }
}
