/*
Understand
    - we are given an array if ints
    - need to determine all of the possible ways to get 3 unique numbers in the array to add up to 0

    happy case:
        nums = [-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
        nums = [-10,-2,-1,0,3,7,] -> [[-10,3,7],[-2,-1,3]]
    
    edge case:
        nums = [1,0] -> []
        nums = [-10,-3,-2,-1,0] -> []

Match:
    - array problem, we can utilize sorting
    - a naive solution could end up as O(n^3)

Plan:
    - first sort the array
    - find 0 (or the positive/negative flipping index)
    - iterate over the array checking each index
        - try to solve 2sum for this solution
        - use a hashmap to look for the remaining numbers
        - O(n^2) solution

    - there is a O(nlogn) solution that is O(n) after sorting by using a 2 pointer sliding window solution
    - try implementing
 */

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
        int[][] tests = new int[][]{
            new int[]{-1,0,1,2,-1,-4},
            new int[]{-10,-2,-1,0,3,7},
            new int[]{1,2},
            new int[]{-10,-3,-2,-1,0}
        };

        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n[", i + 1);
            int[][] res = threeSum(tests[i]);
            for(int j = 0; j < res.length; j++){
                System.out.printf("%s,", Arrays.toString(res[j]));
            }
            System.out.printf("]\n\n");
        }
    }

    public static int[][] threeSum(int[] arr){
        HashMap<Integer, Integer> map;
        // first sort the array
        Arrays.sort(arr);
        // then find the index of 0 (or the index of the first positive number)
        int pos = Arrays.binarySearch(arr, 0);
        ArrayList<int[]> res = new ArrayList<int[]>();
        // choose a negative number for the first number
        for(int i = 0; i < pos; i++){
            map = new HashMap<Integer, Integer>();
            int curVal = -arr[i];
            // int minNeeded = Integer.MAX_VALUE; // slight optimization where we stop if the values are too small to fulfill the requirements in 3 numbers
            // next iterate over array backwards in positive side
            for(int j = arr.length - 1; j >= i; j--){
                // successfully found a triplet that works
                if(map.containsKey(arr[j])){
                    res.add(new int[]{arr[i], arr[j], map.get(arr[j])});
                    break;
                }else{
                    map.put((curVal - arr[j]), arr[j]);
                }
                
            }
        }
        int[][] finalRes = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
}
