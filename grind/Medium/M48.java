package grind.Medium;

/*
understand:
- Given matrix of integers
- need to rotate the matrix by 90 degrees clockwise
- must be done in place
- square matrix (n x n)

plan:
- can recursively solve each "layer" at a time
- use a temp variable to store the "replaced" value

runtime: 100%, memory: 22%
*/

public class M48 {
    public void rotate(int[][] matrix) {
        rotateLayer(matrix, 0);
    }

    private void rotateLayer(int[][] matrix, int layer){
        // base case of if there is 1 or 0 squares within this square
        if(matrix.length - (layer * 2) <= 1){
            return;
        }

        // calculate ending index for rows/columns
        int end = matrix.length - layer - 1;

        int t1 = -1, t2 = -1;

        for(int i = 0; i < matrix.length - 1 - (layer * 2); i++){
            // top to right
            t1 = matrix[layer + i][end];
            matrix[layer + i][end] = matrix[layer][layer + i];
            // right to bot
            t2 = matrix[end][end - i];
            matrix[end][end - i] = t1;
            // bot to left
            t1 = matrix[end - i][layer];
            matrix[end - i][layer] = t2;
            // left to top
            matrix[layer][layer + i] = t1;
        }

        rotateLayer(matrix, layer + 1);
    }
}
