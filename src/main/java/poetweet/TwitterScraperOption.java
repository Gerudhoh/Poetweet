package poetweet;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TwitterScraperOption implements IMenuOption {
    private final String filename = ".\\src\\main\\python\\get_tweets.py";


    public String getOptionInstructions(){
        return "Please input the twitter handle of the person whose tweets you want to pull";
    }

    public String getErrorMessage(){
        return "Something went wrong, and the tweets were not able to be pulled. Please make sure that the twitter account you want to see is public.";
    }

    public String getOptionDescription(){
        return "Input a Twitter Handle to Pull their Tweets";
    }

    public MenuOptionResults runMenuOption(String userInput){
        var result = pullTweetsFromTwitterHandle(userInput);
        return result == true
                ? MenuOptionResults.VALID_OPTION_SUCCESS
                : MenuOptionResults.VALID_OPTION_FAILURE;
    }

    /**
     * Runs the python script that pulls tweets from a specified Twitter handle
     *
     * @param twitterHandle the twitter handle to pull from
     * @return true if the program ran successfully, false if it didn't
     */
    private boolean pullTweetsFromTwitterHandle(String twitterHandle){
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
}
