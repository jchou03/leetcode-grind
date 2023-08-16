package grind.Hard;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * find the maximum amount of water that can be trapped within a shape
 * use a 2 pointer solution 
 *  - keep track of a left and right pointer, and the maximum height on each side
 *  - move the pointer on the side with the lower max height toward the center (since we have a potential to trap rainwater between the max heights)
 *      - if the pointer is a new max height for the side, update the max height on that side
 *      - else we are in an area that can trap water, so get the water above the current index and add it to the total
 *  - return total 
 */

public class H42 {
    public static void main(String[] args){
        int[][] tests = new int[][]{
            new int[]{0,1,0,2,1,0,1,3,2,1,2,1},
            new int[]{4,2,0,3,2,5}
        };
        int[] answers = new int[]{6, 9};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i + 1);
            int res = trap(tests[i]);
            System.out.printf("Test %s res: %d answer: %d\n\n", (res == answers[i] ? "Passed!" : "Failed :("), res, answers[i]);
        }
    }


    public static int trap(int[] height) {
        int left = 0;
        int leftMax = height[0];
        int right = height.length - 1;
        int rightMax = height[height.length - 1];
        int trappedRainWater = 0;
        while(left < right){
            if(leftMax < rightMax){
                // System.out.println("left: " + left);
                left++;
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else{
                    trappedRainWater += leftMax - height[left];
                }
            }else{
                // System.out.println("right: " + right);
                right--;
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else{
                    trappedRainWater += rightMax - height[right];
                }
            }
        }
        
        return trappedRainWater;
    }
}
