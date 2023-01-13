package grind.Easy;
import java.util.*;

// Longest Palindrome

public class E409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.get(c) == null){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        boolean one = false;
        int sum = 0;
        for(Integer num : map.values()){
            if(num % 2 == 0){
                sum += num;
            }else{
                sum += num - 1;
                one = true;
            }
        }
        return (one ? sum + 1 : sum);
    }
}
