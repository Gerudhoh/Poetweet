package poetweet;

import java.util.ArrayList;

public class MenuOptionsFactory {

    public ArrayList<IMenuOption> CreateMenuOptions(){

        var option1 = new TwitterScraperOption();
        var optionLast = new QuitOption();

        var menuList = new ArrayList<IMenuOption>(){{
            add(option1);

            // Keep this at the bottom
            add(optionLast);
        }};

        return menuList;
    }

}
