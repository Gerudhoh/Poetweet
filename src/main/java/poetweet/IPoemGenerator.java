package poetweet;

public interface IPoemGenerator {

    /**
     * Generate a poem from tweets.
     * @param poem The poem object we're going to fill/use for reference when we make the poem.
     * @param twitterHandle The twitter handle of the person whose tweets are beoming a poem.
     * @return whether or not it worked.
     */
    boolean generatePoem(Poem poem, String twitterHandle);
}
