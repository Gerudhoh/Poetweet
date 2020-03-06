package poetweet;

public class Quatrain extends Poem {
    private static final int NUMLINES = 4;
    private static final int SYLLABLES = 10;
    private static final int A = 1;
    private static final int B = 2;

    /**
     * Constructor.
     */
    public Quatrain() {
        super(NUMLINES,
                new Integer[]{SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES},
                new Integer[]{A, B, A, B}
                );
    }

    /**
     * Copy constructor for Quatrain.
     * @param poem the poem we're copying.
     */
    public Quatrain(Poem poem) {
        super(poem);
    }
}
