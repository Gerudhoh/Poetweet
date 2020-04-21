package poetweet;

public class PrintablePoem {
    private Poem _poem;
    private PoemTypes _poemType;
    private String _twitterHandle;

    /**
     * Constructor.
     * @param poem poem.
     * @param twitterHandle twitter handle of whose tweets became the poem.
     * @param poemType The type of poem that it is.
     */
    public PrintablePoem(Poem poem, PoemTypes poemType, String twitterHandle) {
        _poemType = poemType;
        _twitterHandle = twitterHandle;

        switch (_poemType) {
            case HAIKU:
                _poem = new Haiku(poem);
                break;
            case FREEVERSE:
                _poem = new FreeVersePoem(poem);
                break;
            case QUATRAIN:
                _poem = new Quatrain(poem);
                break;
            case SONNET:
                _poem = new ShakespeareanSonnet(poem);
                break;
            case VILLANELLE:
                _poem = new Villanelle(poem);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + _poemType);
        }
    }

    /**
     * Getter for the poem.
     * @return the poem.
     */
    public Poem getPoem() {
        return _poem;
    }

    /**
     * Getter for the poem type.
     * @return the poem type.
     */
    public PoemTypes getPoemType() {
        return _poemType;
    }

    /**
     * Getter for the twitter handle.
     * @return twitter handle.
     */
    public String getTwitterHandle() {
        return _twitterHandle;
    }
}
