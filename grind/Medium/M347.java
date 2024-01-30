package grind.Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Top K Frequent elements
 * 
 * runtime: 35%, memory: 54%
 */

public class M347 {
    public int[] topKFrequent(int[] nums, int k) {
        // use a hashmap to store the counts of each number
        // then add all characters (and counts) into a priority queue (return top 4 elements)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }

        MyComparator c = new MyComparator();

        PriorityQueue<int[]> q = new PriorityQueue<int[]>(c);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            q.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            if(!q.isEmpty()){
                res[i] = q.poll()[0];
            }
        }
        return res;
    }

    class MyComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return b[1] - a[1];
        }
    }
}
