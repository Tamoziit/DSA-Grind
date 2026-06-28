public class BuySellStocks {

    /**
     * Brute Force
     * Time: O(n^2)
     * Space: O(1)
     */
    public int maxProfit_1(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }

    /**
     * Greedy - Optimal
     * Time: O(n)
     * Space: O(1)
     */
    public int maxProfit_2(int[] prices) {
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
