import java.util.Scanner;

/**
 * An abstract class that houses the properties of a person
 *
 * @see User
 * @see Staff
 * @see Member
 */

public abstract class Person {

    /**
     * firstName is a String variable for first name of user
     */
    String firstName;
    /**
     * lastName is a String variable for last name of user
     */
    String lastName;
    /**
     * emailID is a String variable for email of user
     */
    String emailID;
    /**
     * phoneNumber is a long variable for phone number of user
     */
    long phoneNumber;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * This method is used to accept user input for person details
     * @param input Accepts a parameter of the Scanner class
     */
    abstract void readInfo(Scanner input);

    /**
     * This method is used to print person details
     */
    abstract void printInfo();


}
