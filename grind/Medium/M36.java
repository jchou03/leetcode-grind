package grind.Medium;

import java.util.ArrayList;
import java.util.HashSet;

/*
understand:
- given a suduku board, need to determine if it is a valid suduku board
- board can be partially filled
- each square represented by a string of either the number or "." if empty space

plan:
- need to keep track of filled numbers for each row, column, and square
- can use sets to store the numbers in each group
- iterate over every square checking for invalid numbers (return false if invalid)
- return true
*/

public class M36 {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>(9);
        ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>(9);
        ArrayList<ArrayList<HashSet<Integer>>> groups = new ArrayList<ArrayList<HashSet<Integer>>>(3);

        // initialize sets
        for(int i = 0; i < 9; i++){
            rows.add(new HashSet<Integer>(9));
            cols.add(new HashSet<Integer>(9));
        }
        for(int i = 0; i < 3; i++){
            ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
            for(int j = 0; j < 3; j++){
                arr.add(new HashSet<Integer>(9));
            }
            groups.add(arr);
        }

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                char ch = board[r][c];
                if(ch != '.'){
                    System.out.println(ch);
                    int val = Integer.parseInt(String.valueOf(ch));
                    if(rows.get(r).contains(val) || cols.get(c).contains(val) || groups.get(r/3).get(c/3).contains(val)){
                        System.out.printf("r: %d, c: %d\n", r, c);
                        return false;
                    }else{
                        rows.get(r).add(val);
                        cols.get(c).add(val);
                        groups.get(r/3).get(c/3).add(val);
                    }
                }
            }
        }

        return true;
    }
}
