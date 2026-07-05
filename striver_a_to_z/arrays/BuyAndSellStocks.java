/**
 * Greedy
 * Time: O(N)
 * Space: O(1)
 */
public class BuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int sell : prices) {
            if (sell > buy) {
                profit = Math.max(profit, sell - buy);
            } else {
                buy = sell;
            }
        }

        return profit;
    }
}
