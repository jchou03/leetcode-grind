/*
Understand
    - there are 2 input arrays of pushed and popped that contain ints
    - return true if this is a possible sequence, false if not
    - this should be done on an initially empty stack

    happy case
        pushed = [1,2,3,4,5], popped = [4,5,3,2,1] -> true
        pushed = [1,2], popped = [1] -> true
    
    edge case
        pushed = [1,2] popped = [1,2,3] -> false

Match
    - since we are trying to validate a stack, we can utilize a stack to mimic the stack operations

Plan
    - create a stack and add elements in from the pushed array
    - keep track of index of the next pop and validate against top of stack
 */

import java.util.*;

public class ValidateStackSequences {
    public static void main(String[] args){
        int[][] test_inputs = new int[][]{
            new int[]{1,2,3,4,5},
            new int[]{1,2},
            new int[]{1,2}
        };
        int[][] test_outputs = new int[][]{
            new int[]{4,5,3,2,1},
            new int[]{1},
            new int[]{1,2,3}
        };
        boolean[] answers = new boolean[]{true,true,false};
        for(int i = 0; i < test_inputs.length; i++){
            System.out.printf("Beginning test %d\n", i+1);
            boolean res = validateStackSequences(test_inputs[i], test_outputs[i]);
            System.out.printf("Test %s res: %b answer: %b\n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);

        }
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped){
        if(popped.length > pushed.length) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;
        for(int i = 0; i < pushed.length; i++){
            // System.out.println(stack);
            if(popIndex >= popped.length) break;
            stack.push(pushed[i]);
            if(popped[popIndex] == stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        while(popIndex < popped.length){
            // System.out.println(stack);
            if(popped[popIndex] != stack.peek()){
                return false;
            }else{
                popIndex++;
                stack.pop();
            }
        }
        return true;
    }
}
