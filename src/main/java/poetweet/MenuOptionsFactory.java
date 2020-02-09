package poetweet;

import java.util.ArrayList;

public class MenuOptionsFactory {

    public ArrayList<IMenuOption> CreateMenuOptions(){

        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();
        var haiku = new Haiku();

        var twitterScraperOption = new TwitterScraperOption(twitterScraper);
        var haikuGenerationOption = new HaikuGenerationOption(haiku, twitterScraper, tweetParser);
        var quitOption = new QuitOption();

        var menuList = new ArrayList<IMenuOption>(){{
            add(twitterScraperOption);
            add(haikuGenerationOption);

            // Keep this at the bottom
            add(quitOption);
        }};

        return menuList;
    }

}
