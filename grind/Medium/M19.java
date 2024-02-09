package grind.Medium;

/*
remove the nth node from end of a linked list
O(n)
runtime: 100%, memory: 62%
 */


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class M19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // first get length of the list
        int len = 0;
        ListNode trav = head;
        while(trav != null){
            len++;
            trav = trav.next;
        }
        // then iterate until the remove index
        if(n == len){
            return head.next;
        }else{
            ListNode prev = head;
            trav = head.next;
            int iter = 1;
            while(iter != len - n){
                prev = prev.next;
                trav = trav.next;
                iter++;
            }
            prev.next = trav.next;
        }
        // then attach prev.next = trav.next
        // return head
        return head;
    }
}
