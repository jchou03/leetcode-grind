package grind.Easy;

import java.util.HashMap;

public class E290 {
    public boolean wordPattern(String pattern, String s) {
        /*
            split the string by spaces
            store the existing pattern in a hashmap
        */
        HashMap<Character, String> map = new HashMap<Character, String>();
        String[] words = s.split(" ");
        int counter = 0;
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[counter];
            while(word.equals("")){
                counter++;
                word = words[counter];
            }
            if(!map.containsKey(c)){
                map.put(c, word);
            }else{
                if(!word.equals(map.get(c))){
                    return false;
                }
            }
            counter++;
        }
        return counter == words.length;
    }
}
