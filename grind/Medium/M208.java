package grind.Medium;

import java.util.HashMap;

// implement a Trie object

public class M208 {
    class Trie {

    HashMap<Character, Trie> map;

    public Trie() {
        map = new HashMap<Character, Trie>();
    }
    
    public void insert(String word) {
        if(word.length() > 0){
            char c = word.charAt(0);
            if(map.containsKey(c)){
                map.get(c).insert(word.substring(1));
            }else{
                Trie t = new Trie();
                t.insert(word.substring(1));
                map.put(c, t);
            }
        }else{
            // end of word char
            map.put('-', null);
        }
    }
    
    public boolean search(String word) {
        if(word.length() <= 0){
            return map.containsKey('-');
        }else{
            char c = word.charAt(0);
            if(!map.containsKey(c)){
                return false;
            }else{
                return map.get(c).search(word.substring(1));
            }
        } 
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length() <= 0){
            return true;
        }else{
            char c = prefix.charAt(0);
            if(!map.containsKey(c)){
                return false;
            }else{
                return map.get(c).startsWith(prefix.substring(1));
            }
        } 
    }
}
}
