package poetweet;

import java.io.IOException;

public class HaikuGenerationOption extends PoemGenerator implements IMenuOption {
    private Haiku _haiku;
    private TweetParser _tweetParser;
    private TwitterScraper _twitterScraper;

    public HaikuGenerationOption(Haiku haiku, TwitterScraper twitterScraper, TweetParser tweetParser){
        _haiku = haiku;
        _tweetParser = tweetParser;
        _twitterScraper = twitterScraper;
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
        var result = _twitterScraper.pullTweetsFromTwitterHandle(userInput);
        TwitterData twitterData;
        if(!result){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        try{
            twitterData = _tweetParser.parseTweets(userInput);
        }
        catch(IOException e){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        if(twitterData.getTweets().size() <= 0){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        generatePoem(_haiku, twitterData);
        // TODO: Get rid of this
        System.out.println("POEM:\n" + _haiku.toString());

        return result
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }
}
