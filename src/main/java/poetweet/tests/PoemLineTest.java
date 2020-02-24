package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.PoemLine;

import static org.junit.Assert.assertEquals;

public class PoemLineTest {
    private PoemLine testLine1;
    private PoemLine testLine2;
    private String testString;
    private String testString2;
    private static final int LINETEST = 5;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        testString = "To be or not to be";
        testString2 = "The quality of mercy is not strained";
        testLine1 = new PoemLine(LINETEST, 0);
        testLine2 = new PoemLine(LINETEST, 0, testString2);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getNumSyllables() {
        var syllables = testLine1.getNumSyllables();
        assertEquals(LINETEST, syllables);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRhyme() {
        var rhyme = testLine1.getRhyme();
        assertEquals(0, rhyme);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void setLine() {
        testLine1.setText("To be or not to be");
        var line = testLine1.getText();
        assertEquals(testString, line);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getLine() {
        var line = testLine2.getText();
        assertEquals(testString2, line);
    }
}
