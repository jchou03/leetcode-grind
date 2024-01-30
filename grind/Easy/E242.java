package grind.Easy;
import java.util.*;

public class E242 {
    public boolean isAnagram(String s, String t) {
        // use a hashmap to store 
        HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(cMap.containsKey(c)){
                cMap.put(c, cMap.get(c) + 1);
            }else{
                cMap.put(c, 1);
            }
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!cMap.containsKey(c)){
                return false;
            }else{
                int count = cMap.get(c);
                if(count - 1 <= 0){
                    cMap.remove(c);
                } else {
                    cMap.put(c, count - 1);
                }
            }
        }

        return cMap.isEmpty();
    }

    /*
     * public boolean isAnagram(String s, String t) {
        
        //use 2 hashmaps to store all the characters (and count of each)
        
        HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(m1.containsKey(c)){
                m1.put(c, m1.get(c) + 1);
            }else{
                m1.put(c, 1);
            }
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(m2.containsKey(c)){
                m2.put(c, m2.get(c) + 1);
            }else{
                m2.put(c, 1);
            }
        }

        if(m1.equals(m2)){
            return true;
        }
        return false;
    }
     * 
     */

     /*
      * public boolean isAnagram(String s, String t) {
        
        use an array to store the characters, and make sure that all letters are matched up
        
        if(s.length() != t.length()) return false;

        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            chars[c - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            chars[c - 'a']--;
        }

        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0) return false;
        }
        return true;
    }
      */
}

