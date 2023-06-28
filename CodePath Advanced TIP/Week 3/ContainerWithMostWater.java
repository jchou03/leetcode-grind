/*
Understand
    - input is an int array containing the heights of walls at each index
    - need to calculate the maximum amount of water that can be stored in the container

    happy case:
        height = [1,8,6,2,5,4,8,3,7] -> 49 (walls at index 1 and 8)
        height = [1,1] -> 1
        height = [4,5,6,7,8,9] -> 20
        height = [1,100,100,1] -> 100

    edge case:
        height = [1] -> 0
        height = [] -> 0


Match
    - array problem, potentially a 2 pointer solution

Plan
    - use 2 pointers to iterate over the array
    - one pointer for each side of the container
    - start with simple solution where the walls are on either end of the container
    - then move the lower of the 2 pointers towards the middle
    - keep track of the maximum volume

Implement

Review

Examine
    runtime: O(n)
    memory: O(1)
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[][] tests = new int[][]{
            new int[]{1,8,6,2,5,4,8,3,7},
            new int[]{1,1},
            new int[]{1},
            new int[0],
            new int[]{4,5,6,7,8,9},
            new int[]{1,2,3,9,4,3,2,1},
            new int[]{1,2,3,9,1,1,1,1},
        };
        int[] answers = new int[]{49, 1, 0, 0, 20, 10, 7};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i + 1);
            int res = containerWithMostWater(tests[i]);
            System.out.printf("Test %s res: %d answer: %d\n\n", (res == answers[i] ? "Passed!" : "Failed :("), res, answers[i]);
        }
    }
    public static int containerWithMostWater(int[] container){
        if(container.length < 2) return 0;
        int maxWater = 0;
        int left = 0;
        int right = container.length - 1;

        while(left < right){
            if(maxWater < (Math.min(container[left], container[right]) * (right - left))){
                maxWater = (Math.min(container[left], container[right]) * (right - left));
            }
            if(container[left] < container[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
        

    }
}
