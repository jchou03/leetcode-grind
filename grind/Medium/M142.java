package grind.Medium;
import java.util.*;

// LinkedList Cycle II

public class M142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode current = head;
        boolean cont = true;
        // use hashset to store the set of existing object
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(cont){
            if(current == null){
                return null;
            }
            boolean res = set.add(current);
            if(!res){
                cont = false;
            }else{
                current = current.next;
            }
        }
        return current;
    }
}
