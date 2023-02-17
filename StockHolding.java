/**
 * Write a description of class Asset here.
 *
 * @author (Matthew Laframboise, Nate Sletten)
 * @version (a version number or a date)
 */
public class StockHolding
{
    // INSTANCE VARIABLES
    private String symbol;
    private String name;
    private int numShares;
    private double price;
    
    public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    
    public String getSymbol(){
        return symbol;
    }
    public String getName(){
        return name;
    }
    public int getNumShares(){
        return numShares;
    }
    public double getPrice(){
        return price;
    }
    
    public void buyShares(int numShares, int price){
        this.numShares = numShares;
        this.price = price;
    }
    public double sellShares(int numSell){
        double amount = 0;
        if (numShares - numSell >= 0){
            numShares = numShares - numSell;
            amount = numSell * price;
        }
        return amount;
    }
    
    @Override
    public String toString(){
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
    }
}
