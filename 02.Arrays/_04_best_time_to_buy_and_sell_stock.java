public class _04_best_time_to_buy_and_sell_stock {
    public static int findBestTimeToBuyAndSellOpt(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int num : prices) {
            if(num < minPrice) minPrice = num;
            else maxProfit = Math.max(maxProfit, num - minPrice);
        }

        return maxProfit;
    }

    public static int findBestTimeToBuyAndSell(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];

                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        // int profit = findBestTimeToBuyAndSell(prices);
        int profit = findBestTimeToBuyAndSellOpt(prices);
        System.out.println(profit);
    }
}

// BF:
// TC: O(n^2)
// SC: O(1)

// Opt:
// TC: O(n)
// SC: O(1)