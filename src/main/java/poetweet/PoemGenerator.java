package poetweet;

import eu.crydee.syllablecounter.SyllableCounter;

import java.util.ArrayList;
import java.util.Random;

public abstract class PoemGenerator {
    private static final SyllableCounter _syllableCounter = new SyllableCounter();

    protected void generatePoem(Poem poem, TwitterData twitterData) {
        var usedIndexes = new ArrayList<Integer>();
        var tweets = twitterData.getTweets();
        var poemLines = poem.getPoem();
        var rand = new Random();
        var i = 0;

        while(i < poem.getNumberOfLines()){
            var randomTweetIndex = rand.nextInt(tweets.size());
            var generatedLine = generatePoemLine(poemLines.get(i), tweets.get(randomTweetIndex));

            if(usedIndexes.contains(randomTweetIndex) || generatedLine.isEmpty()){
                continue;
            }

            poemLines.get(i).setLine(generatedLine);
            usedIndexes.add(randomTweetIndex);
            i++;
        }
    }

    private String generatePoemLine(PoemLine poemLine, String tweet){
        var wordsInTweet = tweet.split("\\s");
        var wordsForPoemLine = new StringBuilder();
        var syllablesRemaining = poemLine.getNumSyllables();

        for (var word : wordsInTweet) {
            var wordSyllables = _syllableCounter.count(word);

            if(syllablesRemaining - wordSyllables >= 0){
                wordsForPoemLine.append(word);
                wordsForPoemLine.append(" ");
                syllablesRemaining -= wordSyllables;
            }

            if(syllablesRemaining <= 0){
                break;
            }
        }

        return syllablesRemaining == 0
                ? wordsForPoemLine.toString()
                : "";
    }
}
