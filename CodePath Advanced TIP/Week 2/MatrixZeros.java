/*

We need to replace a matrix where any row or column has a 0 to be all 0's

array/matrix problem

plan:
    - use 2 arrays to store whether or not rows should be 0'd or not
    - then iterate over matrix and mark which rows/cols to be set to 0
    - set rows/cols to 0


examine:
    - space: O(n + m)
    - runtime: O(n * m)


 */

// M73
// runtime: 100%, memory: 60%

import java.util.*;

public class MatrixZeros {

    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        // array default value is false
        // iterate over matrix to determine which rows should be set to 0 then set row/col array to true
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < cols.length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < rows.length; i++){
            if(rows[i]){
                for(int j = 0; j < cols.length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < cols.length; j++){
            if(cols[j]){
                for(int i = 0; i < rows.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        // System.out.println(Arrays.toString(rows));
    }
}
