package poetweet;

public class PoemLine {
    private int _numSyllables;
    private int _rhyme;
    private String _line;

    public PoemLine(int numSyllables, int rhyme){
        _numSyllables = numSyllables;
        _rhyme = rhyme;
    }

    public int getNumSyllables(){
        return _numSyllables;
    }

    public int getRhyme(){
        return _rhyme;
    }

    public String getLine(){
        return _line;
    }

    public void setLine(String line){
        _line = line;
    }

    @Override
    public String toString() {
        return _line;
    }
}
