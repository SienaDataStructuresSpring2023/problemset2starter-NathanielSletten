import java.util.ArrayList;
/**
 * The class Portfolio is a Java implementation of a financial portfolio, which manages a collection of StockHolding objects. 
 * It provides methods for buying and selling stocks, 
 * tracking the lifetime investment and payout, and calculating the current value of the portfolio.
 *
 * @author (Matthew Laframboise, Nathaniel Sletten)
 * @version (2/22/2023)
 */
public class Portfolio{
    private ArrayList<StockHolding> stocks;
    private double lifetimeInvestment;
    private double lifetimePayout;

    //constructor
    /**
     * Constructs the ArrayList of StockHolding objects to represent a portfolio that contains the number of stocks bought or sold
     * and initializes lifetimeInvestment, sum of all the stock purchases made, lifetimePayout, and sum of all the stock purchases 
     * sold,to 0. 
     * 
     */
    public Portfolio( ){
        stocks = new ArrayList<StockHolding>();
        lifetimeInvestment = 0.0;
        lifetimePayout = 0.0;
    }

    /**
     * Returns the lifetimeInvestment of the portfolio.
     * 
     * @return The lifetimeInvestment of the portfolio
     */
    public double getLifetimeInvestment(){
        return lifetimeInvestment;
    }

    /**
     * Returns the lifetimePayout of the portfolio 
     * 
     * @return The lifetimePayout of the portfolio 
     */
    public double getLifetimePayout(){
        return lifetimePayout;
    }

    /**
     * This method takes as input the stock symbol and returns the index of the stock in stocks that has the same stock symbol as
     * the input. Returns -1, if no stock was found in stocks .
     * 
     * @return getIndex The index of the stock in stocks that has the same stock symbol as input or -1 if no stock was not found
     * @param symbol The stock symbol to search for in stocks
     * 
     */
    private int getIndex(String symbol) {
        int index = 0; 
        int var = -1;
        for(StockHolding s : stocks)
        {
            if(stocks.get(index).getSymbol().equals(symbol))
            {
                var = index;
            }
            index++;
        }
        return var; 
    }

    /**
     * This method takes as input the stock symbol, name of stock, number of shares to
     * buy and the current price per share to return the cost of the purchase.
     * 
     * @param symbol A string type for the stock symbol
     * @param stockName A string type for the name of the stock
     * @param numShares An int type for the number of shares to purchase
     * @param price A double type for the price of the shares being purchased 
     * @return Returnd the cost of the purchase
     */
    public double buyStock( String symbol, String stockName, int numShares, double price )
    {
        int found = getIndex(symbol);
        StockHolding sh = new StockHolding (symbol,stockName, numShares, price);
        double cost = 0.0;
        if(found > -1)
        {
            stocks.get(found).buyShares(numShares, price);
            cost = numShares * price;
            lifetimeInvestment += cost;
        }

        else
        {
            stocks.add(sh);
        }

        return cost;
    }

    /**
     * This method takes the symbol of the stock you want to sell and the number of shares you want to sell and returns the profit of the sale
     * 
     * @param symbol A string type for the symbol of the stock to be purchased
     * @param numShares An int type for the number shares to be purchased
     * @return Returns the profit from the sale
     */
    public double sellStock (String symbol, int numShares)
    {
        int index = getIndex(symbol);
        double profit = 0.0;
        if(index != -1)
        {
            profit = stocks.get(index).sellShares(numShares);
            if(stocks.get(index).getNumShares()==0)
            {
                stocks.remove(index);
            }
        }

        lifetimePayout += profit;

        return profit;
    }

    public double getCurrentValue()
    {

        int index = 0;
        double value = 0.0;
        for(StockHolding s: stocks)
        {
            value += stocks.get(index).getNumShares() * stocks.get(index).getPrice();
            index++;
        }

        return value;

    }

    /**
     * 
     */
    @Override

    public String toString()
    {
        // //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}