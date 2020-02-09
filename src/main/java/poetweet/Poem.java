package poetweet;

import java.util.ArrayList;

public abstract class Poem {
    private ArrayList<PoemLine> _poem;

    public Poem(int numberOfLines, Integer[] syllablesPerLine, Integer[] rhymingScheme){
        _poem = new ArrayList<>();
        for(int i = 0; i < numberOfLines; i++){
            _poem.add(new PoemLine(syllablesPerLine[i], rhymingScheme[i]));
        }
    }

    public int getNumberOfLines(){
        return _poem.size();
    }

    public ArrayList<Integer> getSyllablesPerLine(){
        var syllablesPerLine = new ArrayList<Integer>();

        for (var line : _poem) {
            syllablesPerLine.add(line.getNumSyllables());
        }

        return syllablesPerLine;
    }

    public ArrayList<Integer> getRhymingScheme(){
        var rhymingScheme = new ArrayList<Integer>();

        for (var line : _poem) {
            rhymingScheme.add(line.getRhyme());
        }

        return rhymingScheme;
    }

    public ArrayList<PoemLine> getPoem(){
        return _poem;
    }

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
