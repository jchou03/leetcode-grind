package grind.Medium;

import java.util.HashMap;
import java.util.Map;

/*
understand:
given a string s (only uppercase english characters?)
given an int k
need to find the length of the longest substring in s that only consists of the same character
given k replacements (can replace a character with any other character, ideally the max one to maximize the length of substring)
return length of longest substring

match:
- sliding window

plan:
- use a sliding window approach
- use a left and right pointer to represent window of substring of single character (with replacements)
    - use a hashmap to store the characters within the window (and the count of each character)
    - iterate over right pointer 
        - if right character breakes the replacement count, then increment left pointer until window is valid

Longest Repeating Character Replacement
runtime: 36%, memory: 9%
 */

public class M424 {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char curMax = s.charAt(0);
        int maxCount = 1;
        int left = 0;
        map.put(curMax, maxCount);
        int maxSubstring = 1;
        for(int right = 1; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }

            if(c == curMax){
                maxCount++;
            }else if(map.get(c) > maxCount){
                maxCount = map.get(c);
                curMax = c;
            }

            // check if left window needs to move
            while((right - left + 1) - maxCount > k){
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                left++;
                if(lc == curMax){
                    maxCount--;
                    if((right - left + 1) - maxCount > k){
                        // if the c != curMax then we need to check if there is a new curMax
                        for(Map.Entry<Character, Integer> entry : map.entrySet()){
                            if(entry.getValue() > maxCount){
                                curMax = entry.getKey();
                                maxCount = entry.getValue();
                            }
                        }
                    }
                }
            }

            maxSubstring = Math.max(maxSubstring, right - left + 1);
            // System.out.printf("substring: %s, maxChar: %c, maxCount: %d\n", s.substring(left, right + 1), curMax, maxCount);
        }

        return maxSubstring;
    }
}
