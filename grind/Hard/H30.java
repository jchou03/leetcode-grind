package grind.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
describe:
- given string s (that can contain any characters)
- given array of string words (all same length words)
- need to find all the indices that begin a concatenated substring
    - need to identify a concatinated substring at the current index

plan:
- create list to store indices
- iterate over string s to determine if each index starts a concatinated substring
    - how to check if index begins a concatinated substring
        - know length of concatinated substring must be words.length * words[0].length() (since all w in words are same length)
    - if it is a concatinated substring, add index to list

- return list of results

- runtime: 71%, memory: 31%
*/

public class H30 {
    public List<Integer> findSubstring(String s, String[] words) {
        System.out.println(s.length());
        System.out.println(words.length);
        ArrayList<Integer> res = new ArrayList<Integer>();
        int wordLen = words[0].length();
        int length = words.length * wordLen;
        for(int i = 0; i < s.length() - length + 1; i++){
            if(!res.isEmpty() && res.get(res.size() - 1) == i - wordLen && i + length + wordLen <= s.length()){
                System.out.println("i: " + i);
                System.out.println(s.substring(i - wordLen, i));
                System.out.println(s.substring(i + length - wordLen, i + length));
                if(s.substring(i - wordLen, i).equals(s.substring(i + length - wordLen, i + length))){
                    res.add(i);
                }
            }else if(isConcatenatedSubstring(s, words, i)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean isConcatenatedSubstring(String s, String[] words, int index){
        int wordLen = words[0].length();
        int length = words.length * wordLen;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }else{
                map.put(words[i], 1);
            }
        }
        for(int i = index; i < index + length; i += wordLen){
            String curWord = s.substring(i, i + wordLen);
            if(map.containsKey(curWord)){
                map.put(curWord, map.get(curWord) - 1);
                if(map.get(curWord) <= 0){
                    map.remove(curWord);
                }
            }
        }
        return map.isEmpty();
    }
}
