package tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.PoemSaver;
import poetweet.Returnables;
import poetweet.SavePoemsMenuOption;

import static org.junit.Assert.assertTrue;

public class SavePoemsMenuOptionTest {
    private SavePoemsMenuOption _savePoemsMenuOption;
    private static final String BADINPUT = "gravy";
    private static final String GOODINPUT = "all";

    @Before
    public void setUp() {
        _savePoemsMenuOption = new SavePoemsMenuOption();
    }

    @Test
    public void runMenuOption_correctUSerInput_runsSuccessfully() {
        var result = _savePoemsMenuOption.runMenuOption(GOODINPUT);
        assertTrue(result instanceof PoemSaver);
    }

    @Test
    public void runMenuOption_incorrectUSerInput_runsUnsuccessfully() {
        var result = _savePoemsMenuOption.runMenuOption(BADINPUT);
        assertTrue(result instanceof Returnables.Faiure);
    }
}