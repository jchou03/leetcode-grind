// Swap Node in Pairs
// https://guides.codepath.org/compsci/swap-nodes-in-pairs
// runtime: 100%, memory: 95%

public class SwapNodeInPairs {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args){

    }   
    
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode p = h;
        ListNode a = p.next;
        while(a != null && a.next != null){
            p.next = a.next;
            a.next = a.next.next;
            p.next.next = a;
            
            p = a;
            a = a.next;
        }
        return h.next;
    }
    /*
        Understand:
            given head of linked list
            switch every 2 nodes in list
            cannot change values in nodes, only the pointers
            what happens in the case of an odd number of nodes? (just leave the last one as is?)

        Match:
            linked list -> leaning towards 2 pointer solution

        Plan:
            keep variable to store head
            use pointer a on head
            use pointer b on head.next
            a.next = b.next
            b.next = a
            a = a.next
            b = a.next

        Implement:

        Review:

        Examine:

     */
}
