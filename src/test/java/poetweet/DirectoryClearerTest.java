package tests;

import org.junit.Before;
import org.junit.Test;
import poetweet.DirectoryClearer;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class DirectoryClearerTest {
    private DirectoryClearer _directoryClearer;
    private static final String PATH = "./resources";

    /**
     * This sets up all the tests.
     */
    @Before
    public void setUp() {
        _directoryClearer = new DirectoryClearer();
    }

    /**
     * This is a test. Read the method name to see what it tests.
     */
    @Test
    public void clearDirectory() {
        var files = new File(PATH).listFiles();
        var numFiles = files.length;
        assertTrue(numFiles > 0);
        _directoryClearer.clearDirectory(PATH);

        files = new File(PATH).listFiles();
        numFiles = files.length;
        assertTrue(numFiles == 0);
    }
}
