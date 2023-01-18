package grind.Easy;

// fibonacchi 

public class E509 {
    public int fib(int n) {
        if(n == 0) { return 0; }
        else if(n == 1) {return 1;}
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i - 2];
        }
        // System.out.println(Arrays.toString(nums));
        return nums[n];
    }
}
