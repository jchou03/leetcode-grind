/*

Understand:
    - shift each letter in a string based on shifting rules
    - shifting rules include an array of ints
    - for each i, shifts[i] = x, we shift the first i letters by x

Match
    - this is a string problem
    - we can actually iterate backwards to shift each letter
    - shift by the cumulative shift so far

Plan

Implement

Review

Examine

 */

public class ShiftingLetters {

    char[] alpha = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String shiftingLetters(String s, int[] shifts) {
        int cumShift = 0;
        String res = "";
        for(int i = 1; i <= s.length(); i++){
            cumShift += shifts[i - 1];
            res = shift(s.charAt(i), cumShift) + res;
        }
        return "";
    }

    private char shift(char c, int i){
        return (char)((int)c + i);
    }
}
