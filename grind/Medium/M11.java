package grind.Medium;

// container with the most water
/*
 * runtime: O(n) 22%
 * memory: O(1) 72%
 */

public class M11 {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int p1 = 0;
        int p2 = height.length-1;
        while(p1 < p2){
            int curWater = Math.min(height[p1], height[p2]) * (p2 - p1);
            maxWater = Math.max(maxWater, curWater);
            if(height[p1] < height[p2]){
                p1++;
            }else{
                p2--;
            }
        }
        return maxWater;
    }
}
