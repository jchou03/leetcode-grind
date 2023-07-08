/*
Understand
    given an array of size m x n of ints
    heights[i][j] = the height of the person standing at index i,j
    a person can see another person who is on the right or to the bottom of them and if all of the 
        people in between them are lower than the 2 heights
            - in order to determine if a person can see another person, we need to know the max value of neighbors

    oberservation:
        - all people that aren't the bottom right person will be able to see at least 1 person (person to their right, or person below them)

Match
    - what data structures would be able to use memory to reduce the runtime?
        - what could we push onto a stack that could help us with this problem?
            - we can iterate from down to up/right to left and push elements that other people could see
            - if a person in the stack is shorter than the current person, then later people can't see the stack person so we can remove
            them so people in the stack are the only people that could be seen by later people

Plan
    // - currently plan to implement the trivial solution by iterating over the row and column for each index
    //     - at each coord i,j : keep track of the max as you go to the right/down, and if the current index is greater than the max, update max as well as number of people that person can see
    use a stack to keep track of potential people that can be seen
    split calculations by rows and columns
        - when calculating for rows, start at the end of each row
            - at each coordinate i,j : check if the stack (people who could be seen) is empty
                - if it is empty, the current person could be seen
                - if it isn't empty, check if their height is less than the current height, pop from stack (because then cur person would block other people from seeing them)
                    - if the person on top of stack is same height or taller than cur person, we won't be able
                    to see past them, so stop here
                - add the current element to the stack if it is empty or if the cur element isn't the same as
                the top stack element

 */
import java.util.*;

public class GridSee {
    public int[][] gridSee(int[][] heights){
        int m = heights.length, n = heights[0].length;
        int[][] res = new int[m][n];
        Stack<Integer> stack = new Stack<Integer>();

        // calculate the people you can see in each col
        for(int i = 0; i < m; i++){
            for(int j = n-1; j >=0; j--){
                int cur = heights[i][j];
                // remove all of the ones we will block from the stack (later people can't see them)
                while(!stack.isEmpty() && stack.peek() < cur){
                    res[i][j] += 1;
                    stack.pop();
                }
                // since this next person is our height or higher, check if there is a person and if so increment count
                if(!stack.isEmpty()){
                    res[i][j] += 1;
                }
                // add our element to the stack so later people can see current person
                if(stack.isEmpty() || heights[i][j] != stack.peek()){
                    stack.push(heights[i][j]);
                }
            }
        }

        // calculate for people in each row
        for(int j = 0; j < n; j++){
            for(int i = m-1; i >=0; i--){
                int cur = heights[i][j];
                // remove all of the ones we will block from the stack (later people can't see them)
                while(!stack.isEmpty() && stack.peek() < cur){
                    res[i][j] += 1;
                    stack.pop();
                }
                // since this next person is our height or higher, check if there is a person and if so increment count
                if(!stack.isEmpty()){
                    res[i][j] += 1;
                }
                // add our element to the stack so later people can see current person
                if(stack.isEmpty() || heights[i][j] != stack.peek()){
                    stack.push(heights[i][j]);
                }
            }
        }

        return res;
    }
}
