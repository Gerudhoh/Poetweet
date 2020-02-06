package poetweet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetParser {
    private final String regexString = ",\"?b['\"]['\"]?([^@#\"].*)['\"]";
    private ArrayList<String> tweetsList;

    public TweetParser(){
        tweetsList = new ArrayList<>();
    }

    public ArrayList<String> getTweetsList(){
        return tweetsList;
    }

    public void parseTweets(String twitterHandle) throws IOException {
            Path myPath = Paths.get("./data/" + twitterHandle + "_tweets.csv");
            List<String> lines = Files.readAllLines(myPath);
            Pattern regex = Pattern.compile(regexString);

            lines.forEach((line) -> {
                Matcher m = regex.matcher(line);

                if (m.find()){
                    var tweet = m.group(1);
                    if(!tweet.startsWith("RT")){
                        tweetsList.add(m.group(1));
                    }
                }

            });
        }
}
