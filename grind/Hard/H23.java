package grind.Hard;
import java.util.Comparator;
import java.util.PriorityQueue;

import grind.ListNode;

/*
 * Merge k sorted LinkedLists
 * runtime: O(nlogn)
 */

public class H23 {
    // nlogn solution
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        ListNode head = null;
        ListNode trav = null;

        // maintain a PriorityQueue of all the values in the "front" of the lists (keeping track of which list they are in)
        ListCompare lc = new ListCompare();
        PriorityQueue<Pair<ListNode, Integer>> pq = new PriorityQueue<Pair<ListNode, Integer>>(lc);

        // add the head of each list into the pq
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(new Pair<ListNode, Integer>(lists[i], i));
            }
        }
        // System.out.println(pq.peek());
        while(!pq.isEmpty()){
            Pair<ListNode, Integer> pair = pq.poll();

            if(head == null){
                head = pair.getKey();
                trav = head;
            }else{
                trav.next = pair.getKey();
                trav = trav.next;
            }
            
            if(pair.getKey() != null){
                lists[pair.getValue()] = lists[pair.getValue()].next;
                if(lists[pair.getValue()] != null){
                    pq.add(new Pair<ListNode, Integer>(lists[pair.getValue()], pair.getValue()));
                }
            }
        }
        return head;
    }

    class ListCompare implements Comparator<Pair<ListNode, Integer>>{
        @Override
        public int compare(Pair<ListNode, Integer> p1, Pair<ListNode, Integer> p2){
            return p1.getKey().val - p2.getKey().val;
        }
    }

    class Pair<T, U>{
        T key;
        U value;

        public Pair(T key, U value){
            this.key = key;
            this.value = value;
        }

        public T getKey(){
            return key;
        }

        public U getValue(){
            return value;
        }
    }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length == 0) return null;
    //     return helper(lists, null);
    // }

    // // n^2 solution (could use priority queue to solve faster)
    // private ListNode helper(ListNode[] lists, ListNode trav){
    //     // lists should contain the current trav node for each of the lists
    //     int minIndex = 0;
    //     for(int i = 1; i < lists.length; i++){
    //         if(lists[i] != null && (lists[minIndex] == null || lists[i].val < lists[minIndex].val)){
    //             minIndex = i;
    //         }
    //     }
        
    //     if(trav == null){
    //         // this is the first call to helper, then need to iterate through all to find the min value
    //         ListNode root = lists[minIndex];
    //         if(lists[minIndex] != null){
    //             lists[minIndex] = lists[minIndex].next;
    //             helper(lists, root);
    //         }
    //         return root;
    //     }else{
    //         trav.next = lists[minIndex];
    //         if(lists[minIndex] != null){
    //             lists[minIndex] = lists[minIndex].next;
    //             helper(lists, trav.next);
    //         }
    //         return null;
    //     }
    // }
}
