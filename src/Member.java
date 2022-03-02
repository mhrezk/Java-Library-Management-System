import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * A class that implements methods for Member
 * @see Staff
 * @see Policies
 */
public class Member extends User implements Policies {
    /**
     * memberID is the identification of returning member
     */
    long memberID;
    /**
     * memberList is the list for member users that access the system
     */
    ArrayList<Book> memberList = new ArrayList<>();
    /**
     * borrowDate is the date at which book was borrowed
     */
    LocalDate borrowDate = LocalDate.now();
    /**
     * nowDate is the date at which book was returned
     */
    LocalDate nowDate = LocalDate.now();


    /**
     * {@inheritDoc}
     * @return Choice to be used in driver class
     */
    @Override
    public int memberMenu(Scanner input) {
        int option;
            System.out.println("Welcome back! What would you like to do?");
            System.out.println("1) Borrow a book\n" +
                    "2) Return a book\n" +
                    "3) Display book information\n" +
                    "4) Exit");
            System.out.print("Choose an option: ");
            option = input.nextInt();
        return option;
    }

    /**
     * Method to store number of books to be borrowed; a total of 5 books is allowed
     * @param input Accepts a parameter of the Scanner class
     * @return Number of books the member wishes to borrow
     */
    private int arrayBooks(Scanner input) {
        int books = 0;
        do{
            try {
                if (memberList.size() >= 5) {
                    System.err.println("Cannot borrow any more!");
                    break;
                } else if(memberList.size() > 0) {
                    int remainder = 5 - memberList.size();
                    System.out.print("Enter number of books to be borrowed (remaining "
                            + remainder + "): ");
                    books = input.nextInt();

                    do{
                        if(books > remainder) {
                            System.err.println("Cannot borrow other than " + remainder + "!");
                            System.out.print("Enter number of books to be borrowed (remaining "
                                    + remainder + "): ");
                            books = input.nextInt();
                        } else if (books == 0) {
                            return books;
                        }
                    } while(books > remainder || books < 0);
                    return books;
                }
                System.out.print("Enter number of books to be borrowed: ");
                books = input.nextInt();

                if (books > 5) {
                    System.err.println("A member can only borrow five books!");
                } else if (books < 0) {
                    System.err.println("Number must be positive!");
                } else if (books == 0) {
                    System.err.println("Number must be greater than zero!");
                }
            }catch(InputMismatchException e){
                System.err.println("Incorrect entry! Please choose from options above!");
                input.nextLine();
            }catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
                input.nextLine();
            }
        }while (books > 5 || books < 0 || books == 0);
        return books;
    }

    /**
     * Method to borrow a book from database
     * @param input Accepts a parameter of the Scanner class
     * @param bookList Accepts a paramter of the ArrayList class
     */
    public void borrowBook(Scanner input, ArrayList<Book> bookList) {
        if (bookList.isEmpty()) {
            System.err.println("##### No books to borrow #####");
        } else {
            int bookArray = arrayBooks(input);
            input.nextLine();

            if(bookArray == 0) {
                System.out.println("Exiting menu!");
                return;
            }

            if(((memberList.size() - bookArray) <= 0) || ((memberList.size() - bookArray) > 0)) {
                if(memberList.size() >= 1) {
                    for(int count = 0; count < bookArray; count++) {
                        System.out.print("Enter the name of book " + (memberList.size() + 1) + " to be borrowed: ");
                        String name = input.nextLine();

                        int index = 0;
                        for (; index < bookList.size(); index++) {
                            if(bookList.get(index).getBookName().equalsIgnoreCase(name)) {
                                if(memberList.contains(bookList.get(index))) {
                                    System.out.println("This book is already borrowed!");
                                    return;
                                } else {
                                    Book book = bookList.get(index);
                                    book.setBorrowed(true);
                                    borrowDate = LocalDate.now();
                                    System.out.println(book.getBookName() + " was borrowed successfully!");
                                    System.out.println("Book borrowed at: " + borrowDate);
                                    memberList.add(book);
                                    book.quantity--;
                                    break;
                                }

                            }
                        }
                    }
                }
            }


            if(memberList.isEmpty()) {
                for (int i = 0; i < bookArray; i++) {
                    if(memberList.size() >= 5) {
                        break;
                    }
                    System.out.print("Enter the name of book " + (i + 1) + " to be borrowed: ");
                    String name = input.nextLine();

                    int index = 0;
                    for (; index < bookList.size(); index++) {
                        if(bookList.get(index).getBookName().equalsIgnoreCase(name)) {
                            if(memberList.contains(bookList.get(index))) {
                                System.err.println("This book is already borrowed!");
                            } else {
                                Book book = bookList.get(index);
                                book.setBorrowed(true);
                                System.out.println(bookList.get(index).getBookName() + " was borrowed successfully!");
                                System.out.println("Book borrowed at: " + borrowDate);
                                memberList.add(book);
                                book.quantity--;
                                break;
                            }

                        }
                    }
                    if(index >= bookList.size()) {
                        System.out.println("This book does not exist in the database!");
                    }
                }
            }

        }
    }

    /**
     * Method to return a book to database
     * @param input Accepts a parameter of the Scanner class
     * @param bookList Accepts a paramter of the ArrayList class
     */
    public void returnBook(Scanner input, ArrayList<Book> bookList) {
        if(memberList.isEmpty()) {
            System.err.println("##### No books to return #####");
        } else {
            System.out.print("Enter the name of the book to be returned: ");
            input.nextLine();
            String name = input.nextLine();
            int i = 0;
            for (; i < bookList.size(); i++) {
                if(bookList.get(i).getBookName().equalsIgnoreCase(name)) {
                    checkDate();
                    Book book = bookList.get(i);
                    book.setBorrowed(false);
                    System.out.println(bookList.get(i).getBookName() +" was returned successfully!");
                    System.out.println("Book returned at: " + nowDate);
                    memberList.remove(book);
                    book.quantity++;
                    break;
                }
            }
            if(i >= bookList.size()) {
                System.out.println("This book does not exist in the database!");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkDate() {

        LocalDate deadline = borrowDate.plusDays(FINE_DAYS);

        nowDate = LocalDate.now();

        int dayDifference = nowDate.getDayOfMonth() - deadline.getDayOfMonth();
        int monthDifference = nowDate.getMonthValue() - deadline.getMonthValue();
        int yearDifference = nowDate.getYear() - deadline.getYear();
        int difference = nowDate.getDayOfYear() - deadline.getDayOfYear();

        int timeDifference = difference + FINE_DAYS;


        if(timeDifference > FINE_DAYS) {
            int fee = FINE * difference;
            System.err.println("Outstanding Balance: $" + fee +
                    "\nPlease contact the administrator to pay outstanding balance!");
        } else {
                System.err.println("Outstanding Balance: $0");
        }
    }

    /**
     * Method to display the books that have been borrowed by the member
     * @param bookList Accepts a parameter of the ArrayList class
     */
    public void displayBook(ArrayList<Book> bookList) {
        if(bookList.isEmpty()) {
            System.err.println("##### No books to display #####");
        } else {
            Library.printTitle();
            for(Book book : memberList) {
                book.printInfo();
            }
        }
    }
}
