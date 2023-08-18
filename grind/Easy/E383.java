package grind.Easy;

import java.util.HashMap;

/*
 * determine if a string ransomNote can be constructed from a string magazine
 */

public class E383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
            use a hashmap to store the number of each letter in the mag and in the randomnote and ensure the mag count is >= the ransomNote count
            
        */

        HashMap<Character, Integer> ranMap = new HashMap<Character, Integer>(); 
        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(ranMap.containsKey(c)){
                ranMap.put(c, ranMap.get(c) + 1);
            }else{
                ranMap.put(c, 1);
            }
        }

        HashMap<Character, Integer> magMap = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            if(magMap.containsKey(c)){
                magMap.put(c, magMap.get(c) + 1);
            }else{
                magMap.put(c, 1);
            }
        }

        for(char c : ranMap.keySet()){
            if(magMap.get(c) == null || magMap.get(c) < ranMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
