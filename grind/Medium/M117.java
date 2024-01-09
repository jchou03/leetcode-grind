package grind.Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
understand:
- given the root of a binary tree
- each node as a next property which needs to be populated
    - the next property should be the next node that is to the right of the node in the tree
    - the next for the rightmost node in each layer should be null
    - constant extra space
    - is it possible that the tree isn't balanced?

plan: 
- can use bfs with layer count to determine the layer of each node
- traverse the binary tree utilizing BFS
- add the layer of each node
- the next of each node is the next node visited in the same layer

runtime: 5%, memory: 9%

*/

public class M117 {
    public Node connect(Node root) {
        if(root == null) return root;
        HashMap<Node, Integer> layer = new HashMap<Node, Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        root.next = null;
        queue.add(root);
        layer.put(root, 0);

        while(!queue.isEmpty()){
            Node c = queue.poll();
            if(c.left != null){
                layer.put(c.left, layer.get(c) + 1);
                queue.add(c.left);
            }
            if(c.right != null){
                layer.put(c.right, layer.get(c) + 1);
                queue.add(c.right);
            }

            if(!queue.isEmpty() && layer.get(c) == layer.get(queue.peek())){
                c.next = queue.peek();
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
