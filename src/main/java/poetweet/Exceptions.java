package poetweet;

/**
 * Custom exceptions class.
 */
public class Exceptions {

    /**
     * Exception for when the user wants to quit the program.
     */
    protected static class QuitException extends RuntimeException {
        /**
         * Constructor.
         */
        protected QuitException() {
            super();
        }
    }

    /**
     * My take on an IO exception.
     */
    protected static class PoetweetIOException extends RuntimeException {
        /**
         * Constructor.
         */
        protected PoetweetIOException() {
            super();
        }
    }

    /**
     * Exception for when a dataset is too small to make a specific poem.
     */
    protected static class NotEnoughTweetsException extends RuntimeException {
        /**
         * Constructor.
         */
        protected NotEnoughTweetsException() {
            super("There aren't enough tweets to turn into the specified poem. Please try a different user/poem type");
        }
    }

}
