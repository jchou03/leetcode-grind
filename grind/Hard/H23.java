package grind.Hard;
import grind.ListNode;

/*
 * Merge k sorted LinkedLists
 * runtime: O(n^2)
 */

public class H23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists, null);
    }

    // n^2 solution (could use priority queue to solve faster)
    private ListNode helper(ListNode[] lists, ListNode trav){
        // lists should contain the current trav node for each of the lists
        int minIndex = 0;
        for(int i = 1; i < lists.length; i++){
            if(lists[i] != null && (lists[minIndex] == null || lists[i].val < lists[minIndex].val)){
                minIndex = i;
            }
        }
        
        if(trav == null){
            // this is the first call to helper, then need to iterate through all to find the min value
            ListNode root = lists[minIndex];
            if(lists[minIndex] != null){
                lists[minIndex] = lists[minIndex].next;
                helper(lists, root);
            }
            return root;
        }else{
            trav.next = lists[minIndex];
            if(lists[minIndex] != null){
                lists[minIndex] = lists[minIndex].next;
                helper(lists, trav.next);
            }
            return null;
        }
    }
}
