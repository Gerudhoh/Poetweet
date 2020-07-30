package poetweet;

import java.util.function.Supplier;

public final class FreeVersePoem extends Poem {
    /**
     * Supplies an entity with a printable poem.
     *
     * @return A new poem object
     */
    @Override
    public Supplier getPoemSupplier() {
        return () -> new FreeVersePoem(this);
    }

    /**
     * @return The string representing the type of poem.
     */
    @Override
    public String getPoemType() {
        return "FreeVersePoem";
    }

    /**
     * Constructor for the Poem class.
     *
     * @param numberOfLines    The number of lines in a poem.
     * @param syllablesPerLine The syllable pattern for the poem's lines.
     * @param rhymingScheme    The rhyming scheme for the poem's lines.
     */
    public FreeVersePoem(int numberOfLines, Integer[] syllablesPerLine, Integer[] rhymingScheme) {
        super(numberOfLines, syllablesPerLine, rhymingScheme);
    }

    /**
     * Copy constructor for the Poem class.
     *
     * @param poem the poem we're copying.
     */
    public FreeVersePoem(Poem poem) {
        super(poem);
    }
}
