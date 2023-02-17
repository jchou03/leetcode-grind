package grind.Easy;
import grind.ListNode;

// Remove duplicates from sorted list
// runtime: 100%, memory: 80%

public class E83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.next.val == current.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}
