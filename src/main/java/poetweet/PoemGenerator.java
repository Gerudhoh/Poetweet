package poetweet;

import eu.crydee.syllablecounter.SyllableCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class PoemGenerator {
    private static final SyllableCounter SYLLABLE_COUNTER = new SyllableCounter();
    private static final Random RANDOM = new Random();
    private TweetParser _tweetParser;
    private TwitterScraper _twitterScraper;

    /**
     * Constructor for the PoemGenerator.
     * @param twitterScraper TwitterScraper
     * @param tweetParser TweetParser
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
    protected boolean generatePoem(Poem poem, String twitterHandle) {
        TwitterData twitterData;
        var pulledTweets = new File("./resources/" + twitterHandle + "_tweets.csv");

        if (!pulledTweets.exists()) {
            _twitterScraper.pullTweetsFromTwitterHandle(twitterHandle);
        }

        try {
            twitterData = _tweetParser.parseTweets(twitterHandle);
        } catch (IOException e) {
            throw new Exceptions.PoetweetIOException();
        }

        if (twitterData.getTweets().size() <= 0) {
            return false;
        }

        var result = generatePoemFromTwitterData(poem, twitterData);

        return result;
    }

    private boolean generatePoemFromTwitterData(Poem poem, TwitterData twitterData) {
        var usedIndexes = new ArrayList<Integer>();
        var tweets = twitterData.getTweets();
        var poemLines = poem.getPoem();
        var i = 0;

        while (i < poem.getNumberOfLines()) {
            if(usedIndexes.size() == tweets.size()){
                throw new Exceptions.NotEnoughTweetsException();
            }

            var randomTweetIndex = RANDOM.nextInt(tweets.size());

            if (usedIndexes.contains(randomTweetIndex)){
                continue;
            }

            usedIndexes.add(randomTweetIndex);
            var generatedLine = generatePoemLine(poemLines.get(i), tweets.get(randomTweetIndex));

            if (generatedLine.isEmpty()) {
                continue;
            }

            poemLines.get(i).setText(generatedLine);
            i++;
        }

        return true;
    }

    private String generatePoemLine(PoemLine poemLine, String tweet) {
        var wordsInTweet = tweet.split("\\s");
        var wordsForPoemLine = new StringBuilder();
        var syllablesRemaining = poemLine.getNumSyllables();
        var syllablesInTweet = getTotalSyllables(wordsInTweet);

        if(syllablesInTweet < syllablesRemaining){
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

    private int getTotalSyllables(String[] wordsInTweet){
        int totalSyllables = 0;
        for (var word : wordsInTweet) {
            var count = SYLLABLE_COUNTER.count(word);
            totalSyllables += count;
        }

        return totalSyllables;
    }
}
