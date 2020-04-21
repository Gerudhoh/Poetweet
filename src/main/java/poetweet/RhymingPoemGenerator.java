package poetweet;

import ca.rmen.rhymer.Rhymer;
import ca.rmen.rhymer.cmu.CmuDictionary;
import eu.crydee.syllablecounter.SyllableCounter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class RhymingPoemGenerator extends PoemGenerator {
    private static final SyllableCounter SYLLABLE_COUNTER = new SyllableCounter();
    private static final int MINIMUM_APPLICABLE_TWEETS = 8;
    private static final int MINIMUM_RHYMES = 10;

    /**
     * Constructor for the PoemGenerator.
     * @param twitterScraper TwitterScraper
     * @param tweetParser TweetParser
     */
    public RhymingPoemGenerator(TwitterScraper twitterScraper, TweetParser tweetParser) {
        super(twitterScraper, tweetParser);
    }

    @Override
    protected boolean generatePoemFromTwitterData(Poem poem, TwitterData twitterData) {
        Rhymer rhymer;
        var usedIndexes = new ArrayList<Integer>();
        var tweets = twitterData.getTweets();
        var poemLines = poem.getPoem();
        var allRhymes = new HashMap<Integer, HashMap<String, String>>();

        try {
            rhymer =  CmuDictionary.loadRhymer();
        } catch (IOException e) {
            throw new Exceptions.PoetweetIOException(e.getMessage());
        }

        var i = 0;
        while (i < poem.getNumberOfLines()) {
            var generatedLine = "";
            var tweet = getRandomTweet(tweets, usedIndexes);
            var line = poemLines.get(i);
            var lineRhyme = line.getRhyme();

            if(lineRhyme < 0){
                // This is for refrains in villanelles
                var index = lineRhyme == -1
                        ? 0  // Where to find the first refrain
                        : 2; // Where to find the second
                generatedLine = poemLines.get(index).getText();
            }else{
                generatedLine = allRhymes.containsKey(lineRhyme)
                        ? generateRhymingLine(line, allRhymes.get(lineRhyme))
                        : generatePoemLine(line, tweet);

                if (generatedLine.isEmpty()) {
                    continue;
                }

                if (!allRhymes.containsKey(lineRhyme)) {
                    var rhymes = getRhymingWords(rhymer, generatedLine);
                    if (rhymes.size() <= MINIMUM_RHYMES) {
                        continue;
                    }
                    var applicableTweets = getTweetsThatContainRhymes(tweets, rhymes);

                    if (applicableTweets.size() < MINIMUM_APPLICABLE_TWEETS) {
                        continue;
                    }
                    allRhymes.put(lineRhyme, applicableTweets);
                }
            }

            poemLines.get(i).setText(generatedLine);
            i++;
        }

        return true;
    }

    protected HashMap<String, String> getTweetsThatContainRhymes(ArrayList<String> tweets, ArrayList<String> rhymes) {
        var applicableTweets = new HashMap<String, String>();
        for (var tweet : tweets) {
            var wordsInTweet = tweet.split("[.!;,? ]");
            var wordsList = new ArrayList<String>();
            wordsList.addAll(Arrays.asList(wordsInTweet));
            Collections.reverse(wordsList);
            for (var word : wordsInTweet) {
                if (rhymes.contains(word)) {
                    applicableTweets.put(word, tweet);
                    break;
                }
            }
        }
        return applicableTweets;
    }

    protected ArrayList<String> getRhymingWords(Rhymer rhymer, String poemLine) {
        var lineWords = poemLine.split("[.?! ]");
        var lastWord = lineWords[lineWords.length - 1];
        var results = rhymer.getRhymingWords(lastWord);
        var rhymes = new ArrayList<String>();

        for (var result : results) {
            rhymes.addAll(Arrays.asList(result.strictRhymes));
        }

        return rhymes;
    }

    protected String getKeyFromValue(HashMap<String, String> tweets, String tweet) {
        String key = null;

        for (Map.Entry entry: tweets.entrySet()) {
            if (tweet.equals(entry.getValue())) {
                key = (String) entry.getKey();
                break; // Breaking because it's a 1-to-1 map
            }
        }

        return key;
    }

    private String generateRhymingLine(PoemLine poemLine, HashMap<String, String> rhymables) {
        var usedIndexes = new ArrayList<Integer>();
        var rhymableTweets = new ArrayList<>(rhymables.values());
        var tweet = getRandomTweet(rhymableTweets, usedIndexes);
        var rhyme = getKeyFromValue(rhymables, tweet);

        var line = generateLineFromRhyme(poemLine, tweet, rhyme);

        var key = getKeyFromValue(rhymables, tweet);
        rhymables.remove(key);

        return line;
    }

    private String generateLineFromRhyme(PoemLine poemLine, String tweet, String rhyme) {
        var wordsInTweet = tweet.split("\\s");
        var wordsForPoemLine = new ArrayList<String>();
        var syllablesRemaining = poemLine.getNumSyllables();
        var syllablesInTweet = getTotalSyllables(wordsInTweet);

        if (syllablesInTweet < syllablesRemaining) {
            return "";
        }

        var index = Arrays.asList(wordsInTweet).lastIndexOf(rhyme);
        var wordsForLine = Arrays.copyOfRange(wordsInTweet, 0, index + 1);

        for (int i = wordsForLine.length - 1; i >= 0; i--) {
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

        return syllablesRemaining == 0
                ? backwardsWordsArrayToPoemLine(wordsForPoemLine)
                : "";
    }

    private String backwardsWordsArrayToPoemLine(ArrayList<String> wordsForPoemLine) {
        var strBuilder = new StringBuilder();

        Collections.reverse(wordsForPoemLine);

        for (var word : wordsForPoemLine) {
            strBuilder.append(word);
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }
}
