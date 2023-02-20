package grind.Medium;

// container with the most water
// currently wrote O(n^2) solution, takes too long

public class M11 {
    public int maxArea(int[] height) {
        // simple solution, write O(n^2) algo to check every combination of lines
        int maxWater = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = 0; j < height.length; j++){
                int water = (j - i) * Math.min(height[i], height[j]);
                if(water > maxWater) maxWater = water;
            }
        }
        return maxWater;
    }
}
