package grind.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
understand:
- given array of intervals that are non-overlapping
- need insert a new interval into intervals
    - merge overlapping intervals
- return array of intervals

plan:
- sort intervals by start (nvm intervals already sorted by start)
- iterate over intervals
    2 cases:
        - need to merge (then find first interval which overlaps)
        - just need to insert (find first interval which comes after inserted interval)

runtime: 99%, memory: 24%
*/


public class M57 {
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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int startIndex = intervals.length;
        int minStart = newInterval[0];
        int maxEnd = newInterval[1];
        int afterIndex = intervals.length;
        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] > newInterval[1]){
                afterIndex = i;
                // case where there is no overlap, inserted position must be in index before i
                if(startIndex == intervals.length){
                    startIndex = i;
                }
                break;
            }else if(cur[1] >= newInterval[0]){
                minStart = Math.min(minStart, cur[0]);
                maxEnd = Math.max(maxEnd, cur[1]);
                if(startIndex == intervals.length){
                    startIndex = i;
                }
            }
        }

        int[][] res = new int[intervals.length + 1 - (afterIndex - startIndex)][];
        for(int i = 0; i < startIndex; i++){
            res[i] = intervals[i];
        }
        res[startIndex] = new int[]{minStart, maxEnd};
        // System.out.println(Arrays.toString(res[startIndex]));
        for(int i = afterIndex; i < intervals.length; i++){
            res[startIndex + 1 + (i - afterIndex)] = intervals[i];
        }

        return res;
    }
}
