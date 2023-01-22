package grind.Medium;
import java.util.*;

// Bulls and Cows

public class M299 {
    public String getHint(String secret, String guess) {
        // hashmap to store a set of indicies where a certain character is in secret
        HashMap<Character, HashSet<Integer>> sMap = new HashMap<Character, HashSet<Integer>>();
        // populate the map with the information from secret
        for(int i = 0; i < secret.length(); i++){
            char c = secret.charAt(i);
            if(sMap.get(c) == null){
                sMap.put(c, new HashSet<Integer>());
                sMap.get(c).add(i);
            }else{
                sMap.get(c).add(i);
            }
        }
        // have another map that stores the count of each digit in the guess
        // iterate over the guess and store the count of each digit, but if that digit is a Bull, remove it from its respective sMap set. Then at the end, compare the count of each digit to the size of each set to get the number of Cows
        HashMap<Character, Integer> gMap = new HashMap<Character, Integer>();
        int bullCount = 0;
        int cowCount = 0;
        for(int i = 0; i < guess.length(); i++){
            char c = guess.charAt(i);
            if(sMap.get(c) != null){
                // if c is a possible bull or cow, check if it is a bull
                if(sMap.get(c).contains(i)){
                    bullCount++;
                    sMap.get(c).remove(i);
                }
                // if it isn't a bull, increment the counter
                else{
                    if(gMap.get(c) == null){
                        gMap.put(c, 1);
                    }else{
                        gMap.put(c, gMap.get(c) + 1);
                    }
                }
            }
            // if c isn't a possible bull or cow, ignore it
        }
        // compare the count of each digit to the size of the map for the cowCount
        for(Character c : gMap.keySet()){
            System.out.println(c + ": " + gMap.get(c) + ", " + sMap.get(c).size());
            cowCount += (Math.min(gMap.get(c), sMap.get(c).size()));
        }
        
        return (bullCount + "A" + cowCount + "B");
    }
}
