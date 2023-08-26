package grind.Medium;

import java.util.Arrays;
import java.util.HashMap;

/*
 * given an input of numbers, return the maximum length of numbers in a sequence
 */

public class M128 {
    public int longestConsecutive(int[] nums) {
        /*
        understand: 
            - return the length of the longest consecutive elements sequence
            - think of the input as a set and we need to get the length of consecutive numbers
        plan:
            - we can use a hashmap to store each number and the length of the consecutive sequence
            - check if the map contains nums[i] - 1 (the number before the current number)
                - if yes, add nums[i] into the map with the length of the sequence of the prev num + 1
                - if no, add nums[i] into the map with the length of sequence being 1
                - keep track of the maximum sequence length 
            - this solution assumes that the input array is sorted, but sorting the array isn't in O(n)
        */
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxSeq = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i] - 1)){
                int seqLength = map.get(nums[i] - 1) + 1;
                maxSeq = Math.max(maxSeq, seqLength);
                map.put(nums[i], seqLength);
            }else{
                map.put(nums[i], 1);
                maxSeq = Math.max(maxSeq, 1);
            }
            // System.out.println(map);
        }
        return maxSeq;
    }
}
