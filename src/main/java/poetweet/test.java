package poetweet;

import eu.crydee.syllablecounter.SyllableCounter;

import java.io.IOException;

public class test {

    public static void main (String args[]) throws IOException {
        SyllableCounter sc = new SyllableCounter();
        int myCount = sc.count("facility");
        System.out.println("count= " + myCount);

       //var parser = new TweetParser();
       //parser.parseTweets("dog_feelings");
    }

}
