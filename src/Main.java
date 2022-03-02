import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class to test LibrarySystem program.
 *
 * @author Mohamed Rezk
 * @version 1.1.9
 * @see Library
 * @see Book
 * @see Fiction
 * @see NonFiction
 * @see Comic
 * @see Fantasy
 * @see Biography
 * @see History
 * @see Science
 * @see Person
 * @see User
 * @see Staff
 * @see Member
 *
 */

public class Main {

    /**
     * Main method to run program.
     * @param args Variable to store command line prompt.
     * @exception InputMismatchException Detects mismatched input for menu system
     * @throws IllegalArgumentException Detects error in passed argument
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.print("Enter name of library: ");
        String libraryName = input.nextLine();
        Library lib = new Library(libraryName);
        Staff s = new Staff();
        Member m = new Member();
        int option = 0;
        int select = 0;

        do{
            try{
                System.out.println("Who is currently logged on?");
                System.out.println("1) Staff\n2) Member\n3) Exit");
                System.out.print("Choose an option: ");
                choice = input.nextInt();
                if (choice <= 0) {
                    throw new IllegalArgumentException("Please enter a number above 0!");
                }

                switch(choice) {
                    case 1:
                            do {
                                try {
                                    option = s.staffMenu(input);
                                    switch (option) {
                                        case 1:
                                            s = new Staff();
                                            s.staffList.add(s);
                                            s.readInfo(input);
                                            break;
                                        case 2:
                                            lib.readBookDetails(input);
                                            break;
                                        case 3:
                                            lib.readFile(input);
                                            if (!lib.bookList.isEmpty()) {
                                                System.out.println("File read! List is ready!");
                                            }
                                            break;
                                        case 4:
                                            lib.removeBook(input, lib.bookList);
                                            break;
                                        case 5:
                                            lib.findBook(input, lib.bookList);
                                            break;
                                        case 6:
                                            lib.printBookDetails(lib.bookList);
                                            break;
                                        case 7:
                                            lib.printUserDetails(s.staffList);
                                            break;
                                        case 8:
                                            System.out.println("Thank you for all of your efforts!");
                                            break;
                                        default:
                                            System.err.println("Incorrect input! Please retry!");
                                    }
                                }catch(InputMismatchException e) {
                                    System.err.println("Wrong entry! Please choose from options above!");
                                    input.nextLine();
                                }catch(IllegalArgumentException e) {
                                    System.err.println(e.getMessage());
                                    input.nextLine();
                                }
                            } while (option != 8);
                        break;
                    case 2:
                        do{
                            try {
                                select = m.memberMenu(input);
                                switch (select) {
                                    case 1:
                                        m.borrowBook(input, lib.bookList);
                                        break;
                                    case 2:
                                        m.returnBook(input, lib.bookList);
                                        break;
                                    case 3:
                                        m.displayBook(m.memberList);
                                        break;
                                    case 4:
                                        System.out.println("Thank you for shopping at " + libraryName +
                                                " We hope to see you soon!");
                                        break;
                                    default:
                                        System.err.println("Incorrect input! Please retry!");
                                }
                            }catch(InputMismatchException e) {
                                System.err.println("Wrong entry! Please choose from options above!");
                                input.nextLine();
                            }catch(IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                                input.nextLine();
                            }
                        } while (select != 4);

                        break;
                    case 3:
                        System.out.println("Have a nice day!");
                        break;
                    default:
                        System.err.println("Incorrect input! please try again!");
                }
            }catch(InputMismatchException e) {
                System.err.println("Wrong entry! Please choose from options above!");
                input.nextLine();
            }catch(IllegalArgumentException e) {
                System.err.println(e.getMessage());
                input.nextLine();
            }
        } while(choice != 3);

        input.close();
    }
}
