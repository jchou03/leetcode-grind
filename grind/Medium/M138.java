
/* copy linked list with random pointers */

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

        for(int i = 0; i < list.size() - 1; i++){
            Node cur = list.get(i);
            cur.next = list.get(i + 1);
            cur.random = list.get(map.get(cur.val));
        }

        list.get(list.size() - 1).random = list.get(map.get(list.get(list.size() - 1)));
        return list.get(0);
    }
}
