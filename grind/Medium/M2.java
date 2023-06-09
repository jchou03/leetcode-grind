package grind.Medium;

// add two numbers (stored in reverse order in linked list)
// runtime: 99%, memory: 21%

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode((l1.val + l2.val) % 10);
        ListNode head = res;
        int tempSum = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            if(l1 != null){
                tempSum += l1.val;
                l1 = l1.next;
            } 
            if(l2 != null){
                tempSum += l2.val;
                l2 = l2.next;
            } 
            head.next = new ListNode(tempSum % 10);
            head = head.next;
            tempSum /= 10;
        }
        
        if(tempSum > 0){
            head.next = new ListNode(tempSum);
        }
        return res;
    }
}