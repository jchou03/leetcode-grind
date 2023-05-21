package grind.need_improvement;

// remove numbers with more than twins from a sorted array
// runtime: 100%, memory: 6%
// implemented 2 pointer solution

class Solution {
    public int removeDuplicates(int[] nums) {
        // use a two pointer algorithm that has a pointer at the current index in the array, and then the last place when accounting for duplicate rules
        int j = 1;
        int prev = nums[0];
        boolean dupe = false;
        for(int i = 1; i < nums.length; i++){
            if(prev == nums[i]){
                if(dupe){
                    while(i < nums.length && nums[i] == prev){
                        i++;
                    }
                    if(i >= nums.length) {
                        break;
                    }
                    nums[j] = nums[i];
                    prev = nums[i];
                    dupe = false;
                    j++;
                }else{
                    dupe = true;
                    nums[j] = nums[i];
                    j++;
                }
            }else{
                prev = nums[i];
                nums[j] = nums[i];
                j++;
                dupe = false;
            }
            // System.out.println(Arrays.toString(nums) + " i: " + i + ", j: " + j);
        }
        return j;
    }
}