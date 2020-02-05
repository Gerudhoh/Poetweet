package poetweet;

public interface IMenuOption {
    // TODO: maybe add a GetActionString(), get errorMEssage
     String getOptionInstructions();

     String getErrorMessage();

     String getOptionDescription();

     MenuOptionResults runMenuOption(String userInput);
}
