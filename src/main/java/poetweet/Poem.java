package poetweet;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Poem {
    private int _numberOfLines;
    private ArrayList<Integer> _syllablesPerLine;
    private ArrayList<Integer> _rhymingScheme;

    public Poem(int numberOfLines, Integer[] syllablesPerLine, Integer[] rhymingScheme){
        _numberOfLines = numberOfLines;
        _syllablesPerLine = new ArrayList<>(Arrays.asList(syllablesPerLine));
        _rhymingScheme = new ArrayList<>(Arrays.asList(rhymingScheme));
    }

    public Poem() {

    }

    public int getNumberOfLines(){
        return _numberOfLines;
    }

    public ArrayList<Integer> getSyllablesPerLine(){
        return _syllablesPerLine;
    }

    public ArrayList<Integer> getRhymingScheme(){
        return _rhymingScheme;
    }


}
