package poetweet;

import java.util.ArrayList;

public class MenuOptionsFactory {

    /**
     * Build the individual menu options and bundle them up nicely.
     * @return An arrayList of all the things the system can do.
     */
    public ArrayList<IMenuOption> createMenuOptions() {

        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        var haiku = new Haiku();

        var twitterScraperOption = new TwitterScraperOption(twitterScraper);
        var haikuGenerationOption = new HaikuGenerationOption(haiku, twitterScraper, tweetParser);
        var adminActivityOption = new AdminActivitiesOption();
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>() {
            {
                add(twitterScraperOption);
                add(haikuGenerationOption);
                add(adminActivityOption);

                // Keep this at the bottom
                add(quitOption);
            }
        };

        return menuList;
    }

}
