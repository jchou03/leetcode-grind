package grind.Medium;

// best time to buy/sell stock 2
// runtime: 97%, memory: 11%

class Solution {
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < curMax){
                profit += (curMax - curMin > 0) ? (curMax - curMin) : 0;
                curMin = prices[i];
                curMax = Integer.MIN_VALUE;
            }else if(curMin > prices[i]){
                curMin = prices[i];
            }else if(curMax < prices[i]){
                curMax = prices[i];
            }
            // System.out.println("curMin: " + curMin + " curMax: " + curMax + " profit: " + profit);
        }
        if(curMax != Integer.MIN_VALUE && curMin != Integer.MAX_VALUE && curMax - curMin > 0) profit += (curMax - curMin);
        return profit;
    }
}