/*
 * Understand: 
 *  - given an mxn array representing ocean area, each index contains 1 if land, 0 if water
 *  - need to find the largest island (landmass of adjacent 1's)
 *  - return 0 if no islands
 * 
 * Match
 *  - graph traversal problem
 *  - use DFS or BFS to explore islands
 * 
 * Plan
 *  - iterate over each index until you find land
 *      - once land is found, use BFS or DFS to find the size of the island
 *          - use coordinate stacking
 *      - keep track of max land
 * 
 */

import java.util.*;
public class MaxIsland {
    public int maxIsland(int[][] area){
        int maxLand = 0;
        // keep track of visited indicies so we avoid exploring islands we've already explored
        Set<String> explored = new HashSet<String>(area.length * area[0].length);
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[0].length; j++){
                // check for islands
                int[] coord = new int[]{i, j};
                if(!explored.contains(Arrays.toString(coord)) && area[i][j] == 1){
                    Stack<int[]> stack = new Stack<int[]>();
                    stack.add(new int[]{i, j});
                    int curCount = 
                    while(!stack.empty()){

                    }
                }
                explored.add(Arrays.toString(new int[]{i, j}));
            }
        }
        String test = ";";
        test.equals
    }

    private String coord(int i, int j){
        return "(" + i + "," + j;
    }
}
