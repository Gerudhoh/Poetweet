package poetweet;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SavePoemsMenuOptionTest {
    private SavePoemsMenuOption _savePoemsMenuOption;
    private static final String BADINPUT = "gravy";
    private static final String GOODINPUT = "all";

    /**
     * This sets up all the things for tests.
     */
    @Before
    public void setUp() {
        var poems = new ArrayList<PrintablePoem>();
        var poemSaver = new PoemSaver();
        _savePoemsMenuOption = new SavePoemsMenuOption(poems, poemSaver);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_correctUSerInput_runsSuccessfully() {
        var result = _savePoemsMenuOption.runMenuOption(GOODINPUT);
        assertTrue(result == MenuOptionResult.VALID_OPTION_SUCCESS);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_incorrectUSerInput_runsUnsuccessfully() {
        var result = _savePoemsMenuOption.runMenuOption(BADINPUT);
        assertTrue(result == MenuOptionResult.VALID_OPTION_FAILURE);
    }
}
