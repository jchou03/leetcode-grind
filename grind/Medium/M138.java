
/* copy linked list with random pointers */

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Node;

public class M138 {
    public Node copyRandomList(Node head) {
        // use a hashmap to create a copy of each node
        Node trav = head;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        while(trav != null){
            if(!map.containsKey(trav)){
                map.put(trav, new Node(trav.val));
            }
            trav = trav.next;
        }
        trav = head;
        Node newHead = map.get(head);
        while(trav != null){
            map.get(trav).next = map.get(trav.next);
            map.get(trav).random = map.get(trav.random);
            trav = trav.next;
        }

        return map.get(head);
    }
}
