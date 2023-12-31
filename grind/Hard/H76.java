package grind.Hard;

import java.util.HashMap;

/*
describe:
- given larger string s
- given smaller string t (check if s >= t, if not instantly return "")
- check for the minimum window substring in s that contains all chracters in t
- all chars in t (including duplicates) should be represented in s

plan:
- check if s.length() >= t.length(), if not, return ""
- use left and right pointer using map to keep track of characters within the window


runtime: 5%, memory: 6%

*/

public class H76 {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        String minWindow = "";

        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(tMap.containsKey(c)){
                tMap.put(c, tMap.get(c) + 1);
            }else{
                tMap.put(c, 1);
                sMap.put(c, 0);
            }
        }

        while(right < s.length()){
            char c = s.charAt(right);
            if(tMap.containsKey(c)){
                sMap.put(c, sMap.get(c) + 1);
            }

            // close the window if char mapping works
            if(mapFit(sMap, tMap)){
                boolean cont = true;
                while(cont){
                    String substring = s.substring(left, right + 1);
                    if(minWindow.equals("") || substring.length() < minWindow.length()){
                        minWindow = s.substring(left, right + 1);
                    }
                    char lc = s.charAt(left);
                    if(sMap.containsKey(lc)){
                        if(sMap.get(lc) - 1 < tMap.get(lc)){
                            cont = false;
                        }
                        sMap.put(lc, sMap.get(lc) - 1);
                    }
                    left++;
                }
            }

            right++;
        }

        return minWindow;
    }

    private boolean mapFit(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap){
        for(char c : tMap.keySet()){
            if(sMap.get(c) < tMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
