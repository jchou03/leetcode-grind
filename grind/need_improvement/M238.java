package grind.need_improvement;

// product of array except self
// runtime: 50%, memory: 25%
// used online solution, using O(n) with 3 iterations over the array

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // use dp to store the left and right products of each index
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            left[i] =  left[i - 1] * nums[i];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i];
        }
        // System.out.println(Arrays.toString(left) + Arrays.toString(right));
        for(int i = 0; i < res.length; i++){
            res[i] = (i > 0 ? left[i-1] : 1) * (i < nums.length - 1 ? right[i+1] : 1);
        }

        return res;
    }
}