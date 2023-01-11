package grind.Easy;

// Running Sum of 1d Array
class Solution {
    private class ArrayStack {
        int length;
        int index;
        int[] stack;

        public ArrayStack(int length){
            this.length = length;
            this.index = 0;
            this.stack = new int[length];
        }

        public boolean push(int val){
            if (index >= length) {
                return false;
            }else{
                stack[index++] = val;
                return true;
            }
        }
    }

    public int[] runningSum(int[] nums) {
        ArrayStack runSum = new ArrayStack(nums.length);
        int prev = 0;
        for (int i = 0; i < nums.length; i++){
            prev += nums[i];
            runSum.push(prev);
        }
        return runSum.stack;
    }
}