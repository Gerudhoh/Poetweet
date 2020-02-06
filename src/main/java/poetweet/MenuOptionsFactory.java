package poetweet;

import java.util.ArrayList;

public class MenuOptionsFactory {

    public ArrayList<IMenuOption> CreateMenuOptions(){

        var twitterScraper = new TwitterScraper();
        var tweetParser = new TweetParser();

        var option1 = new TwitterScraperOption(twitterScraper);
        var option2 = new HaikuGenerationOption(twitterScraper, tweetParser);
        var optionLast = new QuitOption();

        var menuList = new ArrayList<IMenuOption>(){{
            add(option1);
            add(option2);
            // Keep this at the bottom
            add(optionLast);
        }};

        return menuList;
    }

}
