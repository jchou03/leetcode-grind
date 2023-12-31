package grind.Medium;

import java.util.HashSet;

/*
descibe:
- need to find the length of the longest substring without repeating characters
- only need to find length, don't need to return the exact substring

plan: 
- use sliding window
- left pointer and right pointer
- maintain set of characters between pointers
- increment right pointer
    - add right pointer char to set,
    - if new char exists in the old set, keep iterating left pointer until it is unique again
    - keep track of max substring length

runtime: 42%, memory: 25%

*/

public class M3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        HashSet<Character> set =  new HashSet<Character>();
        for(int right = 0; right < s.length(); right++ ){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
