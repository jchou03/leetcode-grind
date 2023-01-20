package grind.Medium;
// import java.util.*;

// Unique paths

public class M62 {
    public int uniquePaths(int m, int n) {
        // use matrix to store the grid where each position contains the number of steps it takes to reach that position
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i != 0 || j != 0){
                    int temp = 0;
                    if(i - 1 >= 0) temp += matrix[i-1][j];
                    if(j - 1 >= 0) temp += matrix[i][j-1];
                    matrix[i][j] = temp;
                }
            }
        }
        // for(int i = 0; i < m; i++){
        //     System.out.println(Arrays.toString(matrix[i]));
        // }
        return matrix[m-1][n-1];
    }
}
