package grind.need_improvement;
import java.util.*;

// find the difference between two arrays
// runtime: 36%, memory: 19%

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // use two hashmaps then iterate over both
        HashSet<Integer> a = new HashSet<Integer>();
        HashSet<Integer> b = new HashSet<Integer>();
        HashSet<Integer> c = new HashSet<Integer>();
        HashSet<Integer> d = new HashSet<Integer>();

        for(int i = 0; i < nums1.length; i++){
            a.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            b.add(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            if(!b.contains(nums1[i])){
                c.add(nums1[i]);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            if(!a.contains(nums2[i])){
                d.add(nums2[i]);
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>(2);
        result.add(new ArrayList(c));
        result.add(new ArrayList(d));
        return result;
    }
}
