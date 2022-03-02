import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that implements methods for Staff
 * @see Member
 */

public class Staff extends User {

    /**
     * staffID is the identification of staff member
     */
    long staffID;
    /**
     * section is the floor area in which an employee is responisble for
     */
    String section;
    /**
     * staffList is the list for staff users that access the system
     */
    ArrayList<Staff> staffList = new ArrayList<>();

    /**
     * {@inheritDoc}
     * @return Choice to be used in driver class
     */
    @Override
    public int staffMenu(Scanner input) {
        int option;
            System.out.println("Welcome! What would you like to do?");
            System.out.println("1) Read staff information from keyboard\n" +
                    "2) Add a book to the library\n" +
                    "3) Create a library from a file\n" +
                    "4) Remove a book from the library\n" +
                    "5) Find a book in the library\n" +
                    "6) Display book information\n" +
                    "7) Display user information\n" +
                    "8) Exit");
            System.out.print("Choose an option: ");
            option = input.nextInt();
        return option;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readInfo(Scanner input) {
        System.out.print("Enter staff ID: ");
        staffID = input.nextLong();
        System.out.print("Enter first name: ");
        firstName = input.next();
        System.out.print("Enter last name: ");
        lastName = input.next();
        System.out.print("Enter email ID: ");
        emailID = input.next();
        System.out.print("Enter phone number: ");
        phoneNumber = input.nextLong();
        System.out.print("Enter section on the floor: ");
        section = input.next();
        input.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInfo() {
        System.out.printf("  %6d  | %40s | %30s | %11d | %10s |\n",
                staffID,
                firstName + " " + lastName,
                emailID,
                phoneNumber,
                section);
    }
}
