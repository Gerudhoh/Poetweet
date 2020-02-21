package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.PoemLine;

import static org.junit.Assert.assertEquals;

public class PoemLineTest {
    private PoemLine testLine;
    private String testString;

    @Before
    public void setUp(){
        testLine = new PoemLine(5,0);
        testString = "To be or not to be";
    }

    @Test
    public void getNumSyllables() {
        var syllables = testLine.getNumSyllables();
        assertEquals(5, syllables);
    }

    @Test
    public void getRhyme() {
        var rhyme = testLine.getRhyme();
        assertEquals(0, rhyme);
    }

    @Test
    public void setLine_getLine() {
        testLine.setLine("To be or not to be");
        var line = testLine.getLine();
        assertEquals(testString, line);
    }
}