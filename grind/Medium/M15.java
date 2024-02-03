package grind.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Threesum
 * 
 * sort the list and iterate over each num to find 2 other nums that sum to 0
 *  use 2 pointers to identify numbers that sum with curNum to 0
 * 
 * runtime: 53%, memory: 52%
 */

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // first sort nums (ascending to descending)
        // iterate over the array
            // for each number, identify 2 other numbers that would combine with current num to sum to 0
            // create left and right pointer on edges of remaining array (to left of current num)
            // if sum is > 0, decrease right pointer, if < 0, increase left pointer

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            int num = nums[i];

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            while(left < right){
                int sum = num + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    ArrayList<Integer> curAns = new ArrayList<Integer>();
                    curAns.add(num);
                    curAns.add(nums[left]);
                    curAns.add(nums[right]);
                    if(res.size() == 0 || !curAns.equals(res.get(res.size() - 1))){
                        res.add(curAns);
                    }
                    left++;
                }
            }
        }

        return res;
    }
}
