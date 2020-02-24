package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.TweetParser;
import poetweet.TwitterData;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TweetParserTest {
    private TweetParser _tweetParser;
    private String _twitterHandle;
    private static final int NUMPARSEDTWEETS = 6;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        _tweetParser = new TweetParser();
        _twitterHandle = "testfile";
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void parseTweets_goodTwitterHandle_RunsSuccessfully() {
        var twitterData = doTheTweetParsing(_twitterHandle);
        var tweets = twitterData.getTweets();
        assertEquals(NUMPARSEDTWEETS, tweets.size());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void parseTweets_badTwitterHandle_RunsUnsuccessfully() {
        var twitterData = doTheTweetParsing("3poienb6");
        assertNull(twitterData);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void parseTweets_emptyTwitterHandle_RunsUnsuccessfully() {
        var twitterData = doTheTweetParsing("");
        assertNull(twitterData);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void parseTweets_nullTwitterHandle_RunsUnsuccessfully() {
        var twitterData = doTheTweetParsing(null);
        assertNull(twitterData);
    }

    private TwitterData doTheTweetParsing(String handle) {
        TwitterData twitterData = null;
        twitterData = _tweetParser.parseTweets(handle);

        return twitterData;
    }
}
