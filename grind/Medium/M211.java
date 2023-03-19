package grind.Medium;
import java.util.*;

public class M211 {
    class WordDictionary {

        /* Implementation idea: use a Set to store all of the words, then when searching, iterate over the keys to find the */
    
        Set<String> dictionary;

        public WordDictionary() {
            dictionary = new TreeSet<String>();
        }
        
        public void addWord(String word) {
            dictionary.add(word);
        }
        
        public boolean search(String word) {
            Object[] dict = dictionary.toArray();
            Arrays.sort(dict);
            int index = 0;
            while(index <= dict.length - 1){
                if(wordEquals((String)dict[index], word)) return true;
                index++;
            }
            return false;
        }
    
        // first word is word in WordDictionary, second is the one that may contain wildcards
        private boolean wordEquals(String w1, String w2){
            if(w1.length() != w2.length()) {
                return false;
            }
            for(int i = 0; i < w1.length(); i++){
                if(!(w2.charAt(i) == '.') && w1.charAt(i) != w2.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
