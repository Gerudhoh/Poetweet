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
        var freeform = new FreeFormPoem(1, new Integer[]{1}, new Integer[]{0});

        var twitterScraperOption = new TwitterScraperOption(twitterScraper);
        var haikuGenerationOption = new HaikuGenerationOption(haiku, twitterScraper, tweetParser);
        var freeFormGenerationOption = new FreeFormPoemGenerationOption(freeform, twitterScraper, tweetParser);
        var savePoemsMenuOption = new SavePoemsMenuOption();
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>() {
            {
                add(twitterScraperOption);
                add(haikuGenerationOption);
                add(freeFormGenerationOption);
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
        var clearResourcesAdminOption = new ClearResourcesAdminOption(new DirectoryClearer());
        var clearPoemsAdminOption = new ClearSavedPoemsAdminOption(new DirectoryClearer());
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>() {
            {
                add(clearResourcesAdminOption);
                add(clearPoemsAdminOption);

                // Keep this at the bottom
                add(quitOption);
            }
        };

        return menuList;
    }

}
