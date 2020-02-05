package poetweet;

public class QuitOption implements IMenuOption {
    public String getOptionInstructions(){
        return "Do you want to quit the application? [yes/no]";
    }

    public String getErrorMessage(){
        return "Unable to quit correctly. If you want to quit, select the option again and type \'yes\'";
    }

    public String getOptionDescription(){
        return "Quit";
    }

    public MenuOptionResults runMenuOption(String userInput){
        if(userInput.toLowerCase().equals("yes")){
            return MenuOptionResults.QUIT;
        }
        return MenuOptionResults.VALID_OPTION_FAILURE;
    }
}
