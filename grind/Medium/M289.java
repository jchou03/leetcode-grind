package grind.Medium;

/*
understand:
- given a board, calculate the next state of the game of life
- births and deaths occur simultaneously
game rules for each cell:
    - live cell w/ less than 2 live neighbors dies
    - live cell with 2-3 live neighbors live
    - live cell with more than 3 neighbors die
    - dead cell with exactly 3 live neighbors become live

plan:
- use an m x n matrix to store the new live/dead status
- iterate over each square and identify the new status of each cell
    - can improve using O(n) space by only storing one row

runtime: O(mn) 100%
memory: O(mn) 21%

*/


public class M289 {
    public void gameOfLife(int[][] board) {
        boolean[][] newBoard = new boolean[board.length][];
        for(int i = 0; i < board.length; i++){
            newBoard[i] = new boolean[board[0].length];
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                newBoard[i][j] = live(board, i, j);
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = newBoard[i][j] ? 1 : 0;
            }
        }
    }

    // calcualte if the cell at r, c will live or die
    public boolean live(int[][] board, int r, int c){
        // check number of live neighbors
        int liveCount = 0;
        for(int i = r - 1; i <= r + 1; i++){
            for(int j = c - 1; j <= c+1; j++){
                if((i >= 0 && i < board.length && j >= 0 && j < board[0].length) && (i != r || j != c) && board[i][j] == 1){
                    liveCount++;
                }
            }
        }
        // calculate live/dead status
        if(board[r][c] == 1){ return (liveCount >= 2 && liveCount <= 3);}
        else{ return (liveCount == 3);}
    }
}
