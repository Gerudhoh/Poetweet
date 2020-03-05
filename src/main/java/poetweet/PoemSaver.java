package poetweet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class PoemSaver {

    /**
     * Save a list of poems.
     * @param printablePoems the poems we're going to save.
     */
    public void savePoems(ArrayList<PrintablePoem> printablePoems) {
        var i = 1;
        for (var returnablePoem : printablePoems) {
            var poemContent = returnablePoem.getPoem().toString();
            var poemType = returnablePoem.getPoemType();
            var poemName = poemType.getType() + "_" + returnablePoem.getTwitterHandle() + i++ + ".txt";

            try {
                Files.write(Paths.get("./poems/" + poemName), poemContent.getBytes());
            } catch (IOException ioe) {
                throw new Exceptions.PoetweetIOException(ioe.getMessage());
            }

        }
    }
}
