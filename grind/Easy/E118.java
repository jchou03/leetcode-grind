package grind.Easy;
import java.util.*;

// pascals triangle
// runtime: 6.58%, memory: 15.44%

public class E118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(numRows >= 1){
            List<Integer> row = new ArrayList<Integer>(1);
            row.add(1);
            res.add(row);
            if(numRows >= 2){
                row = new ArrayList<Integer>(2);
                row.add(1);
                row.add(1);
                res.add(row);
            }
        }
        for(int i = 2; i < numRows; i++){
            System.out.println(i);
            List<Integer> row = new ArrayList<Integer>(i);
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
