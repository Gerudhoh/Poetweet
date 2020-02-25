package tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.FreeFormPoem;
import poetweet.FreeFormPoemGenerationOption;
import poetweet.PoemTypes;
import poetweet.ReturnablePoem;
import poetweet.Returnables;
import poetweet.TweetParser;
import poetweet.TwitterScraper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FreeFormPoemGenerationOptionTest {
    private FreeFormPoemGenerationOption _freeformPoemGenerationOption;
    private static final String BADINPUT = "ProBirdRights";
    private static final String GOODINPUT = "ProBirdRights:6:6";
    private  static final int EXPECTED = 6;

    @Before
    public void setUp() {
        var freeform = new FreeFormPoem(1, new Integer[]{1}, new Integer[]{0});
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        _freeformPoemGenerationOption = new FreeFormPoemGenerationOption(freeform, twitterScraper, tweetParser);
    }

    @Test
    public void generatePoem() {
        var result = _freeformPoemGenerationOption.runMenuOption(GOODINPUT);
        assertTrue(result instanceof ReturnablePoem);
        var returnablePoem = (ReturnablePoem) result;
        var poem = returnablePoem.getPoem();

        assertEquals(EXPECTED, poem.getNumberOfLines());
        assertFalse(poem.toString().isEmpty());
    }

    @Test
    public void runMenuOption_correctUserInput_runsSuccessfully() {
        var result = _freeformPoemGenerationOption.runMenuOption(GOODINPUT);
        assertTrue(result instanceof ReturnablePoem);
        var poem = (ReturnablePoem) result;
        assertEquals(PoemTypes.FREEFORM, poem.getPoemType());
    }

    @Test
    public void runMenuOption_incorrectUserInput_runsUnsuccessfully() {
        var result = _freeformPoemGenerationOption.runMenuOption(BADINPUT);
        assertTrue(result instanceof Returnables.Faiure);
    }
}