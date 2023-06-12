/*
 * input: 31:
 * 31 -> 32 -> 16 -> 8 -> 4 -> 2 -> 1
 * 31 -> 30 -> 15 -> 14 -> 7 -> 6 -> 3 -> 2 -> 1
 * 
 * input: 50
 * 50 -> 25 -> 24 -> 12 -> 6 -> 3 -> 2 -> 1
 *       25 -> 26 -> 13 -> 14 -> 16
 * 
 * potential solution: create an array of the number of steps it takes from each step
 */

import java.util.Arrays;


// if positive integer i is even, i/2, else i + 1 or i - 1 (how many steps until you reach 1)

public class IntReplace {
    public static void main(String[] args) {
        int[] tests = new int[]{8, 7, 4, 1};
        int[] answers = new int[]{3, 4, 2, 0};

        for(int i = 0; i < tests.length; i++){
            System.out.printf("Test %d input: %d, output: %d, answer: %d\n", i, tests[i], intReplace(tests[i]), answers[i]);
        }
    }

    // powers of 2 are really powerful (less operations)
    private static int intReplace(int i){
        if(i == 1) return 0;
        if(i <= 0) return -1; // (all inputs need to be positive integers)
        // memo array stores the number of steps it takes to get to 1
        int[] memo = new int[i];
        memo[0] = -1;
        memo[1] = 0;
        // edge cases:
        for(int j = 2; j < i; j++){
            if(j % 2 == 0){
                memo[j] = memo[j/2] + 1;
                // if the number is even, check if the odd number before it actually takes less steps by doing +1
                if(memo[j] + 1 < memo[j - 1]) memo[j - 1] = memo[j];
            }else{
                memo[j] = memo[j - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(memo));

        if(i % 2 == 0){
            return memo[i / 2] + 1;
        }else{
            return Math.min(memo[i - 1] + 1, memo[(i + 1)/2] + 2);
        }
    }
}
