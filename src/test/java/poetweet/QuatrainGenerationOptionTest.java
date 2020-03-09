package poetweet;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuatrainGenerationOptionTest {
    private QuatrainGenerationOption _quatrainGenerationOption;
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
        var poemGenerator = new RhymingPoemGenerator(twitterScraper, tweetParser);
        _poems = new ArrayList<>();
        _quatrainGenerationOption = new QuatrainGenerationOption(new Quatrain(), _poems, poemGenerator);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_correctUserInput_runsSuccessfully() {
        var result = _quatrainGenerationOption.runMenuOption(GOODINPUT);
        assertTrue(result == MenuOptionResult.VALID_OPTION_SUCCESS);
        var poem = _poems.get(0);
        assertEquals(PoemTypes.QUATRAIN, poem.getPoemType());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully() {
        try {
            _quatrainGenerationOption.runMenuOption(BADINPUT2);
        } catch (Exception e) {
            assertTrue(e instanceof Exceptions.PoetweetIOException);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully_throwsInvalidPathException() {
        try {
            _quatrainGenerationOption.runMenuOption(BADINPUT1);
        } catch (Exceptions.PoetweetPathException ppe) {
            assertEquals("Illegal char <:> at index 25: ./resources/ProBirdRights:6:6_tweets.csv",
                    ppe.getMessage());
        } catch (Exception e) {
            assertTrue(e instanceof Exceptions.PoetweetIOException);
        }
    }
}
