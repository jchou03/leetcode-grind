// rotate linked list

public class RotateLinkedList {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int i){

//  first get length of LL
// then rotate LL to the left by length - i

        int len = LLlength(head);
        if(len == 0) return head;
        // System.out.println("len: " + len);
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode h = head;
        for(int j = 0; j < (len - (i%len)); j++){
            // System.out.println(j);
            prev = h;
            h = h.next;
        }
        

        prev.next = null;
        return h;
    }

    public int LLlength(ListNode head){

        if(head == null) return 0;
        ListNode prev = head;
        int i = 1;
        while(prev.next != null){
            i++;
            prev = prev.next;
        }
        prev.next = head;
        return i;
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