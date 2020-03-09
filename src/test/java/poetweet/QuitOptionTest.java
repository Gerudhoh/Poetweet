package poetweet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuitOptionTest {
    private QuitOption _quitOption;
    private static final String  GOODINPUT = "yes";
    private static final String BADINPUT = "BBQ sauce & gravy";

    /**
     * Sets up all the tests.
     */
    @Before
    public void setUp() {
        _quitOption = new QuitOption();
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_validInput_RunsSuccessfully() {
        try {
            _quitOption.runMenuOption(GOODINPUT);
        } catch (Exception e) {
            assertTrue(e instanceof Exceptions.QuitException);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_invalidInput_RunsUnsuccessfully() {
        var result = _quitOption.runMenuOption(BADINPUT);
        assertEquals(MenuOptionResult.VALID_OPTION_FAILURE, result);
    }
}
