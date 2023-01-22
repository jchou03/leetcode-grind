package grind.Easy;

// Backspace String Compare (currently very inefficient)

public class E844 {
    public boolean backspaceCompare(String s, String t) {
        String a = "";
        String b = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(a.length() != 0) a = a.substring(0, a.length() - 1);
            }else{
                a = a + s.charAt(i);
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(b.length() != 0) b = b.substring(0, b.length() - 1);
            }else{
                b = b + t.charAt(i);
            }
        }
        System.out.println(a + ", " + b);
        return a.equals(b);
    }
}
