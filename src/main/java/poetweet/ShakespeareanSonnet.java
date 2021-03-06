package poetweet;

import java.util.function.Supplier;

public class ShakespeareanSonnet extends Poem {
    private static final int NUMLINES = 14;
    private static final int SYLLABLES = 10;
    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;
    private static final int D = 4;
    private static final int E = 5;
    private static final int F = 6;
    private static final int G = 7;

    /**
     * Constructor.
     */
    public ShakespeareanSonnet() {
        super(NUMLINES,
                new Integer[]{
                        SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES,
                        SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES,
                        SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES,
                        SYLLABLES, SYLLABLES
                },
                new Integer[]{
                        A, B, A, B,
                        C, D, C, D,
                        E, F, E, F,
                        G, G}
                );
    }

    /**
     * Supplies an entity with a printable poem.
     *
     * @return A new poem object
     */
    @Override
    public Supplier getPoemSupplier() {
        return () -> new ShakespeareanSonnet(this);
    }

    /**
     * @return The string representing the type of poem.
     */
    @Override
    public String getPoemType() {
        return "ShakespeareanSonnet";
    }

    /**
     * Copy constructor for Quatrain.
     * @param poem the poem we're copying.
     */
    public ShakespeareanSonnet(Poem poem) {
        super(poem);
    }
}
