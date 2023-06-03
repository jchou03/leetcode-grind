package grind.Medium;

// best time to buy/sell stock 2
// runtime: 100%, memory: 33%

class Solution {
    public int maxProfit(int[] prices) {
        int curMin = -1;
        int curMax = -1;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < curMax){
                profit += (curMax - curMin > 0) ? (curMax - curMin) : 0;
                curMin = prices[i];
                curMax = -1;
            }else if(curMin == -1 || curMin > prices[i]){
                curMin = prices[i];
            }else if(curMax < prices[i]){
                curMax = prices[i];
            }
            // System.out.println("curMin: " + curMin + " curMax: " + curMax + " profit: " + profit);
        }
        if(curMax != -1 && curMin != -1 && curMax - curMin > 0) profit += (curMax - curMin);
        return profit;
    }
}

// simpler solution with less variables
/*
 * 
 * class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
 */