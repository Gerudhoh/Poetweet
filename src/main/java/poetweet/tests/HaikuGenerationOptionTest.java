package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.Exceptions;
import poetweet.Haiku;
import poetweet.HaikuGenerationOption;
import poetweet.PoemTypes;
import poetweet.ReturnablePoem;
import poetweet.TweetParser;
import poetweet.TwitterScraper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HaikuGenerationOptionTest {
    private HaikuGenerationOption _haikuGenerationOption;
    private static final String  GOODINPUT = "ProBirdRights";
    private static final String BADINPUT1 = "ProBirdRights:6:6";
    private static final String BADINPUT2 = "";

    @Before
    public void setUp() {
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        _haikuGenerationOption = new HaikuGenerationOption(new Haiku(), twitterScraper, tweetParser);
    }

    @Test
    public void runMenuOption_correctUserInput_runsSuccessfully() {
        var result = _haikuGenerationOption.runMenuOption(GOODINPUT);
        assertTrue(result instanceof ReturnablePoem);
        var poem = (ReturnablePoem) result;
        assertEquals(PoemTypes.HAIKU, poem.getPoemType());
    }

    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully() {
        try{
            _haikuGenerationOption.runMenuOption(BADINPUT2);
        } catch (Exceptions.PoetweetIOException pioe ) {
            assertTrue(pioe.getMessage().length() > 0);
        }
    }

    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully_throwsInvalidPathException() {
        try{
            _haikuGenerationOption.runMenuOption(BADINPUT1);
        } catch (Exceptions.PoetweetPathException ppe ) {
            assertEquals("Illegal char <:> at index 25: ./resources/ProBirdRights:6:6_tweets.csv",
                    ppe.getMessage());
        } catch (Exceptions.PoetweetIOException pioe ) {
            assertTrue(pioe.getMessage().length() > 0);
        }
    }
}