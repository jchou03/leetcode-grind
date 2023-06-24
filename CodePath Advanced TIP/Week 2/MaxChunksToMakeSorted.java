/*

Understand: 
    - given array
    - determine what the maximum number of chunks (that when sorted) 

Match: 
    - array problem

Plan:
    - use a recursive approach where you try to split it once (then recursivly call it on the smaller bits)
    - on individual method call
        - iterate over the range in array (check if this is a valid splitting index)
        - trivial solution O(n^2)

Examine:
    - inefficient solution
    - runtime: O(n^3)
    - memory: O(1)
 */

//  runtime: 5% memory: 5%

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        return 1 + helper(arr, 0, arr.length);
    }
    // total array, start index (0 indexed), end index (not inclusive)
    private int helper(int[] arr, int start, int end){
        int frontMax;
        int backMin;
        for(int i = start; i < end; i++){
            frontMax = -1;
            backMin = -1;
            for(int j = start; j < end; j++){
                if(j <= i && (frontMax == -1 || frontMax < arr[j])){
                    frontMax = arr[j];
                }
                if(j > i && (backMin == -1 || backMin > arr[j])){
                    backMin = arr[j];
                }
            }
            if(frontMax != -1 && backMin != -1 && frontMax <= backMin){
                System.out.printf("frontMax: %d backMin: %d and i: %d\n", frontMax, backMin, i);
                return 1 + helper(arr, start, i + 1) + helper(arr, i + 1, end);
            }
        }
        return 0;
    }
}
