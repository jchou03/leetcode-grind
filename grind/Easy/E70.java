package grind.Easy;

// climbing stairs

public class E70 {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i < steps.length; i++){
            steps[i] = steps[i-2] + steps[i-1];
        }
        return steps[n];
    }
}
