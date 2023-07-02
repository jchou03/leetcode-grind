/*

Understand
    - need to implement a class RecentCounter that counts the number of recent pings
    - implement ping(int t) function that adds a new ping at time t (in milliseconds)
    that returns the number of pings within the last 3000 milliseconds (inclusive)
    - guaranteed that each ping has a time t that is strictly larger than the last

    happy input:
        [[], [1], [100], [3001], [3002]] -> [null, 1, 2, 3, 3]
        [[], [1], [2], [4000]] -> [null, 1, 2, 1]
    
    edge case:
        [[]] -> [null]
        [[], [1]] -> [null, 1]


Match
    - what data stuctures could be useful for this problem?
        - could use an array, but it would be really ineeficient and a lot of empty space
        - could use a hashmap with keys of time to save memory, but still need to iterate
        over the list of keys a lot
        - use a queue to keep track of the times that are within the range, and pop times
        off when they aren't in the range of the latest ping


Plan
    - create a instance var queue for the recent pings
    - implement ping function by adding to end of queue, then removing elements from the 
    queue until the element is within the range of ping
    - return size of queue

Examine
    runtime: O(n) 30%
    memory: O(n) 43%


 */

import java.util.*;

public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter(){
        queue = new LinkedList<Integer>();
    }
    public int ping(int t){
        queue.add(t);
        while(!queue.isEmpty() && queue.peek() < (t - 3000)){
            queue.poll();
        }
        return queue.size();
    }
}
