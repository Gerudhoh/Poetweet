package poetweet;

import eu.crydee.syllablecounter.SyllableCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class PoemGenerator implements IPoemGenerator {
    private static final SyllableCounter SYLLABLE_COUNTER = new SyllableCounter();
    private static final Random RANDOM = new Random();
    private TweetParser _tweetParser;
    private TwitterScraper _twitterScraper;

    /**
     * Constructor.
     * @param twitterScraper pulls tweets from internet.
     * @param tweetParser Parses tweets.
     */
    public PoemGenerator(TwitterScraper twitterScraper, TweetParser tweetParser) {
        _twitterScraper = twitterScraper;
        _tweetParser = tweetParser;
    }

    /**
     * Method collects tweets from a specified user, parses them up, and transforms the tweets into the poem specified.
     * @param poem The type of poem the user wants to make, and what the final poem will be stored in.
     * @param twitterHandle The twitter handle for the person whose tweets you want to turn into a poem.
     * @return true if it worked and false if something went wrong.
     */
    public boolean generatePoem(Poem poem, String twitterHandle) {
        TwitterData twitterData;
        var pulledTweets = new File("./resources/" + twitterHandle + "_tweets.csv");

        if (!pulledTweets.exists()) {
            _twitterScraper.pullTweetsFromTwitterHandle(twitterHandle);
        }

        twitterData = _tweetParser.parseTweets(twitterHandle);

        if (twitterData.getTweets().size() <= 0) {
            return false;
        }

        var result = generatePoemFromTwitterData(poem, twitterData);

        return result;
    }

    /**
     * Turn a bunch of tweets into a poem.
     * @param poem The poem object, has info about type of poem, also where the final poem is stored.
     * @param twitterData The tweets we're turning into a poem.
     * @return Did it word? Yes (true) or no (false).
     */
    protected abstract boolean generatePoemFromTwitterData(Poem poem, TwitterData twitterData);

    /**
     * Generate one line of a poem from one tweet.
     * @param poemLine The poem line object, has info about the line itself.
     * @param tweet The tweet we'll use to turn into poetry.
     * @return The string that we'll set to the poem line.
     */
    protected String generatePoemLine(PoemLine poemLine, String tweet) {
        var wordsInTweet = tweet.split("[ \\\\n]");
        var wordsForPoemLine = new StringBuilder();
        var syllablesRemaining = poemLine.getNumSyllables();
        var syllablesInTweet = getTotalSyllables(wordsInTweet);

        if (syllablesInTweet < syllablesRemaining) {
            return "";
        }

        var randomWordIndex = wordsInTweet.length - syllablesRemaining > 0
                ? RANDOM.nextInt(wordsInTweet.length - syllablesRemaining)
                : 0;

        var wordsForLine = Arrays.copyOfRange(wordsInTweet, randomWordIndex, wordsInTweet.length);

        for (var word : wordsForLine) {
            var wordSyllables = SYLLABLE_COUNTER.count(word);

            if (syllablesRemaining - wordSyllables >= 0) {
                wordsForPoemLine.append(word);
                wordsForPoemLine.append(" ");
                syllablesRemaining -= wordSyllables;
            }

            if (syllablesRemaining <= 0) {
                break;
            }
        }

        return syllablesRemaining == 0
                ? wordsForPoemLine.toString()
                : "";
    }

    /**
     * Gets the total amount of syllables in an entire tweet.
     * @param wordsInTweet array of all the words in the tweet.
     * @return the total amount of syllables.
     */
    protected int getTotalSyllables(String[] wordsInTweet) {
        int totalSyllables = 0;
        for (var word : wordsInTweet) {
            var count = SYLLABLE_COUNTER.count(word);
            totalSyllables += count;
        }

        return totalSyllables;
    }

    /**
     * Gets a random tweet (that we haven't already selected).
     * @param tweets All the tweets.
     * @param usedIndexes All the indexes for tweets that we've already looked at.
     * @return The random tweet.
     */
    protected String getRandomTweet(ArrayList<String> tweets, ArrayList<Integer> usedIndexes) {
        var randomTweetIndex = 0;

        while (true) {
            if (usedIndexes.size() >= tweets.size()) {
                throw new Exceptions.NotEnoughTweetsException();
            }

            randomTweetIndex = RANDOM.nextInt(tweets.size());

            if (!usedIndexes.contains(randomTweetIndex)) {
                usedIndexes.add(randomTweetIndex);
                break;
            }
        }

        return tweets.get(randomTweetIndex);
    }

}
