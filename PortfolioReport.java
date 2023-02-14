import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program creates a portfolio by reading the transactions in
 * the file transactions.txt and buying and selling stock shares
 * accordingly.  Then, this program prints the portfolio report
 * as described in the problem set 2 instructions.
 *
 * @author 
 * @version 
 */
public class PortfolioReport
{
    /**
     * This program creates a portfolio by reading the transactions in
     * the file transactions.txt and buying and selling stock shares
     * accordingly.  Then, this program prints the portfolio report
     * as described in the problem set 2 instructions.
     * 
     * @param args No command line arguments required.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("transactions.txt"));        
        Portfolio p = new Portfolio();

        while(file.hasNext()){
            String line = file.nextLine();
            String[] data = line.split(",");
            if(data[0].equals("B")){
                //Buy the stock for the portfolio.
                //YOUR CODE HERE.
            } else {
                //Sell the stock from the portfolio.
                //YOUR CODE HERE.
            }
        }

        System.out.print(p);
        System.out.println();
        
        // Uncomment the lines of code below and complete the print statements to work as intended.
        // System.out.println(String.format("      Current Value:  $%,15.2f", //YOUR CODE HERE.));
        // System.out.println(String.format("Lifetime Investment:  $%,15.2f", //YOUR CODE HERE.));
        // System.out.println(String.format("    Lifetime Payout:  $%,15.2f", //YOUR CODE HERE.));
    }
}
