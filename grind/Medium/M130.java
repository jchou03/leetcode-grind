package grind.Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
understand:
- given a m x n board that contains 'X' and 'O'
- need to flip all 'O' into 'X' if it is surrounded in all 4 directions by an 'X'
    - must flip regions as a whole, but if the region is on the border, it isn't flipped
    - no return value, but need to update 

plan:
- iterate through the board until you find an 'O'
- use BFS to explore the neighboring 'O' and store in a list (or other data structure)
- if the full region is not touching border, then replace all regions with 'X'

*/

public class M130 {
    public void solve(char[][] board) {
        HashSet<Coord> visited = new HashSet<Coord>();
        // ignore checking for border
        for(int i = 1; i < board.length - 1; i++){
            for(int j = 1; j < board[0].length - 1; j++){
                // if coord is 'O' run DFS to explore all relevant coords
                if(board[i][j] == 'O' && !visited.contains(new Coord(i, j))){
                    Queue<Coord> q = new LinkedList<Coord>();
                    HashSet<Coord> coords = new HashSet<Coord>();
                    boolean border = false;

                    q.offer(new Coord(i, j));
                    
                    while(!q.isEmpty()){
                        Coord cur = q.poll();
                        if(!coords.contains(cur)) coords.add(cur);
                        if(cur.r == 0 || cur.r == board.length - 1 || cur.c == 0 || cur.c == board[0].length) border = true;
                        // top
                        if(cur.r - 1 >= 0) q.offer(new Coord(cur.r - 1, cur.c));
                        // left
                        if(cur.c - 1 >= 0) q.offer(new Coord(cur.r, cur.c - 1));
                        // right
                        if(cur.c + 1 < board[0].length) q.offer(new Coord(cur.r, cur.c + 1));
                        // bot
                        if(cur.r + 1 < board.length) q.offer(new Coord(cur.r + 1, cur.c));
                    }

                    // either flip the characters or add to visited
                    if(border){
                        visited.addAll(coords);
                    }else{
                        for(Coord c : coords){
                            board[c.r][c.c] = 'X';
                        }
                    }
                }
            }
        }
    }

    class Coord{
        int r;
        int c;
        public Coord(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
