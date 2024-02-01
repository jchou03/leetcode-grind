package grind.Medium;

/*
 * product of all elements in array other than self (O(n) with no use of division)
 * runtime: 100%, memory: 55%
 */

public class M238 {
    public int[] productExceptSelf(int[] nums) {
        // create two arrays, one that stores the products of all numbers from 0 to i - 1
        // the other stores the products of all numbers from nums.length - i + 1

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for(int j = nums.length - 2; j >= 0; j--){
            suffix[j] = suffix[j + 1] * nums[j + 1];
        }

        // find product
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    // public int[] productExceptSelf(int[] nums) {
    //     // use dp to store the left and right products of each index
    //     int[] res = new int[nums.length];

    //     int left = 1;
    //     for(int i = 0; i < nums.length; i++){
    //         res[i] = left;
    //         left *= nums[i];
    //     }
    //     int right = 1;
    //     for(int i = nums.length - 1; i >= 0; i--){
    //         res[i] = res[i] * right;
    //         right *= nums[i];
    //     }

    //     return res;
    // }
}
