package poetweet;

import java.util.function.Supplier;

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
     * Supplies an entity with a printable poem.
     *
     * @return A new poem object
     */
    @Override
    public Supplier getPoemSupplier() {
        return () -> new Quatrain(this);
    }

    /**
     * @return The string representing the type of poem.
     */
    @Override
    public String getPoemType() {
        return "Quatrain";
    }

    /**
     * Copy constructor for Quatrain.
     * @param poem the poem we're copying.
     */
    public Quatrain(Poem poem) {
        super(poem);
    }
}
