package poetweet;

import java.util.ArrayList;

public class MenuOptionsFactory {

    /**
     * Build the individual menu options for Poetweet and bundle them up nicely.
     * @return An arrayList of all the things the system can do.
     */
    public ArrayList<IMenuOption> createPoetweetMenuOptions() {

        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        var haiku = new Haiku();

        var twitterScraperOption = new TwitterScraperOption(twitterScraper);
        var haikuGenerationOption = new HaikuGenerationOption(haiku, twitterScraper, tweetParser);
        var savePoemsMenuOption = new SavePoemsMenuOption();
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>() {
            {
                add(twitterScraperOption);
                add(haikuGenerationOption);
                add(savePoemsMenuOption);

                // Keep this at the bottom
                add(quitOption);
            }
        };

        return menuList;
    }

    /**
     * Build the individual menu options for PoetweetAdmin main and bundle them up nicely.
     * @return An arrayList of all the things the system can do.
     */
    public ArrayList<IMenuOption> createPoetweetAdminMenuOptions() {
        var clearResourcesAdminOption = new ClearResourcesAdminOption();
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>() {
            {
                add(clearResourcesAdminOption);

                // Keep this at the bottom
                add(quitOption);
            }
        };

        return menuList;
    }

}
