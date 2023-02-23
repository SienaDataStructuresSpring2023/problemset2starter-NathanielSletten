import java.util.ArrayList;
/**
 * Create a portfolio of stocks.
 *
 * @author (Matthew Laframboise, Nathaniel Sletten)
 * @version (2/22/2023)
 */
public class Portfolio
{
    // Array list of stocks
    private ArrayList<StockHolding> stocks;
    private double lifeTimeMade;
    private double payout;

    // Default constructor
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        lifeTimeMade = 0.0;
        payout = 0.0;
    }

    // Add accessor methods
    public double getLifeTimeMade(){
        return lifeTimeMade;
    }

    public double getPayout(){
        return payout;
    }

    // Private method to get index of a stock in the ArrayList by symbol
    private int getIndex(String symbol){
        for(int i=0; i<stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }

    // Method to buy a stock
    /**
     * Buys the given number of shares of a stock at the given price per share. If the stock
     * already exists in the portfolio, the number of shares is added to the existing holding.
     * Otherwise, a new StockHolding object is added to the ArrayList.
     * @param symbol the symbol of the stock to buy
     * @param name the name of the stock to buy
     * @param shares the number of shares to buy
     * @param pricePerShare the current price per share of the stock
     * @return the cost of buying the shares, i.e., the number of shares bought times the price per share
     */
    public double buyStock(String symbol, String name, int shares, double pricePerShare) {
        double cost = shares * pricePerShare;
        int index = getIndex(symbol);
        if (index == -1) {
            // Stock not found in portfolio, add a new StockHolding
            StockHolding stock = new StockHolding(symbol, name, shares, pricePerShare);
            stocks.add(stock);
        } else {
            // Stock found in portfolio, update existing StockHolding
            StockHolding stock = stocks.get(index);
            stock.buyShares(shares, pricePerShare);
        }
        lifeTimeMade += cost;
        return cost;
    }

    /**
     * Sells the given number of shares of a stock from the portfolio. If the number of shares sold
     * results in a holding of zero, the StockHolding object is removed from the ArrayList.
     * @param symbol the symbol of the stock to sell
     * @param shares the number of shares to sell
     * @return the payout from selling the shares, i.e., the number of shares sold times the price per share
     */
    public double sellStock(String symbol, int shares) {
        int index = getIndex(symbol);
        if (index != -1) {
            // Stock found in portfolio, sell shares
            StockHolding stock = stocks.get(index);
            double payout = stock.sellShares(shares);
            if (stock.getNumShares() == 0) {
                // Remove StockHolding object from ArrayList if no shares remain
                stocks.remove(index);
            }
            this.payout += payout;
            return payout;
        }
        return 0;
    }

    /**
     * Returns the current value of the portfolio, which is the sum of the number of shares times the
     * price per share for each stock in the portfolio.
     * @return the current value of the portfolio
     */
    public double getCurrentValue() {
        double value = 0.0;
        for (StockHolding stock : stocks) {
            value += stock.getNumShares() * stock.getPrice();
        }
        return value;
    }

    @Override
    public String toString(){
        //DO NOT EDIT THIS METHOD.
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