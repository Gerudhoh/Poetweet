package poetweet;

import java.util.ArrayList;

public class TwitterData {
    private String _twitterHandle;
    private ArrayList<String> _tweets;

    public TwitterData(String twitterHandle, ArrayList<String> tweets){
        _twitterHandle = twitterHandle;
        _tweets = tweets;
    }

    public String getTwitterHandle(){
        return _twitterHandle;
    }

    public ArrayList<String> getTweets(){
        return _tweets;
    }

}
