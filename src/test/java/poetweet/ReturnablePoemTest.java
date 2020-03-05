package tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.Haiku;
import poetweet.PoemTypes;
import poetweet.ReturnablePoem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReturnablePoemTest {
    private ReturnablePoem _returnablePoem;
    private Haiku _haiku;
    private String _handle;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        _haiku = new Haiku();
        _handle = "snak3y_";
        _returnablePoem = new ReturnablePoem(_haiku, PoemTypes.HAIKU, _handle);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getPoemTest() {
        var result = _returnablePoem.getPoem();
        assertTrue(_haiku.equals(result));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getPoemTypeTest() {
        var result = _returnablePoem.getPoemType();
        assertEquals(PoemTypes.HAIKU, result);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTwitterHandleTest() {
        var result = _returnablePoem.getTwitterHandle();
        assertEquals(_handle, result);
    }
}
