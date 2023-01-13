package grind.Easy;

// Best Time to Buy and Sell Stock

public class E121 {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int[] localMin = new int[]{Integer.MAX_VALUE, 0};
        int[] localMax = new int[]{Integer.MIN_VALUE, 0};
        for(int i = 0; i < prices.length; i++){
            int num = prices[i];
            if(num < localMin[0]){
                localMin[0] = num;
                localMin[1] = i;
                localMax[0] = Integer.MIN_VALUE;
                localMax[1] = i;
            } else if (num > localMax[0]){
                localMax[0] = num;
                localMax[1] = i;
                if(localMax[0] - localMin[0] > maxProf){
                    maxProf = localMax[0] - localMin[0];
                }
            }
        }
        return maxProf;
    }
}
