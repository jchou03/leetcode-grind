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

Implement

Review

Examine

 */

import java.util.*;

public class KPairs {
    public class Comp implements Comparator<List<Integer>>{
        // Comparator for pairs of integers in the form of lists
        public int compare(List<Integer> l1, List<Integer> l2){
            int sum1 = 0;
            for(int i = 0; i < l1.size(); i++){
                sum1 += l1.get(i);
            }
            int sum2 = 0;
            for(int i = 0; i < l2.size(); i++){
                sum2 += l2.get(i);
            }
            return sum1 - sum2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(k, new Comp());
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                ArrayList<Integer> pair = new ArrayList<Integer>(2);
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                queue.add(pair);
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < k; i++){
            res.add(queue.poll());
        }
        return res;
    }
}
