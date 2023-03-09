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
    private String symbol;
    private String name;
    private int numShares;
    private double price;
    
    /**
     * This constructs the StockHolding object
     * @param symbol This is a string representation of the stock ticker
     * @param name This is a string representation of the companies name
     * @param numShares This is an int representation of the number of shares you own 
     * @param price This is a double representation of the average price of the 
     */
    public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    
    /**
     * Returns the stock ticker
     * @return This returns the stocks ticker
     */
    public String getSymbol(){
        return symbol;
    }
    /**
     * Returns the stock name
     * @return This returns the stocks name
     */
    public String getName(){
        return name;
    }
    /**
     * Returns the number of shares you own 
     * @return This returns the number of shares you own
     */
    public int getNumShares(){
        return numShares;
    }
    /**
     * Returns the stocks price
     * @return This returns the stocks price
     */
    public double getPrice(){
        return price;
    }

    /**
     * This method updates the instance variables for the number of shares to buy and the price per share. 
     * @param numShares This is and int value for the number of shares bought.
     * @param price This is a double value for the price per share bought.
     */
    public void buyShares(int numShares, double price){
        this.price = ((this.numShares * this.price) + (numShares * price))/(this.numShares + numShares);
        this.numShares = this.numShares + numShares;
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
