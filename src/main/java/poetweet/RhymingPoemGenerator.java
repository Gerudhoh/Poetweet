package poetweet;

import ca.rmen.rhymer.Rhymer;
import ca.rmen.rhymer.cmu.CmuDictionary;
import eu.crydee.syllablecounter.SyllableCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class RhymingPoemGenerator implements IPoemGenerator {
    private static final SyllableCounter SYLLABLE_COUNTER = new SyllableCounter();
    private static final Random RANDOM = new Random();
    private TweetParser _tweetParser;
    private TwitterScraper _twitterScraper;

    /**
     * Constructor for the PoemGenerator.
     * @param poems an arraylist of all the poems created.
     * @param twitterScraper TwitterScraper
     * @param tweetParser TweetParser
     */
    public RhymingPoemGenerator(ArrayList<PrintablePoem> poems, TwitterScraper twitterScraper, TweetParser tweetParser) {
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
        Rhymer rhymer;

        var pulledTweets = new File("./resources/" + twitterHandle + "_tweets.csv");

        if (!pulledTweets.exists()) {
            _twitterScraper.pullTweetsFromTwitterHandle(twitterHandle);
        }

        twitterData = _tweetParser.parseTweets(twitterHandle);

        if (twitterData.getTweets().size() <= 0) {
            return false;
        }

        try {
            rhymer =  CmuDictionary.loadRhymer();
        } catch (IOException e) {
            throw new Exceptions.PoetweetIOException(e.getMessage());
        }

        var result = generatePoemFromTwitterData(rhymer, poem, twitterData);

        return result;
    }

    private boolean generatePoemFromTwitterData(Rhymer rhymer, Poem poem, TwitterData twitterData) {
        var usedIndexes = new ArrayList<Integer>();
        var tweets = twitterData.getTweets();
        var poemLines = poem.getPoem();
        var allRhymes = new HashMap<Integer, HashMap<String, String>>();
        var i = 0;

        while (i < poem.getNumberOfLines()) {
            var tweet = getRandomTweet(tweets, usedIndexes);
            var line = poemLines.get(i);
            var lineRhyme = line.getRhyme();

            var generatedLine = allRhymes.containsKey(lineRhyme)
                    ? generateRhyme(line, tweets, allRhymes.get(lineRhyme))
                    : generatePoemLine(line, tweet);

            if (generatedLine.isEmpty()) {
                continue;
            }

            if(!allRhymes.containsKey(lineRhyme)) {
                var rhymes = getRhymingWords(rhymer, generatedLine);
                if(rhymes.size() <= 10) {
                    continue;
                }
                var applicableTweets = getTweetsThatContainRhymes(tweets, rhymes);

                if(applicableTweets.size() < 3) {
                    continue;
                }
                allRhymes.put(lineRhyme, applicableTweets);
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

    private String generateRhymingLine(PoemLine poemLine, String tweet, String rhyme) {
        var wordsInTweet = tweet.split("\\s");
        var wordsForPoemLine = new ArrayList<String>();
        var syllablesRemaining = poemLine.getNumSyllables();
        var syllablesInTweet = getTotalSyllables(wordsInTweet);

        if (syllablesInTweet < syllablesRemaining) {
            return "";
        }

        var index = Arrays.asList(wordsInTweet).lastIndexOf(rhyme);

        var wordsForLine = Arrays.copyOfRange(wordsInTweet, 0, index+1);
        var len = wordsForLine.length-1;

        for (int i = len; i >= 0; i--) {
            var word = wordsForLine[i];
            var wordSyllables = SYLLABLE_COUNTER.count(word);

            if (syllablesRemaining - wordSyllables >= 0) {
                wordsForPoemLine.add(word);
                syllablesRemaining -= wordSyllables;
            }

            if (syllablesRemaining <= 0) {
                break;
            }
        }

        Collections.reverse(wordsForPoemLine);

        return syllablesRemaining == 0
                ? arrayToPoemLine(wordsForPoemLine)
                : "";
    }

    private String generateRhyme(PoemLine poemLine, ArrayList<String> tweets,  HashMap<String, String> rhymables){
        var usedIndexes = new ArrayList<Integer>();
        var rhymableTweets = new ArrayList<>(rhymables.values());
        var tweet = getRandomTweet(rhymableTweets, usedIndexes);
        var rhyme = getRhymeFromValue(rhymables, tweet);

        return generateRhymingLine(poemLine, tweet, rhyme);
    }

    private String getRandomTweet(ArrayList<String> tweets, ArrayList<Integer> usedIndexes){
        var randomTweetIndex = 0;

        while (true) {
            if (usedIndexes.size() == tweets.size()) {
                throw new Exceptions.NotEnoughTweetsException();
            }

            randomTweetIndex = RANDOM.nextInt(tweets.size());

            if(!usedIndexes.contains(randomTweetIndex)){
                usedIndexes.add(randomTweetIndex);
                break;
            }
        }

        return tweets.get(randomTweetIndex);
    }

    private int getTotalSyllables(String[] wordsInTweet) {
        int totalSyllables = 0;
        for (var word : wordsInTweet) {
            var count = SYLLABLE_COUNTER.count(word);
            totalSyllables += count;
        }

        return totalSyllables;
    }

    private HashMap<String, String> getTweetsThatContainRhymes(ArrayList<String> tweets, ArrayList<String> rhymes){
        var applicableTweets = new HashMap<String, String>();
        for (var tweet : tweets) {
            var wordsInTweet = tweet.split("\\s");
            var wordsList = new ArrayList<String>();
            wordsList.addAll(Arrays.asList(wordsInTweet));
            Collections.reverse(wordsList);
            for (var word : wordsInTweet) {
                if(rhymes.contains(word)){
                    applicableTweets.put(word, tweet);
                    break;
                }
            }
        }
        return applicableTweets;
    }

    private ArrayList<String> getRhymingWords(Rhymer rhymer, String poemLine) {
        var lineWords = poemLine.split("\\s");
        var lastWord = lineWords[lineWords.length - 1];
        var results = rhymer.getRhymingWords(lastWord);
        var rhymes = new ArrayList<String>();

        for (var result : results) {
            rhymes.addAll(Arrays.asList(result.strictRhymes));
           // rhymes.addAll(Arrays.asList(result.oneSyllableRhymes));
        }

        return rhymes;
    }

    private String getRhymeFromValue(HashMap<String, String> tweets, String tweet) {
        String key = null;

        for(Map.Entry entry: tweets.entrySet()) {
            if (tweet.equals(entry.getValue())) {
                key = (String) entry.getKey();
                break; //breaking because its one to one map
            }
        }

        return key;
    }

    private String arrayToPoemLine(ArrayList<String> arr){
        var strBuilder = new StringBuilder();
        for (var word : arr) {
            strBuilder.append(word);
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }
}
