/*
Understand
    - given an array of ints that show the height of walls
    - rainwater rains down and is trapped inside of the walls (where there is a gap between heights of the walls)
    
    happy case:
        height = [0,1,0,2,1,0,1,3,2,1,2,1] -> 6
        height = [0,2,1,0,2,0,1] -> 4
        
    edge case:
        height = [0] -> 0
        height = [] -> 0

Match
    - 2 pointer solution
    - utilizing a potential sliding window
    - utilize an iterative 2 pointer solution to keep track of the amout of rainwater caught

Plan
    - use a 2 pointer solution (2 POINTER MEANS ONE STARTS AT EACH END OF THE ARRAY)
    - keep track of the max on the left and the right side
    - increment the smaller pointer towards the center and calculate the amount of water stored above this index
    
Implement

Review

Examine
    - runtime: O(n)
    - memory: O(1)

 */
public class TrappedRainWater {
    public static void main(String[] args){
        int[][] tests = new int[][]{
            new int[]{0,1,0,2,1,0,1,3,2,1,2,1},
            new int[]{0,2,1,0,2,0,1},
            new int[]{0},
            new int[0],
        };
        int[] answers = new int[]{6,4,0,0};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i+1);
            int res = trappedRainWater(tests[i]);
            System.out.printf("Test %s res: %d answer %d \n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);
        }
    }

    public static int trappedRainWater(int[] container){
        int p1 = 0;
        int p2 = container.length - 1;
        int waterCaptured = 0;
        int leftMax = container[p1];
        int rightMax = container[p2];
        while(p1 <= p2){
            if(container[p1] < container[p2]){
                waterCaptured += Math.max(leftMax - container[p1], 0);
                if(container[p1] > leftMax) leftMax = container[p1];
                p1++;
            }else{
                waterCaptured += Math.max(rightMax - container[p2], 0);
                if(container[p2] > rightMax) rightMax = container[p2];
                p2--;
            }
        }
        return waterCaptured;
    }
}
