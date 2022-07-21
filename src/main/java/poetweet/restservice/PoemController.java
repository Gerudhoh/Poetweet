package poetweet.restservice;

import org.springframework.web.bind.annotation.*;
import poetweet.Haiku;
import poetweet.PoemGeneratorFactory;
import poetweet.PoemLine;

import java.util.ArrayList;
import java.util.Map;

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
    @PostMapping("/poem/haiku")
    public ArrayList<PoemLine> poem(@RequestBody Map<String, String> body) {
        var twitterId = body.get("twitterId");
        var success = _poemGeneratorFactory.buildNonRhymingPoemGenerator().generatePoem(_haiku, twitterId);

        return _haiku.getPoem();
    }
}
