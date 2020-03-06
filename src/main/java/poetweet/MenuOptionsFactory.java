package poetweet;

import java.util.ArrayList;

public class MenuOptionsFactory {

    /**
     * Build the individual menu options for Poetweet and bundle them up nicely.
     * @return An arrayList of all the things the system can do.
     */
    public ArrayList<IMenuOption> createPoetweetMenuOptions() {

        var poems = new ArrayList<PrintablePoem>();
        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        var poemGenerator = new NonRhymingPoemGenerator(poems, twitterScraper, tweetParser);
        var rhymingPoemGenerator = new RhymingPoemGenerator(poems, twitterScraper, tweetParser);
        var poemSaver = new PoemSaver();
        var haiku = new Haiku();
        var quatrain = new Quatrain();
        var freeform = new FreeFormPoem(1, new Integer[]{1}, new Integer[]{0});

        var twitterScraperOption = new TwitterScraperOption(twitterScraper);
        var haikuGenerationOption = new HaikuGenerationOption(haiku, poems, poemGenerator);
        var quatrainGenerationOption = new QuatrainGenerationOption(quatrain, poems, rhymingPoemGenerator);
        var freeFormGenerationOption = new FreeFormPoemGenerationOption(freeform, poems, rhymingPoemGenerator);
        var savePoemsMenuOption = new SavePoemsMenuOption(poems, poemSaver);
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>() {
            {
                add(twitterScraperOption);
                add(haikuGenerationOption);
                add(quatrainGenerationOption);
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
