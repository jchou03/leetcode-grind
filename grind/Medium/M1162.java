package grind.Medium;

import java.util.*;

// As far from land as possible
// currently gets stuck in an infitinte loop when the entire board is 0

public class M1162 {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){this.x = x; this.y=y;}
        @Override
        public String toString(){
            return ("(" + x + ", " + y + ")");
        }
    }

    public int maxDistance(int[][] grid) {
        if(!cont(grid)) return -1;
        int maxDist = 0;
        // use a loop to iterate over every square in the matrix
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // at each point, if it is water, check for dist to land
                if(grid[i][j] == 0){
                    Queue<Pair> queue = new LinkedList<Pair>();
                    queue.add(new Pair(j, i));
                    while(!queue.isEmpty()){
                        Pair p = queue.poll();
                        // System.out.println(p + ": " + grid[p.y][p.x]);
                        if(grid[p.y][p.x] == 1){
                            // record the closest land dist
                            if(maxDist < dist(i, j, p.y, p.x)){
                                maxDist = dist(i, j, p.y, p.x);
                            }
                            // System.out.println(j + ", " + i + " : maxdist: " + dist(i, j, p.y, p.x));
                            break;
                        }else{
                            // use BFS to explore nearby squares 
                            if(p.y - 1 >= 0) queue.add(new Pair(p.x, p.y - 1));
                            if(p.y + 1 < grid.length) queue.add(new Pair(p.x, p.y+1));
                            if(p.x - 1 >= 0) queue.add(new Pair(p.x-1, i));
                            if(p.x + 1 < grid[0].length) queue.add(new Pair(p.x+1, i));

                        }
                    }
                }
                    
            }
        }
        
        // return max dist
        return maxDist;
    }

    private boolean cont(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    private int dist(int x0, int y0, int x1, int y1){
        return Math.abs(x0 - x1) + Math.abs(y0-y1);
    }
}
