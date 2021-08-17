package poetweet;

public class PoemGeneratorFactory {

    /**
     * Build a non-rhyming poem generator.
     * @return a non-rhyming poem generator
     */
    public PoemGenerator buildNonRhymingPoemGenerator() {
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        return new NonRhymingPoemGenerator(twitterScraper, tweetParser);
    }

    /**
     * Build a rhyming poem generator.
     * @return a rhyming poem generator
     */
    public PoemGenerator buildRhymingPoemGenerator() {
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        return new RhymingPoemGenerator(twitterScraper, tweetParser);
    }
}
