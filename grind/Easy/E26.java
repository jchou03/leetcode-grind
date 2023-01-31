package grind.Easy;

// remove duplicates from an array (non-decreasing) in O(1) memory

public class E26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int prev = nums[0];
        int counter = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != prev){
                prev = nums[i];
                nums[counter] = prev;
                counter++;
            }
        }
        
        return counter;
    }
}
