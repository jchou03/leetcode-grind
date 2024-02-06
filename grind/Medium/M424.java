public class M424 {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char curMax = s.charAt(0);
        int maxCount = 1;
        int left = 0;
        map.put(curMax, maxCount);
        int maxSubstring = 1;
        for(int right = 1; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }

            if(c == curMax){
                maxCount++;
            }

            // check if left window needs to move
            while((right - left + 1) - maxCount > k){
                char lc = s.charAt(left);
                if(lc == curMax){
                    maxCount--;
                    if((right - left + 1) - maxCount > k){
                        // if the c != curMax then we need to check if there is a new curMax
                        for(Map.Entry<Character, Integer> entry : map.entrySet()){
                            if(entry.getValue() > maxCount){
                                curMax = entry.getKey();
                                maxCount = entry.getValue();
                            }
                        }
                    }
                }else{
                    map.put(lc, map.get(lc) - 1);
                    left++;
                }
            }

            maxSubstring = Math.max(maxSubstring, right - left + 1);
            System.out.printf("substring: %s, maxChar: %c, maxCount: %d\n", s.substring(left, right + 1), curMax, maxCount);
        }

        return maxSubstring;
    }
}
