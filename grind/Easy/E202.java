package grind.Easy;
import java.util.*;

// happy number
// runtime: 11%, memory: 7%


public class E202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(true){
            n = happy(n);
            if(n == 1) return true;
            if(!set.add(n)) return false;
        }
    }

    private int happy(int n){
        String s = Integer.toString(n);
        // System.out.println(s);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            // System.out.println(Character.digit(s.charAt(i), 10));
            sum += Math.pow(Character.digit(s.charAt(i), 10), 2.0);
            // System.out.println(sum);
        }
        return sum;
    }
}
