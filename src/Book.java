import java.util.Scanner;

/**
 * A class to store the attributes of books
 * @see Fiction
 * @see NonFiction
 */
public class Book { //implements Policies {

    /**
     * isbn a long variable that contains the ISBN of a book
     */
    private long isbn;
    /**
     * bookName is a string variable to store the name of the book
     */
    private String bookName;
    /**
     * authorName is a string variable to store the name of the author
     */
    private String authorName;
    /**
     * price is a double variable to store the price of the book
     */
    private double price;
    /**
     * quantity is a string variable to store the quantity of the book
     */
    int quantity;
    /**
     * isBorrowed is a boolean variable to store if the book is borrowed or returned
     */
    private boolean isBorrowed;

    /**
     * This method is used to accept user input for book details
     * @param input Accepts a parameter of the Scanner class
     */
    public void readInfo(Scanner input) {
        System.out.print("Enter book ISBN: ");
        isbn = input.nextLong();
        System.out.print("Enter book name: ");
        input.nextLine();
        bookName = input.nextLine();
        System.out.print("Enter name of author: ");
        authorName = input.nextLine();
        System.out.print("Enter book price: ");
        price = input.nextDouble();
        System.out.print("Enter book quantity: ");
        quantity = input.nextInt();
    }

    /**
     * This method is used to accept input from a file
     * @param input Accepts a parameter of the Scanner class
     */
    public void readFileInfo(Scanner input) {
            isbn = input.nextLong();
            bookName = input.next().replace('+', ' ');
            authorName = input.next().replace('+', ' ');
            price = input.nextDouble();
            quantity = input.nextInt();

    }

    /**
     * This method is used to print book details
     */
    public void printInfo() {
        System.out.printf("%13d| %30s|%30s| %5.2f |    %2d    |",
                isbn,
                bookName,
                authorName,
                price,
                quantity);
    }

    /**
     * This method is used to return the name of the book
     * @return bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method is used to set if a book is borrowed or not
     * @param borrowed Accepts a boolean parameter to indicate if book is borrowed
     */
    public void setBorrowed (boolean borrowed) {
        isBorrowed = borrowed;
    }
}
