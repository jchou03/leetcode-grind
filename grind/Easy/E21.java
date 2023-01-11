package grind.Easy;

// Merge Two Sorted Lists

public class E21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // use two pointer approach
        // recursively add the minimum element between the two heads to the merged list
        ListNode head = new ListNode();
        helper(list1, list2, head);
        return head.next;
    }

    private void helper(ListNode l1, ListNode l2, ListNode tail){
        if(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                helper(l1.next, l2, tail.next);
            }else{
                tail.next = l2;
                helper(l1, l2.next, tail.next);
            }
        }else if (l1 != null && l2 == null){
            tail.next = l1;
            helper(l1.next, l2, tail.next);
        }else if (l1 == null && l2 != null){
            tail.next = l2;
            helper(l1, l2.next, tail.next);
        }
    }
}
