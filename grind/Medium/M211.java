package grind.Medium;
import java.util.*;

public class M211 {
    class WordDictionary {

        HashMap<Character, WordDictionary> map;
    
        public WordDictionary() {
            map = new HashMap<Character, WordDictionary>();
        }
        
        public void addWord(String word) {
            if(word.length() > 0){
                char c = word.charAt(0);
                if(map.containsKey(c)){
                    map.get(c).addWord(word.substring(1));
                }else{
                    WordDictionary dict = new WordDictionary();
                    dict.addWord(word.substring(1));
                    map.put(c, dict);
                }
            }else{
                // end of string character
                map.put('-', null);
            }
        }
        
        public boolean search(String word) {
            if(word.length() <= 0){
                return map.containsKey('-');
            }else{
                char c = word.charAt(0);
                if(c == '.'){
                    for(Map.Entry<Character, WordDictionary> entry : map.entrySet()){
                        if(entry.getKey() != '-' && entry.getValue().search(word.substring(1))){
                            return true;
                        }
                    }
                    return false;
                }else if(map.containsKey(c)){
                    return map.get(c).search(word.substring(1));
                }else{
                    return false;
                }
            }
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
