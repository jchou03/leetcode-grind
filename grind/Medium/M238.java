package grind.Medium;

public class M238 {
    public int[] productExceptSelf(int[] nums) {
        // use dp to store the left and right products of each index
        int[] res = new int[nums.length];

        int left = 1;
        for(int i = 0; i < nums.length; i++){
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * right;
            right *= nums[i];
        }

        return res;
    }
}
