package poetweet;

import java.util.ArrayList;

public abstract class Poem {
    private ArrayList<PoemLine> _poem;

    /**
     * Constructor for the Poem class.
     * @param numberOfLines The number of lines in a poem.
     * @param syllablesPerLine The syllable pattern for the poem's lines.
     * @param rhymingScheme The rhyming scheme for the poem's lines.
     */
    public Poem(int numberOfLines, Integer[] syllablesPerLine, Integer[] rhymingScheme) {
        _poem = new ArrayList<>();
        for (int i = 0; i < numberOfLines; i++) {
            _poem.add(new PoemLine(syllablesPerLine[i], rhymingScheme[i]));
        }
    }

    /**
     * Getter for the number of lines in the poem.
     * @return The number of lines in the poem.
     */
    public int getNumberOfLines() {
        return _poem.size();
    }

    /**
     * Getter for the syllable scheme in the poem.
     * @return the syllable scheme in the poem
     */
    public ArrayList<Integer> getSyllablesPerLine() {
        var syllablesPerLine = new ArrayList<Integer>();

        for (var line : _poem) {
            syllablesPerLine.add(line.getNumSyllables());
        }

        return syllablesPerLine;
    }

    /**
     * Getter for the poem's rhyming scheme.
     * @return The poem's rhyming scheme.
     */
    public ArrayList<Integer> getRhymingScheme() {
        var rhymingScheme = new ArrayList<Integer>();

        for (var line : _poem) {
            rhymingScheme.add(line.getRhyme());
        }

        return rhymingScheme;
    }

    /**
     * Getter for the poem... the collection of lines and the data associated with them.
     * @return the collection of lines and the data associated with them.
     */
    public ArrayList<PoemLine> getPoem() {
        return _poem;
    }

    /**
     * It's toString.
     * @return The poem, printed out all nicely.
     */
    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        for (var line : _poem) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
