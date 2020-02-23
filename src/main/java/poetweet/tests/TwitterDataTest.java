package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.TwitterData;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TwitterDataTest {
    private TwitterData testTwitterData;
    private ArrayList<String> tweets;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        tweets = new ArrayList<>() {
            {
                add("Snoosted and balloosted!");
                add("Do you want to write unit tests with me? Hahaha jk. Unless...");
                add("BBQ sauce and gravy!");
            }
        };

        testTwitterData = new TwitterData("preciousHandle", tweets);
    }

    /**
     * This method tests the getter for the twitter handle.
     */
    @Test
    public void getTwitterHandle() {
        var handle = testTwitterData.getTwitterHandle();
        assertEquals("preciousHandle", handle);
    }

    /**
     * This method tests the getter for the tweets.
     */
    @Test
    public void getTweets() {
        var actualTweet = testTwitterData.getTweets();
        assertEquals(tweets, actualTweet);
    }
}
