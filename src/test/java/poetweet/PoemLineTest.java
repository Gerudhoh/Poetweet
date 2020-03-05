package poetweet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PoemLineTest {
    private PoemLine _testLine1;
    private PoemLine _testLine2;
    private String _testString;
    private String _testString2;
    private static final int LINETEST = 5;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        _testString = "To be or not to be";
        _testString2 = "The quality of mercy is not strained";
        _testLine1 = new PoemLine(LINETEST, 0);
        _testLine2 = new PoemLine(LINETEST, 0, _testString2);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getNumSyllables() {
        var syllables = _testLine1.getNumSyllables();
        assertEquals(LINETEST, syllables);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getRhyme() {
        var rhyme = _testLine1.getRhyme();
        assertEquals(0, rhyme);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void setLine() {
        _testLine1.setText("To be or not to be");
        var line = _testLine1.getText();
        assertEquals(_testString, line);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void getLine() {
        var line = _testLine2.getText();
        assertEquals(_testString2, line);
    }
}
