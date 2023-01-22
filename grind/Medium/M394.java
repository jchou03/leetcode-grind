package grind.Medium;

// decode string
// incomplete (currently struggling with issues on how to ensure that we are jumping to the index of the corresponding ']')

public class M394 {
    public String decodeString(String s) {
        return helper(s, 1);
    }
    private String helper(String s, int n){
        // System.out.println(s + ", " + n);
        String temp = "";
        String result = "";
        for(int i = 0; i < s.length(); i++){
            // the case where we need to start a new case
            if(Character.isDigit(s.charAt(i))){
                // then we must be entering another sequence
                // System.out.println(s);
                // System.out.println(s.substring(i, s.indexOf('[', i)));
                // System.out.println(Integer.parseInt(s.substring(i, s.indexOf('[', i))));
                int a = s.indexOf('[', i);
                temp = temp + helper(s.substring(a + 1), Integer.parseInt(s.substring(i, a) ));
                i = s.indexOf("]", i + 1);
            }
            // case where we are done with our current loop
            else if (s.charAt(i) == ']'){
                break;
            }
            // other case where we just add the letter
            else {
                temp = temp + s.charAt(i);
            }
        }
        // System.out.println(temp + ", " + n);

        // apply the loop
        for(int i = 0; i < n; i++){
            result = result + temp;
        }

        return result;
    }    
}
