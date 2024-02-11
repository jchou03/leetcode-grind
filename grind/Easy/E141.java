package grind.Easy;

import grind.ListNode;

/*
Check if LinkedList has a cycle
using fast & slow travlers

runtime: 100%, memory: 30%
 */

public class E141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        // use a fast and slow racer
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
