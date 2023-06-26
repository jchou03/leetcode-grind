/*
Understand
    - input is an array of strings
    - need to return an array containing arrays of groups of anagrams

    happy cases:
        - strs = ["eat","tea","tan","ate","nat","bat"] -> [["bat"],["nat","tan"],["ate","eat","tea"]]
        - strs = ["apple", "paple", "pineapple"] -> [["apple", "paple"], ["pineapple"]]

    edge cases:
        - strs = [""] -> [[""]]
        - strs = [] -> [] or [[]]

Match
    - hashmap problem

Plan
    - use a "hashing" function to turn any string into counts of its characters
        - easiest approach is to store it into an array that contains counts of all the letters
        - then convert the array into its string representation
        - then use the string version of the array as the hash key
        - then in the hashmap store a list to contain the strings that are anagrams
    - finally iterate over the hashmap to group all of the anagrams

Implement

Review

Examine

 */

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args){
        String[][] tests = new String[][]{
            new String[]{"eat","tea","tan","ate","nat","bat"},
            new String[]{"apple", "paple", "pineapple"},
            new String[]{""},
            new String[0]};
        
        // System.out.printf("Hashing \'apple\' as a test result: %s", hash("apple"));
        System.out.printf("testing input %s, result=", "[eat,tea,tan,ate,nat,bat]");
        String[][] res = groupAnagrams(tests[0]);
        System.out.print("[");
        for(int i = 0; i < res.length; i++){
            System.out.printf("%s ", Arrays.toString(res[i]));
            if(i < res.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static String[][] groupAnagrams(String[] strs){
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>(strs.length);
        // populate hashmap with all of the strings (groups the anagrams together)
        for(int i = 0; i < strs.length; i++){
            String hash = hash(strs[i]);
            if(map.containsKey(hash)){
                LinkedList<String> ll = map.get(hash);
                ll.push(strs[i]);
            }else{
                LinkedList<String> ll = new LinkedList<String>();
                ll.push(strs[i]);
                map.put(hash, ll);
            }
        }

        // now convert the hashmap into a string array
        String[][] res = new String[map.size()][];
        int i = 0;
        for(String key : map.keySet()){
            LinkedList<String> ll = map.get(key);
            res[i] = new String[ll.size()];
            int j = 0;
            while(!ll.isEmpty()){
                res[i][j] = ll.pop();
                j++;
            }
            i++;
        }

        return res;
    }

    private static String hash (String s){
        int[] letters = new int[26];
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            letters[s.charAt(i) - 97] += 1;
        }
        return Arrays.toString(letters);
    }
}