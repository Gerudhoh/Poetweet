package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.TwitterScraper;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TwitterScraperTest {
    private TwitterScraper twitterScraper;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        twitterScraper = new TwitterScraper();
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void pullTweetsFromTwitterHandle_GoodTwitterHandle_RunsSuccessfully() {
        var result = twitterScraper.pullTweetsFromTwitterHandle("dog_feelings");
        assertTrue(result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void pullTweetsFromTwitterHandle_BadTwitterHandle_RunsUnsuccessfully() {
        var result = twitterScraper.pullTweetsFromTwitterHandle("3poienb6");
        assertFalse(result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void pullTweetsFromTwitterHandle_EmptyTwitterHandle_RunsUnsuccessfully() {
        var result = twitterScraper.pullTweetsFromTwitterHandle("");
        assertFalse(result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void pullTweetsFromTwitterHandle_NullTwitterHandle_RunsUnsuccessfully() {
        var result = twitterScraper.pullTweetsFromTwitterHandle(null);
        assertFalse(result);
    }
}
