package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.MenuOptionsFactory;
import poetweet.QuitOption;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MenuOptionsFactoryTest {
    private MenuOptionsFactory testMenuOptionsFactory;

    public MenuOptionsFactoryTest(){}

    @Before
    public void setup() {
        testMenuOptionsFactory = new MenuOptionsFactory();
    }

    @Test
    public void testCreatePoetweetMenuOptions_CreatesMenuCorrectly(){
        var menu = testMenuOptionsFactory.createPoetweetMenuOptions();
        var length = menu.size();
        assertEquals(3, length);
        assertThat(menu.get(length-1), instanceOf(QuitOption.class));
    }

    @Test
    public void testCreatePoetweetAdminMenuOptions_CreatesMenuCorrectly(){
        var menu = testMenuOptionsFactory.createPoetweetAdminMenuOptions();
        var length = menu.size();
        assertEquals(2, length);
        assertThat(menu.get(length-1), instanceOf(QuitOption.class));
    }

}