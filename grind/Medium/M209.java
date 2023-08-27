package grind.Medium;

/*
 * get the minimum subarray length that sums to a target sum
 */

public class M209 {
    public int minSubArrayLen(int target, int[] nums) {
        /* 
        Understand
            given an array of nums, return minimum length of subarray who's sum is greater than or equal to target
            return 0 if no such array exists
        plan
            use sliding window approach keeping track of left pointer and right pointer (start both are same)
            keep track of sum within window
                if sum is < target, then increase right pointer (and add to sum)
                if sum is > target, then increase left pointer (and subtract from sum)
        */
        if(nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int windowSum = nums[0];
        int lp = 0;
        int rp = 0;
        while(rp < nums.length && lp < nums.length){
            if(windowSum >= target){
                minLen = Math.min(minLen, rp - lp + 1);
            }
            if(windowSum < target && rp + 1 < nums.length){
                rp++;
                windowSum += nums[rp];
            }else{
                windowSum -= nums[lp];
                lp++;
            }
        }
        if(minLen == Integer.MAX_VALUE) minLen = 0;
        return minLen;
    }
}
