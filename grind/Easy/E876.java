package grind.Easy;

// Find the middle of a linked list

public class E876 {
    class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode (int val) {this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode pointer = head;
        int length = 0;
        while(pointer.next != null){
            pointer = pointer.next;
            length++;
            if((length - 1) % 2 == 0){
                mid = mid.next;
            }
        }
        return mid;
    }
}
