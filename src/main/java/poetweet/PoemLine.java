package poetweet;

public class PoemLine {
    private int _numSyllables;
    private int _rhyme;
    private String _line;

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
    public String getLine() {
        return _line;
    }

    /**
     * Setter for the text of the poem line.
     * @param line The words that the line is gonna say.
     */
    public void setLine(String line) {
        _line = line;
    }

    /**
     * It's literally toString.
     * @return The object, stringified.
     */
    @Override
    public String toString() {
        return _line;
    }
}
