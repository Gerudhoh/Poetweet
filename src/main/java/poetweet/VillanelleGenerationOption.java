package poetweet;

import java.util.ArrayList;

public class VillanelleGenerationOption extends PoemGenerationOption {
    private Villanelle _poem;
    private IPoemGenerator _poemGenerator;

    /**
     * Creates a QuatrainGenerationOption object.
     * @param poem A Quatrain, for storing the completed poem.
     * @param poems A list of all the poems we've created.
     * @param poemGenerator the poem generator.
     */
    public VillanelleGenerationOption(Villanelle poem, ArrayList<PrintablePoem> poems, IPoemGenerator poemGenerator) {
        super(poem, poems);
        _poem = poem;
        _poemGenerator = poemGenerator;
    }

    /**
     * Gets the option description (For printing the menu).
     * @return A short description of the Quatrain Generation Option.
     */
    public String getOptionDescription() {
        return "Generate a Villanelle based off someone's tweets";
    }


    /**
     * Executes the specific user option.
     * @param userInput The twitter handle
     * @return The menu option result.
     */
    public MenuOptionResult runMenuOption(String userInput) {
        var generatedPoemSuccess = _poemGenerator.generatePoem(_poem, userInput);

        if (!generatedPoemSuccess) {
            return MenuOptionResult.VALID_OPTION_FAILURE;
        }

        var poem = new PrintablePoem(_poem, PoemTypes.VILLANELLE, userInput);
        addNewPoemToList(poem);

        return MenuOptionResult.VALID_OPTION_SUCCESS;
    }
}
