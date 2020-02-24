package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.Haiku;
import poetweet.PoemTypes;
import poetweet.ReturnablePoem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReturnablePoemTest {
    private ReturnablePoem returnablePoem;
    private Haiku haiku;
    private String handle;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        haiku = new Haiku();
        handle = "snak3y_";
        returnablePoem = new ReturnablePoem(haiku, PoemTypes.HAIKU, handle);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getPoemTest() {
        var result = returnablePoem.getPoem();
        assertTrue(haiku.equals(result));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getPoemTypeTest() {
        var result = returnablePoem.getPoemType();
        assertEquals(PoemTypes.HAIKU, result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTwitterHandleTest() {
        var result = returnablePoem.getTwitterHandle();
        assertEquals(handle, result);
    }
}
