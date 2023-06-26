/*

Understand: 
    - given array
    - determine what the maximum number of chunks (that when sorted) 

    happy cases: 
        - [5, 2, 1, 5, 2] -> 1
        - [2,1,3,4,4] -> 4
        - [4,2,1,4,10,3] -> 1 (the last element is smaller than the first element, therefore it has to be sorted in a single one)
        - [1,0,1,3,2] -> 3
        - [0,0,1,1,1] -> 5
        - [1,2,0,3] -> 2

    edge case:
        - [1] -> 1
        - [] -> 1

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
    - use an array to store the minimum value on the right side of an index (exclusive)
    - then iterate over the original array, and if the max value on the left is less or equal to the min on the right, then increment number of chunks

Examine:
    - inefficient solution
    - runtime: O(n^3)
    - memory: O(1)

    updated solution:
        - runtime: O(n)
        - memory: O(n)
 */

//  runtime: 5% memory: 5%

public class MaxChunksToMakeSorted {

    public static void main(String[] args){
        int[][] tests = new int[][]{new int[]{5, 2, 1, 5, 2},
                                    new int[]{2,1,3,4,4},
                                    new int[]{4,2,1,4,10,3},
                                    new int[]{1,0,1,3,2},
                                    new int[]{0,0,1,1,1},
                                    new int[]{1,2,0,3} };
        int[] answers = new int[]{1, 4, 1, 3, 5, 2};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Attempting test: %d\n", i + 1);
            int res = maxChunksToSorted(tests[i]);
            System.out.printf("Test %s, Result: %d, Answer: %d\n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);
        }
    }

    public static int maxChunksToSorted(int[] arr) {
        // handle edge case
        if(arr.length <= 1) return 1;

        int numChunks = 1;
        int leftMax = arr[0];
        int[] rightMins = new int[arr.length];
        int tempMin = arr[arr.length-1];

        // populate the rightmin array
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i + 1] < tempMin){
                tempMin = arr[i + 1];
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
        return numChunks > arr.length ? arr.length : numChunks;
    }
}
