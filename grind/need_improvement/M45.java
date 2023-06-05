package grind.need_improvement;

// jump game 2 (find the minimum number of jumps to reach the end of an array)
// runtime: 31%, memory: 9% (probably can improve by not using the max integer)

class Solution {
    public int jump(int[] nums) {
        // simple solution: iterate from the back of the array and store the number of jumps needed to reach the end from each index
        // at each index check for the lowest number in range then return the number in the 0th index
        nums[nums.length - 1] = 0;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= nums.length - 1){
                nums[i] = 1;
            }else{
                int min = Integer.MAX_VALUE - 1;
                for(int j = 1; i + j < (Math.min(i + nums[i] + 1, nums.length)); j++){
                    // System.out.println("i: " + i + " i + j: " + (i + j));
                    if(nums[i + j] < min){
                        min = nums[i + j];
                    }
                    // System.out.println("min: " + min);
                }
                nums[i] = min + 1;
            }
        }
        // System.out.println(Arrays.toString(nums));
        return nums[0];
    }
}