package poetweet;

public class Haiku extends Poem {
    public static final int NUMLINES = 3;
    public static final int OTHER_LINE_SYLLABLES = 5;
    public static final int MIDDLE_LINE_SYLLABLES = 7;
    public static final int RHYME = 0;

    /**
     * This is the constructor for a Haiku.
     * It has no rhyming scheme, and its structure is simple.
     * 3 lines. 5 syllables for the first and last line, 7 for the middle.
     */
    public Haiku() {
        super(
                NUMLINES,
                new Integer[]{OTHER_LINE_SYLLABLES, MIDDLE_LINE_SYLLABLES, OTHER_LINE_SYLLABLES},
                new Integer[]{RHYME, RHYME, RHYME}
              );
    }
}
