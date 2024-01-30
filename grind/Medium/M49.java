package grind.Medium;

import java.util.*;

/*
 * runtime: 16%, memory: 7%
 */

public class M49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // iterate each of the strings and represent each string as an array of the lowercase characters
        // hash the arrays (as a string) and add them into a list
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            int[] representation = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                char c = strs[i].charAt(j);
                representation[c - 'a']++;
            }

            String s = Arrays.toString(representation);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     /*
    //         use a hashmap to group anagrams together
    //             anagrams should get hashed the same
    //         convert each string into a map representing the letters within it and store it in the overall map
    //     */    
    //     HashMap<HashMap<Character, Integer>, List<String>> anagramMap = new HashMap<HashMap<Character, Integer>, List<String>>();
    //     for(int i = 0; i < strs.length; i++){
    //         String s = strs[i];
    //         HashMap<Character, Integer> hashStr = hashString(s);
    //         // System.out.println(hashStr);
    //         if(anagramMap.containsKey(hashStr)){
    //             anagramMap.get(hashStr).add(s);
    //         }else{
    //             List<String> list = new ArrayList<String>();
    //             list.add(s);
    //             anagramMap.put(hashStr, list);
    //         }
    //     }
    //     List<List<String>> res = new ArrayList<List<String>>();
    //     for(Map.Entry<HashMap<Character, Integer>, List<String>> entry : anagramMap.entrySet()){
    //         res.add(entry.getValue());
    //     }
    //     return res;
    // }

    // private HashMap<Character, Integer> hashString(String s){
    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    //     for(int i = 0; i < s.length(); i++){
    //         char c = s.charAt(i);
    //         if(map.containsKey(c)){
    //             map.put(c, map.get(c) + 1);
    //         }else{
    //             map.put(c, 1);
    //         }
    //     }
    //     return map;
    // }
}
