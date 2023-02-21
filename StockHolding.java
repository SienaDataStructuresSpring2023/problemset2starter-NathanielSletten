/**
 * Write a description of class Asset here.
 *
 * @author (Matthew Laframboise, Nate Sletten)
 * @version (Spring 2023)
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
    
    /**
     * This method updates the instance variables for the number of shares to buy and the price per share. 
     * @param numShares This is and int value for the number of shares bought.
     * @param price This is a double value for the price per share bought.
     */
    public void buyShares(int numShares, double price){
        this.numShares = numShares;
        this.price = price;
    }
    
    /**
     * This method is used to sell shares. It will first check to make sure the number of shares you want to sell is less the the amount of shares purchased.
     * If the number of shares you want to sell is less then the total amount of shares owned then it updates the instance variables and returns the dollar
     * amount. If you try to sell more shares then you own it will return 0.
     * @param numSell This is the number of shares you want to sell.
     * @return This returns the amount you made on the sale if you sell the number of shares you own or less. 
     */
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
