package poetweet;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Poem {
    private ArrayList<PoemLine> poem;

    public Poem(int numberOfLines, Integer[] syllablesPerLine, Integer[] rhymingScheme){
        for(int i = 0; i < numberOfLines; i++){
            poem.add(new PoemLine(syllablesPerLine[i], rhymingScheme[i]));
        }
    }

    public int getNumberOfLines(){
        return poem.size();
    }

    public ArrayList<Integer> getSyllablesPerLine(){
        var syllablesPerLine = new ArrayList<Integer>();

        for (var line : poem) {
            syllablesPerLine.add(line.getNumSyllables());
        }

        return syllablesPerLine;
    }

    public ArrayList<Integer> getRhymingScheme(){
        var rhymingScheme = new ArrayList<Integer>();

        for (var line : poem) {
            rhymingScheme.add(line.getRhyme());
        }

        return rhymingScheme;
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        for (var line : poem) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
