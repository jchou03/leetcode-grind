package grind.Easy;
import java.util.*;

// 205. Isomorphic Strings

public class E205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<Character, Character>();
        HashMap<Character, Character> tMap = new HashMap<Character, Character>();
        String n = "";
        if(s.length() == t.length()){
            for(int i = 0; i < s.length(); i++){
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                if(sMap.get(sChar) == null && tMap.get(tChar) == null){
                    sMap.put(sChar, tChar);
                    tMap.put(tChar, sChar);
                }else if ((sMap.get(sChar) != null && sMap.get(sChar) != tChar) || (tMap.get(tChar) != null && tMap.get(tChar) != sChar)){
                    return false;
                }
                n += tChar;
            }
            if(n.equals(t)) return true;
        }
        return false;

    }
}
