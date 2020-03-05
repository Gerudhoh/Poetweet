package poetweet;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HaikuGenerationOptionTest {
    private HaikuGenerationOption _haikuGenerationOption;
    private ArrayList<PrintablePoem> _poems;
    private static final String  GOODINPUT = "ProBirdRights";
    private static final String BADINPUT1 = "ProBirdRights:6:6";
    private static final String BADINPUT2 = "";

    /**
     * This sets up all things for the tests.
     */
    @Before
    public void setUp() {
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        _poems = new ArrayList<>();
        _haikuGenerationOption = new HaikuGenerationOption(new Haiku(), _poems, twitterScraper, tweetParser);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_correctUserInput_runsSuccessfully() {
        var result = _haikuGenerationOption.runMenuOption(GOODINPUT);
        assertTrue(result == MenuOptionResult.VALID_OPTION_SUCCESS);
        var poem = _poems.get(0);
        assertEquals(PoemTypes.HAIKU, poem.getPoemType());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully() {
        try {
            _haikuGenerationOption.runMenuOption(BADINPUT2);
        } catch (Exceptions.PoetweetIOException pioe) {
            assertTrue(pioe.getMessage().length() > 0);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully_throwsInvalidPathException() {
        try {
            _haikuGenerationOption.runMenuOption(BADINPUT1);
        } catch (Exceptions.PoetweetPathException ppe) {
            assertEquals("Illegal char <:> at index 25: ./resources/ProBirdRights:6:6_tweets.csv",
                    ppe.getMessage());
        } catch (Exceptions.PoetweetIOException pioe) {
            assertTrue(pioe.getMessage().length() > 0);
        }
    }
}
