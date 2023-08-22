
/* copy linked list with random pointers */

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Node;

public class M138 {
    public Node copyRandomList(Node head) {
        // use a multiple iteration approach
        // use a map to store the val that a random node points to
        // use a list to store the vals for each node in LL
        ArrayList<Node> list = new ArrayList<Node>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        Node trav = head;
        while(trav != null){
            list.add(new Node(trav.val));
            map.put(trav.val, counter);
            counter++;
            trav = trav.next;
        }
        System.out.println("Map: " + map);

        Node originalTrav = head;
        for(int i = 0; i < list.size() - 1; i++){
            Node cur = list.get(i);
            System.out.println(cur.val);
            cur.next = list.get(i + 1);
            
            Integer random = map.get(originalTrav.random.val);
            if(random == null){
                cur.random = null;
            }else{
                cur.random = list.get(map.get(originalTrav.random.val));
            }
            originalTrav = originalTrav.next;
            System.out.println("orignalTrav: " + originalTrav.val);
        }
        System.out.println("trav random: " + originalTrav.random.val);
        Node last = list.get(list.size() - 1);
        last.random = list.get(map.get(originalTrav.random.val));
        return list.get(0);
    }
}
