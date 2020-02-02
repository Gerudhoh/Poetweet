package poetweet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Currency;

public class TwitterScraper implements MenuOption{
    // This path feels... wrong
    private final String filename = ".\\src\\main\\python\\get_tweets.py";


    /**
     * Runs the python script that pulls tweets from a specified Twitter handle
     *
     * @param twitterHandle the twitter handle to pull from
     * @return true if the program ran successfully, false if it didn't
     */
    public boolean pullTweetsFromTwitterHandle(String twitterHandle){
        Process process;
        String output = "";
        String line;

        try{
            process = Runtime
                    .getRuntime()
                    .exec(
                            new String[]{
                                    "python",
                                    filename,
                                    twitterHandle
                            });
        }catch(Exception e){
            return false;
        }

        var stdout = process.getInputStream();
        var reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
        try{
            while((line = reader.readLine()) != null){
                output += line;
            }
        }catch(IOException e){
            return false;
        }

        if(output.isEmpty() || output.toLowerCase().contains("error")){
            return false;
        }

        return true;
    }

    public String getOptionInstructions(){
        return "Please input the twitter handle of the person whose tweets you want to pull";
    }
}
