/*
Understand
    - given a matrix that represents a rectangular wall of bricks (each row of bricks is the same length)
        - but each brick has a different length
    
    wall = 
  [[3, 5, 1, 1],
   [2, 3, 3, 2],
   [5, 5],
   [4, 4, 2],
   [1, 3, 3],
   [1, 1, 6, 1, 1]] -> 2

Match
    - use a hashmap to store the locations where a brick ends, and how many bricks end at that location

Plan
    - iterate over each row of the matrix
        - populate the ending indicies of bricks into a hashmap (keeping track of how many rows of bricks end at that index)
    - then iterate over the different endpoints and find the max number of bricks that end in the same location (and use inverse math to find the min number of bricks to pass through)

Implement

Review

Examine
    - runtime: O(n * m) (where m is the average number of bricks in the wall)
    - memory: O(m) (where m is the average number of bricks in the wall)
    leetcode performance: 
        runtime: 48%
        memory: 46%

 */

import java.util.HashMap;

public class BrickWall {
    public static void main(String[] args){
        int[][][] tests = new int[][][]{
            new int[][]{
                new int[]{3, 5, 1, 1},
                new int[]{2,3,3,2},
                new int[]{5,5},
                new int[]{4,4,2},
                new int[]{1,3,3},
                new int[]{1,1,6,1,1}
            }
        };
        int[] answers = new int[]{2};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i + 1);
            int res = brickWall(tests[i]);
            System.out.printf("Test %s res: %d answer: %d\n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);
        }
    }
    public static int brickWall(int[][] wall){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int curIndex;
        for(int i = 0; i < wall.length; i++){
            curIndex = 0;
            for(int j = 0; j < wall[i].length - 1; j++){
                curIndex += wall[i][j];
                if(map.containsKey(curIndex)){
                    map.put(curIndex, map.get(curIndex) + 1);
                }else{
                    map.put(curIndex, 1);
                }
            }
        }
        int maxEdges = 0;
        for(int key : map.keySet()){
            if(map.get(key) > maxEdges) maxEdges = map.get(key);
        }
        return wall.length - maxEdges;
    }
}
