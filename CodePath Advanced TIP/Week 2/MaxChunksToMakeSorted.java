/*

Understand: 
    - given array
    - determine what the maximum number of chunks (that when sorted) 

Match: 
    - array problem
    - Hash & Store
    - 2 pointer
    - Sort

Plan:
    - use a recursive approach where you try to split it once (then recursivly call it on the smaller bits)
    - on individual method call
        - iterate over the range in array (check if this is a valid splitting index)
        - trivial solution O(n^2)

    better solution:
    - use multiple passes
    - use an array to store the minimum value on the right side of an index (inclusive)
    - then iterate over the original array, and if the max value on the left is less or equal to the min on the right, then increment number of chunks

Examine:
    - inefficient solution
    - runtime: O(n^3)
    - memory: O(1)
 */

//  runtime: 5% memory: 5%

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int numChunks = 0;
        int leftMax = arr[0];
        int[] rightMins = new int[arr.length];
        int tempMin = arr[arr.length - 1];
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] < tempMin){
                tempMin = arr[i];
            }
            rightMins[i] = tempMin;
        }
        for(int i = 0; i < arr.length; i++){
            if(leftMax < arr[i]){
                leftMax = arr[i];
            }
            if(leftMax <= rightMins[i]){
                numChunks++;
            }
        }
        return numChunks;
    }
}
