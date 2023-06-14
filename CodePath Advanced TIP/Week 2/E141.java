import java.util.*;

// check for loops in a linked list
// runtime: 14%, memory: 92%

public class E141 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(head != null){
            // if the set already has the current listnode, then return false
            if(!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}

/*
Understand:
    - we are given the head of a linked list
    - need to determine if there is a loop within the linked list

Match:
    - LinkedList, so no moving backwards in the list

Plan:
    Easy solution, store reach ListNode in a set, and return true if you try to put a preexisting node into the set


Implement:

Review:

Examine:
runtime: O(n)
memory: O(n)

*/