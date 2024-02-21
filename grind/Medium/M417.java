package grind.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M417 {
    /*
    understand:
    - m x n island
    - heights[r][c] = height above sea level of given square
    - rain water can flow to neighboring cells in cardinal directions
        - ran water can flow to neighboring cell iff neighbor height <= cur cell height
    - water can flow from any cell adjacent to an ocean into the ocean
    - need to return 2D list of grid coords where rain water landing there can reach both Pacific (top and left) and Atlantic (right and bottom)
    - all heights are non-negative
    
    plan:
    - use DP to store previous calculations
        - if it is possible to reach a solution square, automatically pass
    - use dfs to explore possible paths for rainwater (if reaching the pacific ocean)
    */
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<String> sols = new HashSet<String>();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                int result = dfs(heights, i, j, new HashSet<String>(), sols);
                if(result == 3){
                    ArrayList<Integer> ls = new ArrayList<Integer>();
                    ls.add(i);
                    ls.add(j);
                    res.add(ls);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] heights, int r, int c, Set<String> visited, Set<String> sols){
        boolean pacific = false;
        boolean atlantic = false;
        // return 0 if it is an invalid path, return 1 if it can touch pacific ocean, return 2 if it can touch atlantic, 3 if both
        if((r == 0 && c == heights[0].length - 1) || (r == heights.length - 1 && c == 0) || sols.contains(r+","+c)){
            sols.add(r+","+c);
            return 3;
        }
        
        if(r == 0 || c == 0){
            pacific = true;
        }
        if(r == heights.length - 1 || c == heights[0].length - 1){
            atlantic = true;
        }

        visited.add(r+","+c);

        int[] rm = {0, 0, 1, -1};
        int[] cm = {1, -1, 0, 0};
        for(int i = 0; i < 4; i++){
            int newR = r + rm[i];
            int newC = c + cm[i];
            if(newR >= 0 && newR < heights.length && newC >= 0 && newC < heights[0].length && heights[newR][newC] <= heights[r][c] && !visited.contains(newR+","+newC)){
                int res = dfs(heights, newR, newC, visited, sols);
                if(res == 3){
                    sols.add(r+","+c);
                    return 3;
                }else if(res == 1){
                    pacific = true;
                }else if(res == 2){
                    atlantic = true;
                }
            }
        }
        if(pacific && atlantic){
            sols.add(r+","+c);
            return 3;
        }else if(pacific){
            return 1;
        }else if(atlantic){
            return 2;
        }else{
            return 0;
        }
    }
}
