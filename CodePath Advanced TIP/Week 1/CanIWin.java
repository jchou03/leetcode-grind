// can you win
// https://courses.codepath.org/courses/tip103/unit/1#!session_two

import java.util.*;

public class CanIWin {
    public static void main(String[] args){
        CanIWin test = new CanIWin();
        System.out.println(test.canIWin(2, 2));
    }

/*
 * 1 <= maxChooseableInteger <= 20
 * 0 <= desiredTotal <= 300
 * 
 * test cases: 
 * Input: maxChoosableInteger = 10, desiredTotal = 11
    Output: false
 * 
 * Input: maxChoosableInteger = 10, desiredTotal = 0
    Output: true
 * 
 * Input: maxChoosableInteger = 10, desiredTotal = 1
    Output: true

    // always think of a very simple/trivial case (especially with recursion, think of the base case where you can determine the answer for sure)

    // in order to solve this problem, we need to check whether or not you can win at each game state
    // there are 2^n possible configurations of game state where n = maxChoosableInteger
    // use a boolean array to store which numbers can still be used in the game
    // then recursevly check each game state (set each number chosen to false until you test all possible combinations)

 */
    // map stores whether or not the current player can win given a certain game state
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    private boolean canIWin(int maxChoosableInteger, int desiredTotal){
        // first check whether or not either player can even win. If the total sum is less than the goal,
        // neither player wins, so false (use algebraic series formula to check)
        if((maxChoosableInteger + 1) * maxChoosableInteger/2 < desiredTotal) return false;

        // check for the edge case where the total is 0 to begin with, therefore the first player would win
        if(desiredTotal <= 0) return true;

        // if it is possible for one player to win, we need to check whether or not the first player can win
        boolean[] usableNums = new boolean[maxChoosableInteger];
        for(int i = 0; i < maxChoosableInteger; i++){
            usableNums[i] = true;
        }
        boolean res = winOnCurState(usableNums, desiredTotal);
        // System.out.println(map);
        return res;
    }

    // takes in the current game state, the total desired, and the map (memoization)
    private boolean winOnCurState(boolean[] state, int total){
        String stateString = Arrays.toString(state);
        // System.out.printf("state: %s, total: %d\n", stateString, total);
        // first check if the current game state has been calculated already. If it has, then use the pre-computed value
        if(map.get(stateString) != null) return map.get(stateString);
        // if it hasn't, then calculate whether or not you can win from this state
        else{
            // if the total is <= 0, then you already lost
            if(total <= 0){
                map.put(stateString, false);
                return false;
            }else{
                // next iterate over the possible move choices
                for(int i = 0; i < state.length; i++){
                    if(state[i]){
                        // System.out.println(i);
                        // if the current number is a valid choice, then check if the next player loses on the next game state
                        state[i] = false;
                        // if the next player loses, then we win
                        if(!winOnCurState(state, total - (i + 1))){
                            map.put(stateString, true);
                            state[i] = true;
                            return true;
                        }else{
                            // System.out.printf("state: %s and this is a losing position\n", Arrays.toString(state));
                            map.put(stateString, false);
                        }

                        state[i] = true;
                    }
                }
                // System.out.printf("state at end of the loop where this is a losing position: %s\n", Arrays.toString(state));
                // if we reached the end of the loop, that means none of our possible moves lead to a winning move,
                // therefore we lose in this positon, so this game position is a losing position
                map.put(stateString, false);
                return false;
            }        
        }
    }
}
