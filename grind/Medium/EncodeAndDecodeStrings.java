package grind.Medium;
import java.util.*;

/*
 * Encode and Decode strings
 */

public class EncodeAndDecodeStrings {
    char split = 11264;
    public String encode(List<String> strs) {
        String s = "";
        for(String str : strs){
            s += str + split;
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<String>();
        int subStart = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == split){
                res.add(str.substring(subStart, i));
                subStart = i + 1;
            }
        }
        return res;
    }
}
