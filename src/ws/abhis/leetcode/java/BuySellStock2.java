package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuySellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int profit = 0;

        for (int i=1; i<prices.length; i++) {
            int c = prices[i] - prices[i-1];
            if (c > 0)
                profit += c;
        }

        return profit;
    }
}
