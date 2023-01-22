package grind.Easy;
import java.util.*;

// two sum

public class E1 {
    public int[] twoSum(int[] nums, int target) {
        // missing number, index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put((target - nums[i]), i);
            }else{
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }
}
