package grind.Easy;

// Min cost climbing stairs

public class E748 {
    public int minCostClimbingStairs(int[] cost) {
        // cost.length = index of the top step (the steps in the cost array are the ones that aren't at the top)
        // create a new array which contains the minimum cost to reach each step
        int[] minCost = new int[cost.length];
        // initialize values
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            minCost[i] = Math.min(minCost[i-2], minCost[i-1]) + cost[i];
        }
        return Math.min(minCost[cost.length - 2], minCost[cost.length - 1]);
    }
}
