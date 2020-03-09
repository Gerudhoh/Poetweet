package poetweet;

import ca.rmen.rhymer.Rhymer;
import ca.rmen.rhymer.cmu.CmuDictionary;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RhymingPoemGeneratorTest {
    private static final int EXPECTED_SYLLABLES = 10;
    private static final int EXPECTED_TWEETS = 3;
    private static final String TEST_STRING = "I'm lit rally so angry and so mad";
    private static final String BAD_TEST_STRING = "My fave colour is amazing orange";
    private static final String RHYME_TEST_WORD = "glad"; // Rhymes with "mad"
    private RhymingPoemGenerator _rhymingPoemGenerator;
    private ArrayList<String> _tweets;
    private ArrayList<Integer> _fullUsedIndexes;
    private ArrayList<Integer> _emptyUsedIndexes;
    private HashMap<String, String> _rhymableTweets;
    private Rhymer _rhymer;

    /**
     * Setup before each test.
     * @throws Exception Sometimes the rhymer throws this.
     */
    @Before
    public void setUp() throws Exception {
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        _rhymingPoemGenerator = new RhymingPoemGenerator(twitterScraper, tweetParser);
        _rhymer =  CmuDictionary.loadRhymer();
        _emptyUsedIndexes = new ArrayList<>();
        _fullUsedIndexes = new ArrayList<>() { {
            add(0);
            add(1);
            add(2);
            add(2);
            add(1);
            add(0);
        } };
        _tweets = new ArrayList<>() { {
            add(TEST_STRING);
            add("Booooohooooo I'm crying like 18 billion tears I'm so very sad");
            add(":) Life is just so #blessed and I'm so very glad");
            add("I just ate a sugar pie and honestly? Best dessert I've ever had. Hands down.");
            add("If you don't buy BBQ sauce and gravy I will make you rue");
            add("Today is my birthday and I'm working on OO! Woohoo!");
            add("I'm HUNGRY I want to make a delicious winter stew.");
            add("Today the sky is such a pale and beautiful blue I'm just :) :)");
        } };
        _rhymableTweets = new HashMap<>() { { put("mad", "I'm lit rally so angry and so mad"); } };
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTotalSyllables_runsSuccessfully_returnsExpectedResult() {
        var tweetWords = TEST_STRING.split("\\s");
        var result = _rhymingPoemGenerator.getTotalSyllables(tweetWords);
        assertEquals(EXPECTED_SYLLABLES, result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRandomTweet_runsSuccessfully_returnsATweet() {
        var result = _rhymingPoemGenerator.getRandomTweet(_tweets, _emptyUsedIndexes);
        assertEquals(1, _emptyUsedIndexes.size());
        assertTrue(_tweets.contains(result));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRandomTweet_runsUnsuccessfully_ThrowsNotEnoughTweetsError() {
        try {
            _rhymingPoemGenerator.getRandomTweet(_tweets, _fullUsedIndexes);
        } catch (Exception e) {
            assertTrue(e instanceof Exceptions.NotEnoughTweetsException);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTweetsThatContainRhymes_runsSuccessfully_returnsExpectedResult() {
        var rhymes = _rhymingPoemGenerator.getRhymingWords(_rhymer, TEST_STRING);
        var result = _rhymingPoemGenerator.getTweetsThatContainRhymes(_tweets, rhymes);
        assertEquals(EXPECTED_TWEETS, result.size());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTweetsThatContainRhymes_BadRhymingWord_returnsExpectedResult() {
        var rhymes = _rhymingPoemGenerator.getRhymingWords(_rhymer, BAD_TEST_STRING);
        var result = _rhymingPoemGenerator.getTweetsThatContainRhymes(_tweets, rhymes);
        assertEquals(0, result.size());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRhymingWords_runsSuccessfully_returnsExpectedResult() {
        var result = _rhymingPoemGenerator.getRhymingWords(_rhymer, TEST_STRING);
        assertTrue(result.contains(RHYME_TEST_WORD));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRhymingWords_runsSuccessfully_returnsEmptyList() {
        var result = _rhymingPoemGenerator.getRhymingWords(_rhymer, BAD_TEST_STRING);
        assertTrue(result.size() == 0);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getKeyFromValue() {
        var key = _rhymingPoemGenerator.getKeyFromValue(_rhymableTweets, TEST_STRING);
        assertEquals("mad", key);
    }
}
