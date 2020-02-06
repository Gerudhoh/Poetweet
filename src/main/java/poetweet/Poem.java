package poetweet;

import java.util.ArrayList;

public abstract class Poem {
    private int _numberOfLines;
    private ArrayList<Integer> _syllablesPerLine;
    private ArrayList<Integer> _rhymingScheme;

    public Poem(int numberOfLines, ArrayList<Integer> syllablesPerLine, ArrayList<Integer> rhymingScheme){
        _numberOfLines = numberOfLines;
        _syllablesPerLine = syllablesPerLine;
        _rhymingScheme = rhymingScheme;
    }

    public int getNumberOfLines(){
        return _numberOfLines;
    }


}
