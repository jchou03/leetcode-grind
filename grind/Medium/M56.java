package grind.Medium;

import java.util.Stack;

/*
 * incomplete solution for M56
 *  - merge intervals so there aren't overlapping intervals
 */

public class M56 {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> res = new Stack<int[]>();
        if(intervals.length <= 1) return intervals;

        res.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            if(res.peek()[1] >= intervals[i][0]){
                res.peek()[1] = intervals[i][1];
            }else{
                res.push(intervals[i]);
            }
        }
        int[][] finalRes = new int[res.size()][];
        for(int i = res.size() - 1; i >= 0; i--){
            finalRes[i] = res.pop();
        }
        return finalRes;
    }
}
