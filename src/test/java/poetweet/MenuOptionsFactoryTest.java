package poetweet;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MenuOptionsFactoryTest {
    private MenuOptionsFactory _testMenuOptionsFactory;
    private static final int MENUITEMS = 6;
    private static final int ADMINMENUITEMS = 3;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setup() {
        _testMenuOptionsFactory = new MenuOptionsFactory();
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testCreatePoetweetMenuOptions_CreatesMenuCorrectly() {
        var menu = _testMenuOptionsFactory.createPoetweetMenuOptions();
        var length = menu.size();
        assertEquals(MENUITEMS, length);
        assertThat(menu.get(length - 1), instanceOf(QuitOption.class));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testCreatePoetweetAdminMenuOptions_CreatesMenuCorrectly() {
        var menu = _testMenuOptionsFactory.createPoetweetAdminMenuOptions();
        var length = menu.size();
        assertEquals(ADMINMENUITEMS, length);
        assertThat(menu.get(length - 1), instanceOf(QuitOption.class));
    }

}
