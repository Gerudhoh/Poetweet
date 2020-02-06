package poetweet;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TwitterScraperOption implements IMenuOption {
    private TwitterScraper _twitterScraper;

    public TwitterScraperOption(TwitterScraper twitterScraper){
        _twitterScraper = twitterScraper;
    }


    public String getOptionInstructions(){
        return "Please input the twitter handle of the person whose tweets you want to pull";
    }

    public String getErrorMessage(){
        return "Something went wrong, and the tweets were not able to be pulled. Please make sure that the twitter account you want to see is public.";
    }

    public String getOptionDescription(){
        return "Input a Twitter Handle to Pull their Tweets";
    }

    public MenuOptionResults runMenuOption(String userInput){
        var result = _twitterScraper.pullTweetsFromTwitterHandle(userInput);
        return result == true
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }
}
