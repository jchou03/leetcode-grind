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

    /*
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // use a trav for each of the lists and greedily add the smaller of the 2 since both lists are sorted
        ListNode head = (list1 != null && list2 == null) || (list1 != null && list2 != null && list1.val <= list2.val) ? list1 : list2;
        ListNode trav = head;
        if(head == null) return head;

        if(list1 != null && head.val == list1.val){
            list1 = list1.next;
        }else{
            list2 = list2.next;
        }

        while(list1 != null || list2 != null){
            // ListNode travler = list2;
            
            // System.out.printf("l1: %d, l2: %d, trav: %d\n", list1.val, list2.val, trav.val);
            
            // while(travler != null){
            //     System.out.printf("%d,", travler.val);
            //     travler = travler.next;
            // }

            // System.out.println();

            if((list1 != null && list2 == null) || (list1 != null && list2 != null && list1.val < list2.val)){
                // System.out.println("case 1");
                trav.next = list1;
                list1 = list1.next;
                trav = trav.next;
            }else{
                // System.out.println("case 2");
                trav.next = list2;
                // System.out.println(list2.val);
                // System.out.println(list2.next.val);
                list2 = list2.next;
                trav = trav.next;

                // System.out.println(list2.val);
            }
        }

        return head;
    }
     */
}
