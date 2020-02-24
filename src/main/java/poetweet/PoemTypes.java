package poetweet;

public enum PoemTypes {
    HAIKU("Haiku"),
    FREEFORM("FreeForm"),
    SONNET("Sonnet");

    private String _poemType;

    PoemTypes(String poemType) {
        _poemType = poemType;
    }

    /**
     * Gets the string associated with the poem type.
     * @return the string associated with the poem type.
     */
    public String getType() {
        return _poemType;
    }
}
