import java.util.Scanner;

/**
 * A class to store the attributes of books pertaining to the fiction category
 * @see Comic
 * @see Fantasy
 */
public class Fiction extends Book {

    /**
     * categoryFiction is a field for categories
     */
    String categoryFiction;

    /**
     * {@inheritDoc}
     */
    @Override
    public void readInfo(Scanner input) {
        super.readInfo(input);
        System.out.print("Enter category: ");
        categoryFiction = input.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("%11s|", categoryFiction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readFileInfo(Scanner input) {
        super.readFileInfo(input);
        categoryFiction = input.next();
    }


}
