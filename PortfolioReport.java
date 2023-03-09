import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * This program creates a portfolio by reading the transactions in
 * the file transactions.txt. Then it buys and sells stock shares
 * accordingly. Then, this program prints the portfolio report
 * as described in the problem set 2 instructions.
 *
 * @ (Nathaniel Sletten, Matthew Laframboise)
 * @ (2/23/2023)
 */
public class PortfolioReport
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("transactions.txt"));
    
        Portfolio p = new Portfolio();
        
        while(file.hasNext()){
            String line = file.nextLine();
            String[] data = line.split(",");

            if(data[0].equals("B")){
                String numSharesBuy = data[3];
                String price = data[4];
                p.buyStock(data[1],data[2],Integer.parseInt(numSharesBuy.trim()),Double.parseDouble(price));
            } else{ 
                String numSharesSell = data[2];
                p.sellStock(data[1],Integer.parseInt(numSharesSell.trim()));
            }

            System.out.print(p);
            System.out.println();

            System.out.println(String.format("      Current Value:  $%,15.2f", p.getCurrentValue()));
            System.out.println(String.format("Lifetime Investment:  $%,15.2f",p.getLifetimeInvestment()));
            System.out.println(String.format("    Lifetime Payout:  $%,15.2f", p.getLifetimePayout()));
        }
    }
}

