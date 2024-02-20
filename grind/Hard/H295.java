package grind.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class H295 {
    class MedianFinder {
        PriorityQueue<Integer> pq;

        public MedianFinder() {
            pq = new PriorityQueue<Integer>();
        }
        
        public void addNum(int num) {
            pq.add(num);
        }
        
        public double findMedian() {
            System.out.println(pq.size());
            if(pq.size() <= 0 ) return (double)0;
            if(pq.size() % 2 == 1){
                int median = (pq.size()/2);
                // use a temp list to store the values removed from the priorityQueue
                List<Integer> list = new ArrayList<Integer>();
                for(int i = 0; i < median; i++){
                    list.add(pq.poll());
                }
                int res = pq.peek();
                for(Integer val : list){
                    pq.offer(val);
                }
                return (double)res;
            }else{
                // if even compute the average between the middle 2 values
                int median = (pq.size()/2) - 1;
                // use a temp list to store the values removed from the priorityQueue
                List<Integer> list = new ArrayList<Integer>();
                for(int i = 0; i < median; i++){
                    list.add(pq.poll());
                }
                int left = pq.poll();
                double res = (((double)left) + pq.peek())/2;
                pq.offer(left);
                for(Integer val : list){
                    pq.offer(val);
                }
                return res;
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}
