/*
Understand
    - given 2 sorted arrays (in ascending order)
    - need to return k pairs with the smallest sums of (u, v) with one element from each array (no duplicates)

Match
    - array problem with 2 pointers (1 for each array)

Plan
    - 2 pointers (1 for each array)
    - add the lowest pair to the list, then incremenet the pointer that is the smaller value

    - 2 pointer solution will cause too many issues (won't always get all of the k pairs)
    - using a priority queue solution (find all of the pairs, the get the k smallest from the prio queue)

    - better approach to avoid inserting all pairs into the prio queue is to add all of the pairs of nums1 
    with the first element of nums 2, and then pop the smallest element from prio queue into result, and then 

Implement

Review

Examine


 */

import java.util.*;

public class KPairs {
    // public class Comp implements Comparator<List<Integer>>{
    //     // Comparator for pairs of integers in the form of lists
    //     public int compare(List<Integer> l1, List<Integer> l2){
    //         int sum1 = 0;
    //         for(int i = 0; i < l1.size(); i++){
    //             sum1 += l1.get(i);
    //         }
    //         int sum2 = 0;
    //         for(int i = 0; i < l2.size(); i++){
    //             sum2 += l2.get(i);
    //         }
    //         return sum1 - sum2;
    //     }
    // }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //  queue where first element is the sum of the 2 numbers, and the second element is the index of the second value
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {return a[0] - b[0];});
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // add all of the pairs of nums1 and nums2[0]
        for(int i = 0; i < nums1.length; i++){
            queue.add(new int[]{nums1[i] + nums2[0], 0});
        }

        // while the queue isn't empty and k > 0, pop the first elemenet (smallest remaining) then add a new pair containing the currently popped element 1 + the next element 2
        while(k > 0 && !queue.isEmpty()){
            List<Integer> pair = new ArrayList<Integer>(2);
            int[] min = queue.poll();
            // min won't be null because queue would be empty thus condition failed
            pair.add(min[0] - nums2[min[1]]);
            pair.add(nums2[min[1]]);
            res.add(pair);
            if(min[1] + 1 < nums2.length){
                queue.add(new int[]{min[0] - nums2[min[1]] + nums2[min[1] + 1], min[1] + 1});                
            }
            k--;
        }
        return res;
    }
}
