package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://abhi.im/leetcode-best-time-to-buy-and-sell-stock/
 */
public class BuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int localMaxima = Integer.MIN_VALUE;
        int localMinima = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        int buyIndex = 0;
        int sellIndex = 0;

        for (int i=0; i<prices.length; i++) {
            int t = prices[i];
            if (t > localMaxima || sellIndex < buyIndex) {
                localMaxima = t;
                sellIndex = i;
            }
            if (t < localMinima) {
                localMinima = t;
                buyIndex = i;
            }

            int tempProfit = localMaxima - localMinima;
            if (tempProfit > profit && buyIndex <= sellIndex)
                profit = tempProfit;
        }



        return profit;
    }

    public static void main(String... args) {
        int[] prices = new int[] {4,1,2};
        BuySellStock buySellStock = new BuySellStock();
        System.out.println(buySellStock.maxProfit(prices));
    }
}
