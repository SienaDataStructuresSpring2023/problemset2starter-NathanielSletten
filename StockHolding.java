/**
 * This is a Java class named "StockHolding" that represents a stock holding, with instance variables for the symbol, name, number of shares, 
 * and price of the stock. The class has a constructor to initialize these variables, as well as accessor methods 
 * to retrieve the values of the variables. Additionally, it has two methods to buy and sell shares, respectively, 
 * with the buyShares method updating the number of shares and price of the stock based on input values, and the sellShares method 
 * selling a specified number of shares and returning the amount made on the sale. Finally, the class has a toString method 
 * that prints out the stock holding information in a well-organized format.
 *
 * @author (Matthew Laframboise, Nate Sletten)
 * @version (Spring 2023)
 */
public class StockHolding
{
    // declare the instance variables
    private String symbol;
    private String name;
    private int numShares;
    private double price;
    
    // contructor, intialize the instance variables
    public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    
    // accessor methods to return the symbol, name, number of shares, and price of the specified stock
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
    
    // method to buy a number of shares based on the number and price input
    /**
     * This method updates the instance variables for the number of shares to buy and the price per share. 
     * @param numShares This is and int value for the number of shares bought.
     * @param price This is a double value for the price per share bought.
     */
    public void buyShares(int numShares, double price){
        this.numShares = numShares;
        this.price = price;
    }
    
    // method to sell a number of shares based on the number to sell input
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
    
    // toString method to print out in a well organized format
    @Override
    public String toString(){
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
    }
}
