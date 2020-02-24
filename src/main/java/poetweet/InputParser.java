package poetweet;

import java.util.Scanner;

public class InputParser {
    private Scanner _reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public InputParser() {
        _reader = new Scanner(System.in);
    }

    /**
     * Reads user input.
     * @return The string of user input
     */
    public String getInput() {
        return _reader.nextLine();
    }

    /**
     * Parses the user input into a number.
     * @return The string of user input
     */
    public int getParsedInput() {
        int parsedInput;
        var input = getInput();

        if (input == null || input.isEmpty()) {
            return -1;
        }

        try {
            parsedInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }

        return parsedInput;
    }

}
