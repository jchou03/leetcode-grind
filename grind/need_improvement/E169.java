package grind.need_improvement;
import java.util.*;

// majority element in an array - can be drasticly improved
// runtime: 12%, memory: 38%


class Solution {
    public int majorityElement(int[] nums) {
        // use a hashmap to store the count for each number
        // iterate over the array and update the count
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
                if(map.get(nums[i]) > (nums.length/2)){
                    return nums[i];
                }
            }
        }

        int maxNum = 0;
        int maxCount = 0;
        for(Integer j : map.keySet()){
            // System.out.println(j + " - " + map.get(j));
            if(map.get(j) > maxCount){
                maxNum = j;
                maxCount = map.get(j);
            }
        }
        return maxNum;
    }
}