package grind.Medium;

import java.util.*;

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
        alternate plan:
            - create a hashmap that stores the number that it's looking for with a set that stores all of the numbers within it
                - since set is same underlying object, new additions are added to the same set
                - then check for set size and get max
                - this still has the issue of setting the set objects for all the upcoming values
        alternate alternate plan:
            - store all values in a set and iterate over the set (since it's O(1) to check if value is within the set)
            - then iterate over set until you find one at the start of a sequence (the num - 1 doesn't exist within the set)
                - once you find a start, you iterate over numbers in set to count length of sequence
        */
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int maxSeq = 0;
        for(Integer n : set){
            // check if this is the start of a sequence
            if(!set.contains(n - 1)){
                int count = 1;
                int j = n + 1;
                while(set.contains(j)){
                    count++;
                    j++;
                }
                maxSeq = Math.max(maxSeq, count);
            }
        }
        return maxSeq;
    }
}
