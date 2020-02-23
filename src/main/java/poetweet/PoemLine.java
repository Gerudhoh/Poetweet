package poetweet;

public class PoemLine {
    private int _numSyllables;
    private int _rhyme;
    private String _text;

    /**
     * Constructor for a poem line.
     * @param numSyllables Number of syllables on the poem line
     * @param rhyme The line's rhyming scheme.
     */
    public PoemLine(int numSyllables, int rhyme) {
        _numSyllables = numSyllables;
        _rhyme = rhyme;
    }

    /**
     * Constructor for a poem line.
     * @param numSyllables Number of syllables on the poem line
     * @param rhyme The line's rhyming scheme.
     * @param text The text of the poem line (what the line says).
     */
    public PoemLine(int numSyllables, int rhyme, String text) {
        _numSyllables = numSyllables;
        _rhyme = rhyme;
        _text = text;
    }

    /**
     * Getter for the line's number of syllables.
     * @return the line's number of syllables
     */
    public int getNumSyllables() {
        return _numSyllables;
    }

    /**
     * Getter for the line's rhyming scheme.
     * @return the line's rhyming scheme.
     */
    public int getRhyme() {
        return _rhyme;
    }

    /**
     * Getter for the text of the poem line.
     * @return Like the literal words of the line.
     */
    public String getText() {
        return _text;
    }

    /**
     * Setter for the text of the poem line.
     * @param text The words that the line is gonna say.
     */
    public void setText(String text) {
        _text = text;
    }

    /**
     * It's literally toString.
     * @return The object, stringified.
     */
    @Override
    public String toString() {
        return _text;
    }
}
