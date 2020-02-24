package poetweet;

/**
 * Custom exceptions class.
 */
public class Exceptions {

    /**
     * Exception for when the user wants to quit the program.
     */
    protected static class PoetweetException extends RuntimeException {
        /**
         * Constructor.
         */
        protected PoetweetException(String message) {
            super(message);
        }
    }

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
    public static class PoetweetIOException extends PoetweetException {
        /**
         * Constructor.
         */
        protected PoetweetIOException(String msg) {
            super(msg);
        }
    }
    /**
     * My take on an IO exception.
     */
    public static class PoetweetPathException extends PoetweetException {
        /**
         * Constructor.
         */
        protected PoetweetPathException(String msg) {
            super(msg);
        }
    }

    /**
     * Exception for when a dataset is too small to make a specific poem.
     */
    protected static class NotEnoughTweetsException extends PoetweetException {
        /**
         * Constructor.
         */
        protected NotEnoughTweetsException() {
            super("There aren't enough tweets to turn into the specified poem. Please try a different user/poem type");
        }
    }

}
