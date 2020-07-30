package poetweet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrintablePoemTest {
    private PrintablePoem _printablePoem;
    private Haiku _haiku;
    private String _handle;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        _haiku = new Haiku();
        _handle = "snak3y_";
        _printablePoem = new PrintablePoem(_haiku, _handle);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getPoemTest() {
        var result = _printablePoem.getPoem();
        assertTrue(_haiku.equals(result));
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getTwitterHandleTest() {
        var result = _printablePoem.getTwitterHandle();
        assertEquals(_handle, result);
    }
}
