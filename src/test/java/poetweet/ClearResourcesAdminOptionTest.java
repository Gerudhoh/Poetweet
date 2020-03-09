package poetweet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClearResourcesAdminOptionTest {
    private ClearResourcesAdminOption _clearResourcesAdminOption;
    private static final String  GOODINPUT = "yes";
    private static final String BADINPUT = "BBQ sauce & gravy";

    /**
     * Sets up all the tests.
     */
    @Before
    public void setUp() {
        var directoryClearer = new DirectoryClearer();
        _clearResourcesAdminOption = new ClearResourcesAdminOption(directoryClearer);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_validInput_RunsSuccessfully() {
        var result = _clearResourcesAdminOption.runMenuOption(GOODINPUT);
        assertEquals(MenuOptionResult.VALID_OPTION_SUCCESS, result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void runMenuOption_invalidInput_RunsUnsuccessfully() {
        var result = _clearResourcesAdminOption.runMenuOption(BADINPUT);
        assertEquals(MenuOptionResult.VALID_OPTION_FAILURE, result);
    }
}
