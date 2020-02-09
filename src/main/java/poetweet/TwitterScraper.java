package poetweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TwitterScraper {
    private static final String FILENAME = ".\\src\\main\\python\\get_tweets.py";

    /**
     * Runs the python script that pulls the 150 most recent tweets from a specified Twitter handle.
     *
     * @param twitterHandle the twitter handle to pull from
     * @return true if the program ran successfully, false if it didn't
     */
    public boolean pullTweetsFromTwitterHandle(String twitterHandle) {
        Process process;
        String output = "";
        String line;

        try {
            process = Runtime
                    .getRuntime()
                    .exec(
                            new String[]{
                                    "python",
                                    FILENAME,
                                    twitterHandle
                            });
        } catch (Exception e) {
            return false;
        }

        var stdout = process.getInputStream();
        var reader = new BufferedReader(new InputStreamReader(stdout, StandardCharsets.UTF_8));
        try {
            while ((line = reader.readLine()) != null) {
                output += line;
            }
        } catch (IOException e) {
            return false;
        }

        if (output.isEmpty() || output.toLowerCase().contains("error")) {
            return false;
        }

        return true;
    }
}
