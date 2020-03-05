package poetweet;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FreeFormPoemGenerationOptionTest {
    private FreeFormPoemGenerationOption _freeformPoemGenerationOption;
    private ArrayList<PrintablePoem> _poems;
    private static final String BADINPUT = "ProBirdRights";
    private static final String GOODINPUT = "ProBirdRights:6:6";
    private  static final int EXPECTED = 6;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        var freeform = new FreeFormPoem(1, new Integer[]{1}, new Integer[]{0});
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        _poems = new ArrayList<>();
        _freeformPoemGenerationOption = new FreeFormPoemGenerationOption(freeform, _poems, twitterScraper, tweetParser);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void generatePoem() {
        var result = _freeformPoemGenerationOption.runMenuOption(GOODINPUT);
        assertEquals(MenuOptionResult.VALID_OPTION_SUCCESS, result);
        var poem = _poems.get(0).getPoem();
        assertEquals(EXPECTED, poem.getNumberOfLines());
        assertFalse(poem.toString().isEmpty());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_correctUserInput_runsSuccessfully() {
        var result = _freeformPoemGenerationOption.runMenuOption(GOODINPUT);
        assertEquals(MenuOptionResult.VALID_OPTION_SUCCESS, result);
        var poem = _poems.get(0);
        assertEquals(PoemTypes.FREEFORM, poem.getPoemType());
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully() {
        var result = _freeformPoemGenerationOption.runMenuOption(BADINPUT);
        assertTrue(result == MenuOptionResult.VALID_OPTION_FAILURE);
    }
}
