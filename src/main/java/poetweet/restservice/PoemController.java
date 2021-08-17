package poetweet.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poetweet.Haiku;
import poetweet.PoemGeneratorFactory;
import poetweet.PrintablePoem;

@RestController
public class PoemController {
    private final PoemGeneratorFactory poemGeneratorFactory = new PoemGeneratorFactory();
    private final Haiku haiku = new Haiku();

    /**
     *
     * @param twitterId
     * @return
     */
    @GetMapping("/poem")
    public PrintablePoem poem(@RequestParam(value = "twitterhandle", defaultValue = "dog_feelings") String twitterId) {
        var success = poemGeneratorFactory.buildNonRhymingPoemGenerator().generatePoem(haiku, twitterId);

        return new PrintablePoem(haiku, twitterId);
    }
}
