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
- explore the border
    - run DFS on each square to mark the "edge zones"
- iterate through the entire board and change the marked "O"
    - change all unmarked "O"s into "X"

*/

public class M130 {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for(int i = 0; i < board[0].length; i++){
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 'X' || board[r][c] == 'M') return;
        // apply mark
        board[r][c] = 'M';
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }
}
