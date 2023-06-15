// rotate linked list

public class RotateLinkedList {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode rotateLinkedList(ListNode head, int i){
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode h = head;
        for(int j = 0; j < i; j++){
            prev = h;
            if(h.next != null){
                h = h.next;
            }else{
                h = head;
            }
        }

        
    }

}

/*
    Understand

    Match
        2 pointer linked list

    Plan

    Implement

    Review

    Examine
 */