package poetweet;

import java.util.ArrayList;

public interface IPoemUsingReturnable extends IReturnable {

    /**
     * Something for the program to run.
     * @param poems All the poems we've generate thus far.
     */
    void execute(ArrayList<ReturnablePoem> poems);
}
