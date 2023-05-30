package grind.need_improvement;

// rotating an array to the right
// runtime: 53%, memory: 97%

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] copy = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if((i - k >= 0)){
                copy[i] = nums[(i - k)];
            }else{
                copy[i] = nums[nums.length - (k - i)];
            }
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = copy[i];
        }
    }
}