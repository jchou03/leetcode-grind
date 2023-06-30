/*
Understand
    - given 2 sorted arrays (in ascending order)
    - need to return k pairs with the smallest sums of (u, v) with one element from each array (no duplicates)

Match
    - array problem with 2 pointers (1 for each array)

Plan
    - 2 pointers (1 for each array)
    - add the lowest pair to the list, then incremenet the pointer that is the smaller value

Implement

Review

Examine

 */

import java.util.*;

public class KPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> kPairs = new ArrayList<List<Integer>>();
        int i = 0;
        int j = 0;
        ArrayList<Integer> pair;
        // System.out.println("\n beginning new test where k = " + k);
        while(kPairs.size() < k && i < nums1.length && j < nums2.length){
            // System.out.printf("size: %d, i: %d, j: %d\n",kPairs.size(), i, j);
            pair = new ArrayList<Integer>(2);
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            kPairs.add(pair);
            if(i + 1 < nums1.length && (j + 1 >= nums2.length || nums1[i + 1] < nums2[j + 1])){
                i++;
            }else{
                j++;
            }
        }
        return kPairs;
    }
}
