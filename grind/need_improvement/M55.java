package grind.need_improvement;

// jump game: can you reach the end of the array by jumping forward with nums[i] range
// runtime: 99%, memory: 18%

// more efficient solution:
class Solution {
    public boolean canJump(int[] nums) {
        // better solution: keep track of the goal you need to cross iterating from the back of the array
        // update the goal if you can reach it from index i
        // check if you have range to reach or pass goal on current index i
        int goal = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }
}

// class Solution {
//     public boolean canJump(int[] nums) {
//         // work our way backwards from the back of the array and determine which indicies can reach the end of the array
//         // store in place since we can override the values in each index since we don't need them after calculations
//         // use -1 as the value for can reach the end from that index
//         // use -2 as the value for cannot reach the end from that index
//         if(nums.length <= 1) return true;
//         for(int i = nums.length - 2; i >= 0; i--){
//             for(int j = 0; j <= Math.min(nums[i], nums.length - i); j++){
//                 // System.out.println("i: " + i + ", " + (i + j) + ": " + nums[i + j]);
//                 if(i + j == nums.length - 1 || nums[i + j] == -1){
//                     nums[i] = -1;
//                     break;
//                 }
//             }
//             if(nums[i] != -1) nums[i] = -2;
//         }
//         // System.out.println(Arrays.toString(nums));
//         return nums[0] == -1;
//     }
// }