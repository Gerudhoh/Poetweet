package poetweet;

import java.io.File;
import java.util.Arrays;

public final class DirectoryClearer {

    /**
     * Removes all files from a specified directory.
     * @param directoryPath The path to the directory we want to clear.
     */
    public void clearDirectory(String directoryPath) {
        Arrays.stream(new File(directoryPath).listFiles())
                .forEach(File::delete);
    }

}
