package poetweet;

import java.util.Scanner;
import java.util.stream.Collectors;

public class InputParser {
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public InputParser() {
        reader = new Scanner(System.in);
    }

    /**
     * SINGLE JOB: transform a string into a Command object.
     * @param input user text
     * @return
     */
 /*   public Command tokenizeCommand(String input) {
        var tokenizer = new Scanner(input);
        var tokens = tokenizer.tokens().collect(Collectors.toList());

        if (tokens.isEmpty()) {
            return new Command(null, null);
        } else if (tokens.size() == 1) {
            return new Command(tokens.get(0), null);
        }

        return new Command(tokens.get(0), tokens.get(1));
    }
*/

    /**
     * Reads user input
     * @return The string of user input
     */
    public String getInput() {
        return reader.nextLine();
    }

    /**
     * Parses the user input into a number
     * @return The string of user input
     */
    public int getParsedInput() {
        int parsedInput;
        var input = getInput();

        if(input == null || input.isEmpty()){
            return -1;
        }

        try {
            parsedInput = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            return -1;
        }

        return parsedInput;
    }

}
