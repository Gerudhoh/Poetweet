package poetweet;

public interface IMenuOption {

     /**
      * Gets the option instructions.
      * @return What the user needs to do to do this thing.
      */
     String getOptionInstructions();

     /**
      * Gets the error message in case the operation failed.
      * @return A general diagnosis of what went wrong.
      */
     String getErrorMessage();

     /**
      * Describes the action undertaken by this menu option (For printing the menu).
      * @return A short description of the menu option
      */
     String getOptionDescription();

     /**
      * If the menu option generated some form of data - say, a poem, this lets us print that.
      * @return The string that the option produced after execution.
      */
     String getOptionResult();

     /**
      * Executes the specific user option.
      * @param userInput whatever information the user provided the system
      * @return A coded value about the command's success.
      */
     MenuOptionResult runMenuOption(String userInput);

}
