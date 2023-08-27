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
        */
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int maxSeq = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)){
                Set<Integer> set = new HashSet<Integer>();
                set.add(nums[i]);
                map.put(nums[i], set);
            }
            if(map.containsKey(nums[i] - 1)){
                Set<Integer> set = map.get(nums[i] - 1);
                set.add(nums[i]);
                map.put(nums[i], set);
            }
            if(map.containsKey(nums[i] + 1)){
                if(map.containsKey(nums[i])){
                    // need to update underlying references for the greater values
                    Set<Integer> set = map.get(nums[i]);
                    set.addAll(map.get(nums[i] + 1));
                    int j = nums[i] + 1;
                    while(map.containsKey(j)){
                        map.put(j, set);
                        j++;
                    }
                }else{
                    Set<Integer> set = map.get(nums[i] + 1);
                    set.add(nums[i]);
                    map.put(nums[i], set);
                }
            }
        }

        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            maxSeq = Math.max(entry.getValue().size(), maxSeq);
        }
        return maxSeq;
    }
}
