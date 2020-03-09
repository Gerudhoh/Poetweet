package poetweet;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NonRhymingPoemGeneratorTest {
    private static final int EXPECTED_SYLLABLES = 10;
    private NonRhymingPoemGenerator _nonRhymingPoemGenerator;
    private ArrayList<String> _tweets;
    private ArrayList<Integer> _fullUsedIndexes;
    private ArrayList<Integer> _emptyUsedIndexes;

    /**
     * Setup all the variables for testing.
     */
    @Before
    public void setUp() {
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        _nonRhymingPoemGenerator = new NonRhymingPoemGenerator(twitterScraper, tweetParser);
        _emptyUsedIndexes = new ArrayList<>();
        _fullUsedIndexes = new ArrayList<>() { {
            add(0);
            add(1);
            add(2);
            add(2);
            add(1);
        } };
        _tweets = new ArrayList<>() { {
           add("BBQ Sauce and Gravy");
           add("There are 10 syllables in this tweet :)");
           add("Booooohooooo I'm crying like 18 billion tears I'm so very sad");
           add("AHHHH I'm lit rally so angry and I'm so very mad");
           add(":) Life is just so #blessed and I'm so very glad");
        } };
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTotalSyllables_runsSuccessfully_returnsExpectedResult() {
        var tweet = "There are 10 syllables in this tweet :)";
        var tweetWords = tweet.split("\\s");
        var result = _nonRhymingPoemGenerator.getTotalSyllables(tweetWords);
        assertEquals(EXPECTED_SYLLABLES, result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRandomTweet_runsSuccessfully_returnsATweet() {
        var result = _nonRhymingPoemGenerator.getRandomTweet(_tweets, _emptyUsedIndexes);
        assertEquals(1, _emptyUsedIndexes.size());
        assertTrue(_tweets.contains(result));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRandomTweet_runsUnsuccessfully_ThrowsNotEnoughTweetsError() {
        try {
            _nonRhymingPoemGenerator.getRandomTweet(_tweets, _fullUsedIndexes);
        } catch (Exception e) {
            assertTrue(e instanceof Exceptions.NotEnoughTweetsException);
        }
    }
}
