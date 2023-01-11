package grind.Easy;

// Is Subsequence

public class E392 {
    public boolean isSubsequence(String s, String t) {
        // store index of previous letter
        // search for indexOf the next char after that index
        // if doesn't exist then false
        int prevInd = -1;
        int offset = 0;
        for(int i = 0; i < s.length(); i++){
            if(offset >= t.length()) return false;
            prevInd = t.substring(offset).indexOf(s.charAt(i));
            if(prevInd == -1) return false;
            offset += 1 + prevInd;
            System.out.println(offset);
        }
        return true;
    }
}
