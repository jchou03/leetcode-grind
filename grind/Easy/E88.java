package grind.Easy;
import java.util.*;

// merge two sorted arrays
// quite inefficient at the moment (runtime: 5%, memory: 29%)

public class E88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // first move nums1 elements to the back
        if(n > 0 && m > 0){
            for(int k = m - 1; k >= 0; k--){
                nums1[k + (nums1.length - m)] = nums1[k];
            }
        }
        System.out.println(Arrays.toString(nums1));
        int i = nums1.length - m;
        int j = 0;
        for(int k = 0; k < nums1.length; k++){
            System.out.println(Arrays.toString(nums1));
            if(i < nums1.length && j < n){
                if(nums1[i] < nums2[j]){
                    nums1[k] = nums1[i];
                    i++;
                }else{
                    nums1[k] = nums2[j];
                    j++;
                }
            }else if(i >= nums1.length && j < n){
                System.out.println("gay");
                nums1[k] = nums2[j];
                j++;
            }
            System.out.println(Arrays.toString(nums1));
        }
    }
}
