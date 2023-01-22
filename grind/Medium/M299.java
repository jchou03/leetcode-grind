package grind.Medium;
import java.util.*;

// Bulls and Cows

public class M299 {
    public String getHint(String secret, String guess) {
        int bullCount = 0;
        // use two maps to store the count of each digit in each
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> gmap = new HashMap<Character, Integer>();
        for(int i = 0; i < secret.length(); i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b){
                bullCount++;
            }else{
                // update smap count
                if(smap.get(a) == null){
                    smap.put(a, 1);
                }else{
                    smap.put(a, smap.get(a) + 1);
                }
                // update gmap count
                if(gmap.get(b) == null){
                    gmap.put(b, 1);
                }else{
                    gmap.put(b, gmap.get(b) + 1);
                }
            }
        }
        // get count of cows
        int cowCount = 0;
        for(Character c : gmap.keySet()){
            if(smap.get(c) != null){
                cowCount += Math.min(smap.get(c), gmap.get(c));
            }
        }
        return bullCount + "A" + cowCount + "B";
    }
}
