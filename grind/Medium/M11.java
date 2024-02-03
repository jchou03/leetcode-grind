package grind.Medium;

// container with the most water
/*
 * runtime: O(n) 22%
 * memory: O(1) 72%
 */

 /*
understand:
- given array of height where there are n vertical lines drawn
- need to find the 2 lines (+ x axis) form a container such that the container contains the most water

plan:
- since the area that the container can store, we can start at the 2 ends of the array
- calculate area, and then move the lower side toward the center (since moving the higher side toward the center could decrease the container size)

runtime: 89%, memory: 57%
*/

public class M11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
    // public int maxArea(int[] height) {
    //     int maxWater = 0;
    //     int p1 = 0;
    //     int p2 = height.length-1;
    //     while(p1 < p2){
    //         int curWater = Math.min(height[p1], height[p2]) * (p2 - p1);
    //         maxWater = Math.max(maxWater, curWater);
    //         if(height[p1] < height[p2]){
    //             p1++;
    //         }else{
    //             p2--;
    //         }
    //     }
    //     return maxWater;
    // }
}
