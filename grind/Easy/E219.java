package grind.Easy;

import java.util.HashMap;

public class E219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
            understand:
                - given integer array nums
                - int k
                - return true if 2 distinct indices i and j where nums[i] == nums[j] and abs(i - j) <= k
            match:
                - hashmap solution for O(n) runtime
            plan:
                - use a map to store each nums[i] as iterate over array
                    - store the index that the value was found at
                    - if the key already exists, check to see if the position is within k of cur index (if not, update entry)
        */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                if(Math.abs(map.get(nums[i]) - i) <= k){
                    return true;
                }else{
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
