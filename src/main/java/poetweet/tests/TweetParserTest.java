package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.Exceptions;
import poetweet.TweetParser;
import poetweet.TwitterData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        try{
            doTheTweetParsing("");
        }catch (Exceptions.PoetweetIOException pioe){
            assertTrue(pioe.getMessage().length() > 0);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void parseTweets_emptyTwitterHandle_RunsUnsuccessfully() {
        try{
            doTheTweetParsing("");
        }catch (Exceptions.PoetweetIOException pioe){
            assertTrue(pioe.getMessage().length() > 0);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void parseTweets_nullTwitterHandle_RunsUnsuccessfully() {
        try{
            doTheTweetParsing(null);
        }catch (Exceptions.PoetweetIOException pioe){
            assertTrue(pioe.getMessage().length() > 0);
        }
    }

    private TwitterData doTheTweetParsing(String handle) {
        TwitterData twitterData = _tweetParser.parseTweets(handle);

        return twitterData;
    }
}
