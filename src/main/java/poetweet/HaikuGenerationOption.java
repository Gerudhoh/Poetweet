package poetweet;

import java.io.IOException;
import java.util.stream.IntStream;

public class HaikuGenerationOption implements IMenuOption, IPoemGenerator{
    private static final Haiku HAIKU = new Haiku();
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
        TwitterData twitterData;
        if(!result){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        try{
            twitterData = _tweetParser.parseTweets(userInput);
        }
        catch(IOException e){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        if(twitterData.getTweets().size() <= 0){
            return MenuOptionResults.VALID_OPTION_FAILURE;
        }

        var poem = generatePoem(twitterData);
        // TODO: Get rid of this
        System.out.println(poem.toString());

        return result
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }

    public Poem generatePoem(TwitterData twitterData) {
        int[] rhymingScheme = HAIKU.getRhymingScheme().stream().mapToInt(i->i).toArray();
        Integer sum = IntStream.of(rhymingScheme).sum();
        // No rhymes
        if(sum == 0){
            return generateNonRhymingPoem(tweets, poemType);
        }
        return poemType;
    }
}
