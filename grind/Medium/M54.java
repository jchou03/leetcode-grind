package grind.Medium;

import java.util.ArrayList;
import java.util.List;

/*
Understand: 
- need to determine the spiral order of the values in the list

plan:
- use recursive solution to add the border to the list and recursively solve for smaller rectangles

runtime: 100%, memory: 10%

*/

public class M54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        return border(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private List<Integer> border(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd){
        List<Integer> res = new ArrayList<Integer>();
        if(rowStart > rowEnd || colStart > colEnd){
            return res;
        }
        for(int i = colStart; i <= colEnd; i++){
            res.add(matrix[rowStart][i]);
        }
        for(int i = rowStart + 1; i <= rowEnd; i++){
            res.add(matrix[i][colEnd]);
        }
        if(rowEnd > rowStart && colEnd > colStart){
            for(int i = colEnd - 1; i >= colStart; i--){
                res.add(matrix[rowEnd][i]);
            }
            for(int i = rowEnd - 1; i >= rowStart + 1; i--){
                res.add(matrix[i][colStart]);
            }
        }
        res.addAll(border(matrix, rowStart+1, rowEnd - 1, colStart+1, colEnd-1));
        return res;
    }
}
