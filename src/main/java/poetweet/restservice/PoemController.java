package poetweet.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poetweet.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class PoemController {
    private final PoemGeneratorFactory _poemGeneratorFactory = new PoemGeneratorFactory();
    private final Haiku _haiku = new Haiku();

    /**
     * Generates a poem from a twitter id.
     * @param twitterId twitter handle
     * @return poem
     */
    @GetMapping("/poem")
    public ArrayList<PoemLine> poem(@RequestParam(value = "twitterhandle", defaultValue = "dog_feelings") String twitterId) {
        var success = _poemGeneratorFactory.buildNonRhymingPoemGenerator().generatePoem(_haiku, twitterId);

        return _haiku.getPoem();
    }
}
