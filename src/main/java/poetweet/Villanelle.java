package poetweet;

import java.util.function.Supplier;

public class Villanelle extends Poem {
    private static final int NUMLINES = 19;
    private static final int SYLLABLES = 8;
    private static final int A = 1;
    private static final int B = 2;
    private static final int REFRAIN1 = -1;
    private static final int REFRAIN2 = -2;

    /**
     * Constructor.
     */
    public Villanelle() {
        super(NUMLINES,
                new Integer[]{SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES,
                        SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES,
                        SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES},
                new Integer[]{A, B, A, A, B, REFRAIN1, A, B, REFRAIN2, A, B,
                        REFRAIN1, A, B, REFRAIN2, A, B, REFRAIN1, REFRAIN2}
                );
    }

    /**
     * Supplies an entity with a printable poem.
     *
     * @return A new poem object
     */
    @Override
    public Supplier getPoemSupplier() {
        return () -> new Villanelle(this);
    }

    /**
     * @return The string representing the type of poem.
     */
    @Override
    public String getPoemType() {
        return "Villanelle";
    }

    /**
     * Copy constructor for Quatrain.
     * @param poem the poem we're copying.
     */
    public Villanelle(Poem poem) {
        super(poem);
    }
}
