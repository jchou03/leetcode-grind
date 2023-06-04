package grind.need_improvement;

// jump game 2 (find the minimum number of jumps to reach the end of an array)

class Solution {
    public int jump(int[] nums) {
        // simple solution: iterate from the back of the array and store the number of jumps needed to reach the end from each index
        // at each index check for the lowest number in range then return the number in the 0th index
        nums[nums.length - 1] = 0;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= nums.length - 1){
                nums[i] = 1;
            }else{
                int min = Integer.MAX_VALUE;
                for(int j = 0; i + j < (Math.min(i + nums[i], nums.length)); j++){
                    if(nums[i + j] < min){
                        min = nums[i + j];
                    }
                    nums[i] = min + 1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }
}