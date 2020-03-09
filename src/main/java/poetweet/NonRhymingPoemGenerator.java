package poetweet;

import java.util.ArrayList;

public final class NonRhymingPoemGenerator extends PoemGenerator {

    /**
     * Constructor for the PoemGenerator.
     * @param twitterScraper TwitterScraper
     * @param tweetParser TweetParser
     */
    public NonRhymingPoemGenerator(TwitterScraper twitterScraper, TweetParser tweetParser) {
        super(twitterScraper, tweetParser);
    }

    protected boolean generatePoemFromTwitterData(Poem poem, TwitterData twitterData) {
        var usedIndexes = new ArrayList<Integer>();
        var tweets = twitterData.getTweets();
        var poemLines = poem.getPoem();
        var i = 0;

        while (i < poem.getNumberOfLines()) {
            var tweet = getRandomTweet(tweets, usedIndexes);
            if (usedIndexes.size() == tweets.size()) {
                throw new Exceptions.NotEnoughTweetsException();
            }

            var generatedLine = generatePoemLine(poemLines.get(i), tweet);

            if (generatedLine.isEmpty()) {
                continue;
            }

            poemLines.get(i).setText(generatedLine);
            i++;
        }

        return true;
    }
}
