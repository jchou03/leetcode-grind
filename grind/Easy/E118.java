package grind.Easy;
import java.util.*;

// pascals triangle
// in progress

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
        for(int i = 3; i < numRows; i++){
            List<Integer> row = new ArrayList<Integer>(i);
            row.add(1);
            for(int j = 1; j < i - 1; j++){
                row.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
