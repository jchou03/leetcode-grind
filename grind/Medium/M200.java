package grind.Medium;

// number of islands
// runtime: 51%, memory: 16%
public class M200 {
    public int numIslands(char[][] grid) {
        // iterate over every square in the grid
        // call helper function to explore every island
        // sum total count
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    // use dfs to explore an island (setting grid to '0' after exploring)
    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;

        int[] rowMods = {0, 0, 1, -1};
        int[] colMods = {1, -1, 0, 0};

        grid[r][c] = '0';

        for(int i = 0; i < 4; i++){
            dfs(grid, r + rowMods[i], c + colMods[i]);
        }
    }
    // public int numIslands(char[][] grid) {
    //     int count = 0;
    //     for(int i = 0; i < grid.length; i++){
    //         for(int j = 0; j < grid[0].length; j++){
    //             if(delete(grid, i, j)) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // // function to convert all connected 1's to 0 (delete island)
    // private boolean delete(char[][] grid, int row, int col){
    //     if(grid[row][col] == '1'){
    //         grid[row][col] = '0';
    //         if(row - 1 >= 0 && row - 1 < grid.length && grid[row - 1][col] == '1'){
    //             delete(grid, row-1, col);
    //         }
    //         if(col - 1 >= 0 && col - 1 < grid[0].length && grid[row][col - 1] == '1'){
    //             delete(grid, row, col - 1);
    //         }
    //         if(col + 1 >= 0 && col + 1 < grid[0].length && grid[row][col + 1] == '1'){
    //             delete(grid, row, col + 1);
    //         }
    //         if(row + 1 >= 0 && row + 1 < grid.length && grid[row + 1][col] == '1'){
    //             delete(grid, row+1, col);
    //         }
    //         return true;
    //     }
    //     return false;
    // }
}
