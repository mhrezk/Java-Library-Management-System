import java.util.Scanner;
/**
 * A class to store the attributes of books pertaining to the non-fiction category
 * @see Biography
 * @see History
 * @see Science
 */
public class NonFiction extends Book {

    /**
     * categoryFiction is a field for categories
     */
    String categoryNonFiction;

    /**
     * {@inheritDoc}
     */
    @Override
    public void readInfo(Scanner input) {
        super.readInfo(input);
        System.out.print("Enter category: ");
        categoryNonFiction = input.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("%11s|", categoryNonFiction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readFileInfo(Scanner input) {
        super.readFileInfo(input);
        categoryNonFiction = input.next();
    }

}
