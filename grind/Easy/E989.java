package grind.Easy;
import java.util.*;

// add to array-form of integer
// runtime: 84%, memory: 85%


public class E989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList<Integer>();
        for(int i = num.length - 1; i >= 0; i--){
            k += num[i];
            res.add(0, k % 10);
            k /= 10;
        }
        while(k > 0){
            res.add(0, k % 10);
            k /= 10;
        }
        return res;
    }
}
