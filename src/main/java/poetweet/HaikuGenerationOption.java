package poetweet;

import java.io.IOException;

public class HaikuGenerationOption extends PoemGenerator implements IMenuOption {
    private Haiku _haiku;

    public HaikuGenerationOption(Haiku haiku, TwitterScraper twitterScraper, TweetParser tweetParser){
        super(twitterScraper, tweetParser);
        _haiku = haiku;
    }

    public String getOptionInstructions() {
        return "Please input the twitter handle of the person whose tweets you want to turn into a Haiku.";
    }

    public String getErrorMessage() {
        return "Something went wrong, and the tweets were not able to be pulled. Please make sure that the twitter account you want to see is public.";
    }

    public String getOptionDescription() {
        return "Generate a Haiku based off someone's tweets";
    }

    public MenuOptionResults runMenuOption(String userInput) {
        var result = generatePoem(_haiku, userInput);
        // TODO: Get rid of this
        System.out.println("POEM:\n" + _haiku.toString());

        return result
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }
}
