import java.util.Scanner;
/**
 * A class to store the attributes of comics
 */
public class Comic extends Fiction{

    /**
     * subcategoryFiction is a field for sub-categories
     */
    String subcategoryFiction;

    /**
     * {@inheritDoc}
     */
    @Override
    public void readInfo(Scanner input) {
        super.readInfo(input);
        System.out.print("Enter sub-category: ");
        subcategoryFiction = input.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf(" %10s |\n", subcategoryFiction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readFileInfo(Scanner input) {
        super.readFileInfo(input);
        subcategoryFiction = input.next();
    }

}
