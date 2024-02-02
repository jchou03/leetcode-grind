package grind.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Threesum
 */

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // first sort nums (ascending to descending)
        // use 2 pointers starting from left and right end of array
        // iterate over nums between the left and right pointer to look for a solution which sums to 0
        // move the pointer that has a larger absolute value toward the middle

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        while(left + 2 <= right){
            for(int i = left + 1; i < right; i++){
                if(nums[left] + nums[i] + nums[right] == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    if(res.isEmpty() || !list.equals(res.get(res.size() - 1))){
                        res.add(list);
                    }
                    break;
                }
            }

            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                // do{
                left++;
                // }
                // while(left < nums.length - 1 && nums[left] == nums[left+1]);
            }else{
                // do{
                right--;
                // }while(right > 0 && nums[right] == nums[right - 1]);
            }
        }

        return res;
    }
}
