import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Library Class: printing name of library and looping details of staff members and books stored within array
 *
 * @see Main
 * @see Book
 * @see User
 */
public class Library {

    /**
     * libraryName is a String variable for name of college
     */
    static String libraryName;
    /**
     * bookList is the list for member users that access the system
     */
    ArrayList<Book> bookList = new ArrayList<>();

    /**
     * Library Constructor that accepts the name of the library as a parameter
     *
     * @param name String variable for name of library
     */
    Library(String name) {
        libraryName = name;
    }

    /**
     * Method to add books to database
     * @param input Accepts a parameter of the Scanner class
     */
    public void readBookDetails(Scanner input) {
            int choice = 0;
            System.out.print("Enter details of book " + (bookList.size()+1) + ": \n");

            do {
                try{
                    System.out.println("Which category would you like?" +
                            "\n1) Fiction\n2) Non-Fiction");
                    System.out.print("Enter category: ");
                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 1:
                            int selected = 0;
                            do{
                                try{
                                    System.out.println("Which sub-category would you like?" +
                                            "\n1) Comic \n2) Fantasy");
                                    System.out.print("Choose option: ");
                                    selected = input.nextInt();
                                    switch (selected) {
                                        case 1:
                                            Book c = new Comic();
                                            bookList.add(c);
                                            c.readInfo(input);
                                            break;
                                        case 2:
                                            Book f = new Fantasy();
                                            bookList.add(f);
                                            f.readInfo(input);
                                            break;
                                        default:
                                            System.err.println("Invalid Input! Please retry!");
                                    }
                                }catch(InputMismatchException e) {
                                    System.err.println("Wrong input! Try again with numbers!");
                                    input.nextLine();
                                }
                            }while(selected != 1 && selected != 2);
                            break;
                        case 2:
                            int option = 0;
                            do{
                                try{
                                    System.out.println("Which sub-category would you like?" +
                                            "\n1) Biography \n2) History\n3) Science");
                                    System.out.print("Choose option: ");
                                    option = input.nextInt();
                                    switch (option) {
                                        case 1:
                                            Book b = new Biography();
                                            bookList.add(b);
                                            b.readInfo(input);
                                            break;
                                        case 2:
                                            Book h = new History();
                                            bookList.add(h);
                                            h.readInfo(input);
                                            break;
                                        case 3:
                                            Book s = new Science();
                                            bookList.add(s);
                                            s.readInfo(input);
                                            break;
                                        default:
                                            System.err.println("Invalid Input! Please retry!");
                                    }
                                }catch(InputMismatchException e) {
                                    System.err.println("Wrong input! Try again with numbers!");
                                    input.nextLine();
                                }
                            } while (option != 1 && option != 2 && option != 3);
                            break;
                        default:
                            System.err.println("Wrong category!");
                    }
                }catch(InputMismatchException e) {
                    System.err.println("Wrong input! Try again with numbers!");
                    input.nextLine();
                }
            } while(choice != 1 && choice != 2);
    }

    /**
     * Method to remove books from database
     * @param input Accepts a parameter of the Scanner class
     * @param bookList Accepts a parameter of the ArrayList class
     */
    public void removeBook(Scanner input, ArrayList<Book> bookList) {

        if(bookList.isEmpty()) {
            System.err.println("##### No books to remove #####");
        } else {
            System.out.print("Enter the name of the book to be deleted: ");
            input.nextLine();
            String name = input.nextLine();
            int i = 0;
            for (; i < bookList.size(); i++) {
                if(bookList.get(i).getBookName().equalsIgnoreCase(name)) {
                    break;
                }
            }
            if(i >= bookList.size()) {
                System.out.println("This book does not exist in the database!");
                return;
            }
            int index = i;
            for (int j = index; j < bookList.size()-1; j++) {
                Book nextBook = bookList.get(j + 1);
                bookList.add(j,nextBook);
            }
            System.out.println(bookList.get(i).getBookName() + " has been successfully deleted");
            bookList.remove(i);
        }
    }

    /**
     * Method to find books in database
     * @param input Accepts a parameter of the Scanner class
     * @param bookList Accepts a parameter of the ArrayList class
     */
    public void findBook(Scanner input, ArrayList<Book> bookList) {
        if(bookList.isEmpty()) {
            System.err.println("##### No books available #####");
        } else {
            System.out.print("Enter the name of the book you want to find: ");
            input.nextLine();
            String name = input.nextLine();
            int i = 0;
            for (; i < bookList.size(); i++) {
                if(bookList.get(i).getBookName().equalsIgnoreCase(name)) {
                    System.out.println(bookList.get(i).getBookName()
                            + " is in the database!");
                    break;
                }
            }
            if(i >= bookList.size()) {
                System.err.println(name + " does not exist in the database!");
            }

        }
    }

    /**
     * Method to details of books
     * @param bookList Accepts a parameter of the ArrayList class
     */
    public void printBookDetails(ArrayList<Book> bookList) {
        if(bookList.isEmpty()) {
            System.err.println("##### No books to display #####");
        } else {
            printTitle();
            for(Book book : bookList) {
                book.printInfo();
            }
        }

    }

    /**
     * Method to details of staff users
     * @param staffList Accepts a parameter of the ArrayList class
     */
    public void printUserDetails(ArrayList<Staff> staffList) {
        if(staffList.isEmpty()) {
            System.err.println("##### No users to display #####");
        } else {
            printUserTitle();
            for(Staff staff : staffList) {
                staff.printInfo();
            }
        }
    }

    /**
     * Method to print the "=" for formatting purposes
     */
    public static void printEqual() {
        for(int i = 0; i <= 120; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /**
     * Method to print the name of the library and the column names of the book table
     */
    public static void printTitle() {
        printEqual();
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + libraryName + " - List of Books\t\t\t\t\t\n");
        printEqual();
        System.out.println("    ISBN     |            Book Name          |" +
                "         Author Name          | Price |" +
                " Quantity | Category  |Sub-Category|\n");
    }

    /**
     * Method to print the name of the college and the column names of the user table
     */
    public static void printUserTitle() {
        printEqual();
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + libraryName + " - List of Users\t\t\t\t\t\n");
        printEqual();
        System.out.println(" Staff ID |                User Name                 |" +
                "             Email ID           |" +
                " PhoneNumber |   Section  |\n");
    }

    /**
     * This method is used to accept input from a file
     * @param input Accepts a parameter of the Scanner class
     */
    public void readFile(Scanner input) {
        try{
            input = new Scanner(Paths.get("Books.txt"));
        }catch(FileNotFoundException e) {
            System.err.println("File does not exist in the given path!");
        }catch(IOException e) {
            System.err.println("Incorrect data entry!");
        }

        while(input.hasNext()) {
            try{
                char letter = input.next().charAt(0);

                switch(letter) {
                    case 'c':
                        Book c = new Comic();
                        bookList.add(c);
                        c.readFileInfo(input);
                        break;
                    case 'f':
                        Book f = new Fantasy();
                        bookList.add(f);
                        f.readFileInfo(input);
                        break;
                    case 'h':
                        Book h = new History();
                        bookList.add(h);
                        h.readFileInfo(input);
                        break;
                    case 'b':
                        Book b = new Biography();
                        bookList.add(b);
                        b.readFileInfo(input);
                        break;
                    case 's':
                        Book s = new Science();
                        bookList.add(s);
                        s.readFileInfo(input);
                        break;
                }
            }catch(NullPointerException e) {
                System.err.println("Incorrect file!");
            }
        }
    }
}
