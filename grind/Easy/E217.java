package grind.Easy;
import java.util.*;

/**
 * E217
 * 
 * runtime: 98%, memory: 5.62
 */
public class E217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

}