package grind.need_improvement;
import java.util.*;

// find the first instance of a substring
// runtime: 36%, memory: 66%

class Solution {
    public int strStr(String haystack, String needle) {
        // use an array to store the number of indexes of the potential starting indicies of 

        for(int i = 0; i < haystack.length(); i++){
            char c = haystack.charAt(i);
            // System.out.println(c + ", " + needle.charAt(0));
            if(c == needle.charAt(0)){
                // System.out.println("gay");
                if((i + needle.length() <= haystack.length()) && needle.equals(haystack.substring(i, i+needle.length()))){
                    System.out.println(i);
                    return i;
                }
            }
        }

        return -1;
    }
}