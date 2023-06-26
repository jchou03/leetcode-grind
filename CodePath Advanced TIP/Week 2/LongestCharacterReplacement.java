// longest character replacement

/*

Understand: given string s and int i
    - can replace i characters in s with an uppercase character. 
    - are all inputs guaranteed to be only uppercase english letters?
    happy cases:
        - s = "ABAB", k = 2 -> 4
        - s = "AABABBA", k = 1 -> 4
        - s = "ACBA", k = 2 -> 4
        - s = "ABCDEFG", k = 1 -> 2
        - s = "ABCDEFG", k = 20 -> 7
    
    edge cases:
        - s = "", k = (literally any integer) -> 0
        - s = "A", k = 2 -> 1
    
Match:
    string problem:
        - hashmap?
        - 2 pointe/sliding window?

Plan:
    - try a sliding window approach (begin with trivial)
    - at each index i, iterate forward until temp_k = 0
        - if the next character is the same as char at index i, increment, but if it is different, reduce temp_k by 1
    - return the max length the window reaches

Examine:
    - runtime: O(n * k)
    - memory: O(1)

*/

public class LongestCharacterReplacement {
    public static void main(String[] args){
        String[] test_s = new String[]{"ABAB", "AABABBA", "ACBA", "ABCDEFG", "ABCDEFG"};
        int[] test_k = new int[]{2, 1, 2, 1, 20};
        int[] answers = new int[]{4, 4, 4, 2, 7};
        for(int i = 0; i < test_s.length; i++){
            System.out.printf("Beginning test %d with s=\"%s\", k=%d\n", i + 1, test_s[i], test_k[i]);
            int res = longestCharacterReplacement(test_s[i], test_k[i]);
            System.out.printf("Test %s, result=%d, answer=%d\n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);
        }
    }


    public static int longestCharacterReplacement(String s, int k){
        int maxSize = Math.min(s.length(), 1 + k);
        int temp_k;
        for(int i = 0; i < s.length(); i++){
            // in the case where the max size is larger than the remaining string, we can break out of the loop
            if(maxSize > s.length() - i) break;
            temp_k = k;
            int j = i + 1;
            while(temp_k >= 0 && j < s.length()){
                if(s.charAt(j) != s.charAt(i)){
                    temp_k--;
                } 
                j++;
            }
            if(temp_k < 0) j--;
            if(maxSize < (j - i)) maxSize = j - i;
        }
        return maxSize;
    }
}
