package poetweet.tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.FreeFormPoem;

import static org.junit.Assert.assertEquals;

public class FreeFormPoemTest {
    private FreeFormPoem _testFreeFormPoem;
    private static final int EXPECTED_NUMLINES = 4;
    private static final Integer SYLLABLES = 5;
    private static final Integer RHYME = 0;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setup() {
        _testFreeFormPoem = new FreeFormPoem(
                EXPECTED_NUMLINES,
                new Integer[]{SYLLABLES, SYLLABLES, SYLLABLES, SYLLABLES},
                new Integer[]{RHYME, RHYME, RHYME, RHYME});

    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testNumberLines() {
        System.out.println("Testing number of lines");
        var actualNumLines = _testFreeFormPoem.getNumberOfLines();
        assertEquals(EXPECTED_NUMLINES, actualNumLines);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testSyllablesPerLine() {
        var syllables = _testFreeFormPoem.getSyllablesPerLine();
        for (var syllable: syllables) {
            assertEquals(SYLLABLES, syllable);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testRhymingScheme() {
        var rhymes = _testFreeFormPoem.getRhymingScheme();
        for (var rhyme : rhymes) {
            assertEquals(RHYME, rhyme);
        }
    }
}