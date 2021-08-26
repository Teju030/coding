class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int min_so_far = prices[0];
        for(int i =1; i<n ;i++){
            int profit = prices[i] - min_so_far;
            if(profit > max_profit)
            {
                max_profit = profit;
            }
            if(prices[i] < min_so_far)
            {
                min_so_far = prices[i];
            }
        }
        return max_profit;
    }
}