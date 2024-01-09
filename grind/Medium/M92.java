package grind.Medium;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 /*
understand:
- given linked list
- given ints left <= right
- need to reverse the nodes between left and right
- keep rest of LL the same
- return head

plan:
- use stack to keep track of the elements between left and right
- save a prev 
- iterate over LL until you hit left
- 
- keep adding nodes into stack until you come across right
- save right.next for later
- add stack nodes back in reverse order
- connect end of reversal with right.next
- return head

runtime: 100%, memory: 5%

 */

public class M92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> stack = new Stack<ListNode>();
        int i = 1;
        ListNode h = head;
        ListNode prev = head;
        ListNode rightNext = null;
        ListNode trav = head;
        while(trav != null){
            while(i >= left && i < right){
                stack.add(trav);
                trav = trav.next;
                i++;
            }
            if(i == right){
                if(left == 1){
                    h = trav;
                }
                rightNext = trav.next;
                prev.next = trav;
                while(!stack.isEmpty()){
                    trav.next = stack.pop();
                    trav = trav.next;
                }
                trav.next = rightNext;
            }
            prev = trav;
            trav = trav.next;
            i++;
        }
        return h;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
