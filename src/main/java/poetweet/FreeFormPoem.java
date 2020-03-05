package poetweet;

public class FreeFormPoem extends Poem {
    /**
     * Constructor for the Poem class.
     *
     * @param numberOfLines    The number of lines in a poem.
     * @param syllablesPerLine The syllable pattern for the poem's lines.
     * @param rhymingScheme    The rhyming scheme for the poem's lines.
     */
    public FreeFormPoem(int numberOfLines, Integer[] syllablesPerLine, Integer[] rhymingScheme) {
        super(numberOfLines, syllablesPerLine, rhymingScheme);
    }

    /**
     * Copy constructor for the Poem class.
     *
     * @param poem the poem we're copying.
     */
    public FreeFormPoem(Poem poem) {
        super(poem);
    }
}
