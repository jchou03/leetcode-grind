package grind.Medium;

import java.util.HashSet;
import java.util.Set;

/*
understand:
- given a grid of characters
- given string word
- return true if word exists in the grid
- constructed from letters of sequentially adjacent cells
    - adjacent cells are horizontally or vertically neighboring
    - same letter may not be used more than once
- board and word are only lower/uppercase english letters

plan:
- recursive approach
- at each step, only try to find the first letter in the word out of adjacent cells
- check if current cell contains character same as first char in word
    - if so, then recursively call function on 4 adjacent cells
    - use a set to keep track of visited coordinates (use string coords)

runtime: 7%, memory: 6%

*/

public class M79 {
    public boolean exist(char[][] board, String word) {
        // check that all characters in word exist in board
        HashSet<Character> charSet = new HashSet<Character>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                charSet.add(board[i][j]);
            }
        }
        for(int i = 0; i < word.length(); i++){
            if(!charSet.contains(word.charAt(i))) return false;
        }

        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, word, set, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, Set<String> set, int r, int c){
        // base case
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || set.contains(r + "," + c)){
            return false;
        }else{
            // System.out.printf("row: %d, col: %d, char: %c, word: %s\n", r, c, board[r][c], word);
            if(board[r][c] == word.charAt(0)){
                if(word.length() <= 1){
                    return true;
                }else{
                    HashSet<String> newSet = new HashSet<String>();
                    newSet.addAll(set);
                    newSet.add(r + "," + c);
                    return helper(board, word.substring(1), newSet, r + 1, c) || 
                        helper(board, word.substring(1), newSet, r - 1, c) || 
                        helper(board, word.substring(1), newSet, r, c + 1) ||
                        helper(board, word.substring(1), newSet, r, c - 1); 
                }
            }else{
                return false;
            }
        }
    }
}
