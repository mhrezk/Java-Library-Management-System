/**
 * An interface used to calculate the fine for late returns
 * @see Member
 */
public interface Policies {

    /**
     * FINE_DAYS is an int variable for the number of days till the fine is due
     */
    int FINE_DAYS = 14;
    /**
     * FINE is an int variable for thr fine
     */
    int FINE = 1;

    /**
     * Method to check for outstanding fines for member to pay
     */
    void checkDate();

}
