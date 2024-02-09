package grind.Medium;

import java.util.ArrayList;

/*
 * reorder a linked list 
 */

public class M143 {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> arr = new ArrayList<ListNode>();

        ListNode trav = head;
        while(trav != null){
            arr.add(trav);
            trav = trav.next;
        }

        trav = head;
        int i = 0;
        while(i < arr.size()/2){
            trav.next = arr.get(i);
            trav = trav.next;
            trav.next = arr.get(arr.size() - 1 - i);
            trav = trav.next;
            i++;
        }

        if(arr.size() % 2 == 1){
            trav.next = arr.get((arr.size()/2));
            trav = trav.next;
        }

        trav.next = null;
    }
}
