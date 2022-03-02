import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that extends Person class and implements method for both staff and members
 * @see Staff
 * @see Member
 */

public class User extends Person {

    Person person;

    /**
     * {@inheritDoc}
     */
    @Override
    void readInfo(Scanner input) {
        System.out.print("Enter first name: ");
        firstName = input.next();
        System.out.print("Enter last name: ");
        lastName = input.next();
        System.out.print("Enter email ID: ");
        emailID = input.next();
        System.out.print("Enter phone number: ");
        phoneNumber = input.nextLong();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    void printInfo() {
        System.out.printf("%40s | %30s | %11d |\n",
                firstName + " " + lastName,
                emailID,
                phoneNumber);
    }

    /**
     * This method is used to return choice from staff menu
     * @param input Accepts a parameter of the Scanner class
     * @return Returns 0
     */
    public int staffMenu(Scanner input) {
        return 0;
    }


    /**
     * This method is used to return choice from member menu
     * @param input Accepts a parameter of the Scanner class
     * @return Returns 0
     */
    public int memberMenu(Scanner input) {
        return 0;
    }
}
