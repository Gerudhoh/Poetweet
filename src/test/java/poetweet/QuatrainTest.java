package poetweet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuatrainTest {
    private Quatrain _quatrain;
    private static final int EXPECTED_NUMLINES = 4;
    private static final Integer SYLLABLES = 10;
    private static final Integer A = 1;
    private static final Integer B = 2;

    /**
     * This sets up all the tests.
     */
    @Before
    public void setup() {
        _quatrain = new Quatrain();
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testNumberLines() {
        System.out.println("Testing number of lines");
        var actualNumLines = _quatrain.getNumberOfLines();
        assertEquals(EXPECTED_NUMLINES, actualNumLines);
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testSyllablesPerLine() {
        var syllables = _quatrain.getSyllablesPerLine();
        for (var syllable : syllables) {
            assertEquals(SYLLABLES, syllable);
        }
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void testRhymingScheme() {
        var rhymes = _quatrain.getRhymingScheme();
        for (int i = 0; i < EXPECTED_NUMLINES; i++) {
            if (i % 2 == 0) {
                assertEquals(A, rhymes.get(i));
            } else {
                assertEquals(B, rhymes.get(i));
            }
        }
    }
}
