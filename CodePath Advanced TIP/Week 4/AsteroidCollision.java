/*
Understand
    - input is an array of ints
    - the asolute val of the int is the size of asteroid, and the sign is the direction
    - asteroids traveling in the same direction never crash
    - if asteroids go opposite directions, they will crash and the smaller of the 2 is destroyed 
        - if same size, they both are destroyed
    - is zero a valid asteroid val?

    happy cases:
        [5,10,-5] -> [5, 10]
        [8,-8] -> []
        [-5,-1,10,3,-10] -> [-5,-1]

    edge cases:
        [] -> []
        [1] -> [1]

match:
    - 2 pointers gives us the ability to reference 2 asteroids at the same time
    - a stack gives us an ability to store the non-destroyed asteroids as we iterate over array

plan:
    - use a stack
    - if asteroid at index i is the same sign as the asteroid at top of stack (if non empty)
    then add it to the stack
        - if the stacked one is smaller, then pop off stack and check with next element on stack
        - else destroy the one at index i and move on
    - convert remaining stack into res array
 */

 import java.util.*;

public class AsteroidCollision {
    public static void main(String[] args){
        int[][] tests = new int[][]{
            new int[]{5,10,-5},
            new int[]{8,-8},
            new int[]{-5,-1,10,3,-10},
            new int[0],
            new int[]{1}
        };
        int[][] answers = new int[][]{
            new int[]{5,10},
            new int[0],
            new int[]{-5,-1},
            new int[0],
            new int[]{1}
        };
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i+1);
            String res = Arrays.toString(asteroidCollision(tests[i]));
            String testAnswer = Arrays.toString(answers[i]);
            System.out.printf("Test %s res: %s, answers: %s\n\n", (res.equals(testAnswer) ? "Passed" : "Failed"), res, testAnswer);
        }
    }
    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<Integer>();
        int cur;
        for(int i = 0; i < asteroids.length; i++){
            cur = asteroids[i];
            if(stack.isEmpty() || stack.peek() < 0){
                stack.push(cur);
            }else if (cur < 0){
                while(!stack.isEmpty() && 0 <= stack.peek() && Math.abs(cur) > Math.abs(stack.peek())){
                    stack.pop();
                }
                // check if we need to destroy both
                if(!stack.isEmpty() && stack.peek() == -cur){
                    stack.pop();
                }
                
            }
        }

        // convert stack to int array
        int[] res = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
