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
    private static final String regexString = ",\"?b['\"]['\"]?([^@#\"].*)['\"]";

    public TwitterData parseTweets(String twitterHandle) throws IOException {
            ArrayList<String> parsedTweets = new ArrayList<>();
            Path myPath = Paths.get("./resources/" + twitterHandle + "_tweets.csv");
            List<String> lines = Files.readAllLines(myPath);
            Pattern regex = Pattern.compile(regexString);

            lines.forEach((line) -> {
                Matcher match = regex.matcher(line);

                if (match.find()){
                    var tweet = match.group(1);

                    if(tweet.contains("\\")){
                        tweet = tweet.replace("\\xe2\\x80\\x99", "\'");
                        tweet = tweet.replace("\\xe2\\x80\\xa6", "...");
                    }

                    if(!tweet.startsWith("RT")){
                        parsedTweets.add(tweet);
                    }
                }

            });

            return new TwitterData(twitterHandle, parsedTweets);
        }
}
