package poetweet;

import java.io.IOException;

public class HaikuGenerationOption implements IMenuOption{
    private TweetParser _tweetParser;
    private TwitterScraper _twitterScraper;

    public HaikuGenerationOption(TwitterScraper twitterScraper, TweetParser tweetParser){
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
        if(!result){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        try{
            result = _tweetParser.parseTweets(userInput);
        }
        catch(IOException e){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        return result
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }
}
