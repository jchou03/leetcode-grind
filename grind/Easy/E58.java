package grind.Easy;

// length of last word (without spaces)
// runtime: 100%, memory 66%

public class E58 {
    public int lengthOfLastWord(String s) {
        int lastSpace = s.length();
        for(int i = s.length() - 1; i > 0; i--){
            if(s.charAt(i) != ' '){
                if(s.charAt(i - 1) == ' '){
                    return s.substring(i, lastSpace).length();
                }
            }else{
                lastSpace = i;
            }
        }
        // check the 0th character
        if(s.charAt(0) != ' '){
            return s.substring(0, lastSpace).length();
        }else {
            return -1;
        }
    }
}
