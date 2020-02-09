package poetweet;

import java.util.ArrayList;

public class TwitterData {
    private String _twitterHandle;
    private ArrayList<String> _tweets;

    /**
     * Constructor for a TwitterData object. DTO stores a twitter user's @ and their most recent (original) tweets.
     * @param twitterHandle The twitter user's @
     * @param tweets The twitter user's most recent tweets.
     */
    public TwitterData(String twitterHandle, ArrayList<String> tweets) {
        _twitterHandle = twitterHandle;
        _tweets = tweets;
    }

    /**
     * Getter for twitter handle.
     * @return The twitter handle.
     */
    public String getTwitterHandle() {
        return _twitterHandle;
    }

    /**
     * Getter for tweets.
     * @return A list of tweets from a user.
     */
    public ArrayList<String> getTweets() {
        return _tweets;
    }

}
