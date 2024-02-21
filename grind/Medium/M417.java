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

    runtime: 98%, memory: 78%
    */
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // pacific population
        for(int i = 0; i < rows; i++){
            dfs(heights, pacific, i, 0, heights[i][0]);
        }
        for(int i = 0; i < cols; i++){
            dfs(heights, pacific, 0, i, heights[0][i]);
        }

        // atlantic population
        for(int i = 0; i < rows; i++){
            dfs(heights, atlantic, i, cols - 1, heights[i][cols - 1]);
        }
        for(int i = 0; i < cols; i++){
            dfs(heights, atlantic, rows - 1, i, heights[rows - 1][i]);
        }

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(i);
                    sol.add(j);
                    res.add(sol);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight){
        int rows = heights.length, cols = heights[0].length;
        // this cell has been visited or out of bounds
        if(r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || heights[r][c] < prevHeight) return;
        int[] rm = {0, 0, 1, -1};
        int[] cm = {1, -1, 0, 0};
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            dfs(heights, visited, r + rm[i], c + cm[i], heights[r][c]);
        }
    }
}
