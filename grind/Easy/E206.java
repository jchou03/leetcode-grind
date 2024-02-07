package grind.Easy;

import java.util.Stack;

// Reverse Linked List

public class E206 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();

        // store stack of reversed elements
        while(head != null){
            stack.add(head);
            head = head.next;
        }

        if(stack.isEmpty()) return null;

        ListNode returnHead = stack.pop();
        ListNode trav = returnHead;
        while(!stack.isEmpty()){
            trav.next = stack.pop();
            trav = trav.next;
        }

        trav.next = null;

        return returnHead;
    }

    // public ListNode reverseList(ListNode head) {
    //     return helper(head, null);

    // }
    // private ListNode helper(ListNode head, ListNode rev){
    //     // take current head, and attach it to the front of the rev list so far
    //     if(head == null){
    //         return rev;
    //     }else{
    //         ListNode tmp = head.next;
    //         head.next = rev;
    //         return helper(tmp, head);
    //     }
    // }
}
