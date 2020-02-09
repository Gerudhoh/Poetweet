package poetweet;

import eu.crydee.syllablecounter.SyllableCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class PoemGenerator {
    private static final SyllableCounter _syllableCounter = new SyllableCounter();
    private static final Random _random = new Random();
    private TweetParser _tweetParser;
    private TwitterScraper _twitterScraper;

    public PoemGenerator(TwitterScraper twitterScraper, TweetParser tweetParser){
        _twitterScraper = twitterScraper;
        _tweetParser = tweetParser;
    }

    protected boolean generatePoem(Poem poem, String twitterHandle) {
        TwitterData twitterData;
        var pulledTweets = new File("./resources/" + twitterHandle + "_tweets.csv");

        if(!pulledTweets.exists()){
            _twitterScraper.pullTweetsFromTwitterHandle(twitterHandle);
        }

        try{
            twitterData = _tweetParser.parseTweets(twitterHandle);
        }
        catch(IOException e){
            return false;
        }

        if(twitterData.getTweets().size() <= 0){
            return false;
        }

        generatePoemFromTwitterData(poem, twitterData);

        return true;
    }

    private void generatePoemFromTwitterData(Poem poem, TwitterData twitterData) {
        var usedIndexes = new ArrayList<Integer>();
        var tweets = twitterData.getTweets();
        var poemLines = poem.getPoem();
        var i = 0;

        while(i < poem.getNumberOfLines()){
            var randomTweetIndex = _random.nextInt(tweets.size());
            var generatedLine = generatePoemLine(poemLines.get(i), tweets.get(randomTweetIndex));

            if(usedIndexes.contains(randomTweetIndex) || generatedLine.isEmpty()){
                continue;
            }

            poemLines.get(i).setLine(generatedLine);
            usedIndexes.add(randomTweetIndex);
            i++;
        }
    }

    private String generatePoemLine(PoemLine poemLine, String tweet){
        var wordsInTweet = tweet.split("\\s");
        var wordsForPoemLine = new StringBuilder();
        var syllablesRemaining = poemLine.getNumSyllables();

        if(wordsInTweet.length - syllablesRemaining <= 0){
            return "";
        }

        var randomWordIndex = _random.nextInt(wordsInTweet.length - syllablesRemaining);
        var wordsForLine = Arrays.copyOfRange(wordsInTweet, randomWordIndex, wordsInTweet.length);

        for (var word : wordsForLine) {
            var wordSyllables = _syllableCounter.count(word);

            if(syllablesRemaining - wordSyllables >= 0){
                wordsForPoemLine.append(word);
                wordsForPoemLine.append(" ");
                syllablesRemaining -= wordSyllables;
            }

            if(syllablesRemaining <= 0){
                break;
            }
        }

        return syllablesRemaining == 0
                ? wordsForPoemLine.toString()
                : "";
    }
}
