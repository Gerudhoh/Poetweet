package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.TwitterData;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TwitterDataTest {
    private TwitterData testTwitterData;
    private ArrayList<String> tweets;

    @Before
    public void setUp() throws Exception {
        tweets = new ArrayList<>(){
            {
                add("Snoosted and balloosted!");
                add("Do you want to write unit tests with me? Hahaha jk. Unless...");
                add("BBQ sauce and gravy!");
            }
        };

        testTwitterData = new TwitterData("preciousHandle", tweets);
    }

    @Test
    public void getTwitterHandle() {
        var handle = testTwitterData.getTwitterHandle();
        assertEquals("preciousHandle", handle);
    }

    @Test
    public void getTweets() {
        var actualTweet = testTwitterData.getTweets();
        assertEquals(tweets, actualTweet);
    }
}