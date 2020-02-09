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
      * Executes the specific user option.
      * @param userInput whatever information the user provided the system
      * @return A coded value about the command's success.
      */
     MenuOptionResults runMenuOption(String userInput);
}
