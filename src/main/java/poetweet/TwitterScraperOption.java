package poetweet;

public class TwitterScraperOption implements IMenuOption {
    private TwitterScraper _twitterScraper;

    /**
     * Constructor for TwitterScraper.
     * @param twitterScraper A twitter scraper object
     */
    public TwitterScraperOption(TwitterScraper twitterScraper) {
        _twitterScraper = twitterScraper;
    }

    /**
     * Gets the option instructions.
     * @return What the user needs to do to pull tweets from someone.
     */
    public String getOptionInstructions() {
        return "Please input the twitter handle of the person whose tweets you want to pull";
    }

    /**
     * Gets the error message.
     * @return A diagnosis of what went wrong and suggestions on what to do better next time.
     */
    public String getErrorMessage() {
        var errorMessage = "Something went wrong, and the tweets were not able to be pulled.";
        errorMessage += " Please make sure that the twitter account you want to see is public.";
        return errorMessage;
    }

    /**
     * Describes the action undertaken by this menu option (For printing the menu).
     * @return A short description of the menu option
     */
    public String getOptionDescription() {
        return "Input a Twitter Handle to Pull their Tweets";
    }

    /**
     * Executes the Twitter Scraping.
     * @param userInput The twitter handle of the user whose tweets we want to scrape.
     * @return A coded value about the command's success.
     */
    public MenuOptionResults runMenuOption(String userInput) {
        var result = _twitterScraper.pullTweetsFromTwitterHandle(userInput);
        return result
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }
}
