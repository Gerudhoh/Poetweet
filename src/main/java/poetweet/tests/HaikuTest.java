package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.Haiku;

import static org.junit.Assert.assertEquals;

public class HaikuTest {
    private Haiku testHaiku;
    private static final int EXPECTED_NUMLINES = 3;
    private static final Integer OUTER_LINE_SYLLABLES = 5;
    private static final Integer MIDDLE_LINE_SYLLABLES = 7;
    private static final Integer RHYME = 0;

    public HaikuTest() {
    }

    @Before
    public void setup() {
        testHaiku = new Haiku();

    }

    @Test
    public void testNumberLines() {
        System.out.println("Testing number of lines");
        var actualNumLines = testHaiku.getNumberOfLines();
        assertEquals(EXPECTED_NUMLINES, actualNumLines);
    }

    @Test
    public void testSyllablesPerLine(){
        var syllables = testHaiku.getSyllablesPerLine();
        assertEquals(OUTER_LINE_SYLLABLES, syllables.get(0));
        assertEquals(MIDDLE_LINE_SYLLABLES, syllables.get(1));
        assertEquals(OUTER_LINE_SYLLABLES, syllables.get(2));
    }

    @Test
    public void testRhymingScheme(){
        var rhymes = testHaiku.getRhymingScheme();
        for (var rhyme : rhymes) {
            assertEquals(RHYME, rhyme);
        }
    }
}