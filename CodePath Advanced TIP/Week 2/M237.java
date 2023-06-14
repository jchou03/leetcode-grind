// 237. Delete Node in a Linked List
// runtime: 100%, memory: 24%



class Solution {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        // check that there are still 2 nodes until the tail (so we can delete the tail)
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }

        // now there is only the tail left, so we get rid of it
        node.val = node.next.val;
        node.next = null;
    }
}

/*

UMPIRE
Understand
    We are given a node that is in the linked list that is to be removed
    we do not have access to the head of the linked list
    the node to be deleted is guaranteed to not be the tail

input: [1, 2, 3, 4, 5], 3
output: [1, 2, 4, 5]

Match
    this is a linked list problem, so we can't go backwards in the list to reach anything in front of the deleted node

Plan
    lets just shift over all the values in the linked list by 1 to the left, and then delete the tail

Implement

Review

Evaluate
    Runtime: O(n)
    Memory: O(1)
*/