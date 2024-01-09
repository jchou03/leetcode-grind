package grind.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
 * 
 * understand:
- given an array of intervals
- intervals[i] = [start_i, end_i]
- no guarantee on order
- return array of non-overlapping intervals that cover all intervals in the input
    - can create new intervals that combine overlapping ones
- can an interval ever have an end that comes before the start? (error detection)
- does the endpoint on each interval get considered as part of the interval? 
    - yes, [1,4] and [4,5] are considered overlapping
- empty input?

plan:
- sort intervals by start time
- keep track of the earliest start time that isn't yet part of the solution
    - iterate over intervals coming after that overlap
    - keep track of the latest end that is part of the same overlapping interval
    - once you find an interval start that doesn't overlap (isn't part of the same interval), add old one to solution and repeat

O(nlogn) 96%
memory: O(n) 15%
 */

public class M56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][];

        IntervalComparator c = new IntervalComparator();
        Arrays.sort(intervals, c);

        ArrayList<int[]> res = new ArrayList<int[]>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] <= end){
                end = Math.max(end, cur[1]);
            }else{
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        res.add(new int[]{start, end});
        
        int[][] ans = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    class IntervalComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
}
