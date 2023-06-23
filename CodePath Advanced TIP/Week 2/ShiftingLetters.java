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


//  M848 shifting letters
// runtime: 5% memory: 35%

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int cumShift = 0;
        String res = "";
        for(int i = 1; i <= s.length(); i++){
            cumShift += shifts[shifts.length - i]%26;
            res = shift(s.charAt(s.length() - i), cumShift) + res;
        }
        return res;
    }

    private char shift(char c, int i){
        int temp = ((int)c + (i % 26));
        if(temp > 122){
            temp -= (122 - 96);
        }
        if(temp < 97){
            temp += (122 - 96);
        }
        System.out.printf("c: %s i: %d and res is %c\n", c, i, (char)temp);
        return (char)(temp);
    }
}

