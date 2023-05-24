package grind.Easy;
import java.util.*;

// merge two sorted arrays
// big improvement - runtime: 100%, memory: 98%


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // use an array copy to store the first m digits of nums1
        int[] copy = new int[m];
        for(int i = 0; i < m; i++){
            copy[i] = nums1[i];
        }

        int i1 = 0;
        int i2 = 0;
        while(i1 + i2 < m + n){
            if((i2 >= n) || (i1 < m && (copy[i1] < nums2[i2]))){
                nums1[i1 + i2] = copy[i1];
                i1++;
            }else{
                nums1[i1 + i2] = nums2[i2];
                i2++;
            }
        }
    }
}