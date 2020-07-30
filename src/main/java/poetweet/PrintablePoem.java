package poetweet;

public class PrintablePoem {
    private Poem _poem;
    private String _twitterHandle;

    /**
     * Constructor.
     * @param poem poem.
     * @param twitterHandle twitter handle of whose tweets became the poem.
     */
    public PrintablePoem(Poem poem, String twitterHandle) {
        _poem = (Poem) poem.getPoemSupplier().get();
        _twitterHandle = twitterHandle;
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
    public String getPoemType() {
        return _poem.getPoemType();
    }

    /**
     * Getter for the twitter handle.
     * @return twitter handle.
     */
    public String getTwitterHandle() {
        return _twitterHandle;
    }
}
