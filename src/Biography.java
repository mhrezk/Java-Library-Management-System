import java.util.Scanner;
/**
 * A class to store the attributes of biographies
 */
public class Biography extends NonFiction {

    /**
     * subcategoryFiction is a field for sub-categories
     */
    String subcategoryNonFiction;

    /**
     * {@inheritDoc}
     */
    @Override
    public void readInfo(Scanner input) {
        super.readInfo(input);
        System.out.print("Enter sub-category: ");
        subcategoryNonFiction = input.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf(" %10s |\n", subcategoryNonFiction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readFileInfo(Scanner input) {
        super.readFileInfo(input);
        subcategoryNonFiction = input.next();
    }

}
