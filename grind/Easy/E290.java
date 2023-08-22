package grind.Easy;

import java.util.HashMap;

public class E290 {
    public boolean wordPattern(String pattern, String s) {
        /*
            split the string by spaces
            store the existing pattern in a hashmap
        */
        HashMap<Character, String> charToStr = new HashMap<Character, String>();
        HashMap<String, Character> strToChar = new HashMap<String, Character>();
        String[] words = s.split(" ");
        int counter = 0;
        for(int i = 0; i < pattern.length(); i++){
            if(counter >= words.length){
                return false;
            }
            char c = pattern.charAt(i);
            String word = words[counter];
            while(word.equals("")){
                counter++;
                word = words[counter];
            }
            if(!charToStr.containsKey(c) && !strToChar.containsKey(word)){
                charToStr.put(c, word);
                strToChar.put(word, c);
            }else if(!word.equals(charToStr.get(c)) || !(c == strToChar.get(word))){
                return false;
            }
            counter++;
        }
        return counter == words.length;
    }
}
