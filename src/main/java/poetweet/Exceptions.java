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

    /*
    /**
     * Exception for when a yield value is invalid.
     *
    protected static class YieldInvalidException extends Exception {
        /**
         * Constructor.
         * @param msg The message to contain in the exception.
         *
        protected YieldInvalidException(String msg) {
            super(msg);
        }
    }
    */
}
