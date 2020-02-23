package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.PoemLine;

import static org.junit.Assert.assertEquals;

public class PoemLineTest {
    private PoemLine testLine;
    private String testString;
    private static final int LINETEST = 5;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        testLine = new PoemLine(LINETEST, 0);
        testString = "To be or not to be";
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getNumSyllables() {
        var syllables = testLine.getNumSyllables();
        assertEquals(LINETEST, syllables);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRhyme() {
        var rhyme = testLine.getRhyme();
        assertEquals(0, rhyme);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void setLine_getLine() {
        testLine.setLine("To be or not to be");
        var line = testLine.getLine();
        assertEquals(testString, line);
    }
}
