package grind.Easy;

public class E242 {
    public boolean isAnagram(String s, String t) {
        // use a hashmap to store 
        HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(cMap.containsKey(c)){
                cMap.put(c, cMap.get(c) + 1);
            }else{
                cMap.put(c, 1);
            }
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!cMap.containsKey(c)){
                return false;
            }else{
                int count = cMap.get(c);
                if(count - 1 <= 0){
                    cMap.remove(c);
                } else {
                    cMap.put(c, count - 1);
                }
            }
        }

        return cMap.isEmpty();
    }
}

