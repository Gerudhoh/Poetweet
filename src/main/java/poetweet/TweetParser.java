package poetweet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetParser {
    private static final String REGEX = ",\"?b['\"]['\"]?([^@#\"].*)['\"]";

    /**
     * Given a Twitter handle of a particular user, it locates the file of fetched tweets and parses them.
     * @param twitterHandle The twitter handle of a user whose tweets you want to parse.
     * @return A TwitterData object, which is just a DTO of parsed tweets and the user they belong to.
     */
    public TwitterData parseTweets(String twitterHandle) {
            ArrayList<String> parsedTweets = new ArrayList<>();
            try {
                Path myPath = Paths.get("./resources/" + twitterHandle + "_tweets.csv");

                List<String> lines = Files.readAllLines(myPath);
                Pattern regex = Pattern.compile(REGEX);

                lines.forEach((line) -> {
                    Matcher match = regex.matcher(line);

                    if (match.find()) {
                        var tweet = match.group(1);

                        if (tweet.contains("\\")) {
                            tweet = tweet.replace("\\xe2\\x80\\x99", "\'");
                            tweet = tweet.replace("\\xe2\\x80\\xa6", "...");
                        }

                        if (!tweet.startsWith("RT")) {
                            parsedTweets.add(tweet);
                        }
                    }

                });

                return new TwitterData(twitterHandle, parsedTweets);
            } catch (InvalidPathException pe){
                throw new Exceptions.PoetweetPathException(pe.getMessage());
            } catch (IOException ioe){
                throw new Exceptions.PoetweetIOException("IO Exception: " + ioe.getMessage());
            }
        }
}
