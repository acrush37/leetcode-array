package easy;

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    (i.e., buy one and sell one share of the stock multiple times).
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String... args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int s = 0;

        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i-1])
                s += prices[i] - prices[i-1];

        return s;
    }

}
