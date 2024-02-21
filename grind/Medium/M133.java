package grind.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// create a deep copy of a undirected, connected graph
// runtime: 46%, memory: 5%

public class M133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        // create an adjacency list (dfs)
        // node values are unique
        HashMap<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
        dfs(node, adj);
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        // then iterate over adjacency list to connect all the nodes
        for(Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()){
            int val = entry.getKey();
            if(!map.containsKey(val)){
                map.put(val, new Node(val));
            }
            for(int n : entry.getValue()){
                if(!map.containsKey(n)){
                    map.put(n, new Node(n));
                }
                map.get(val).neighbors.add(map.get(n));
            }
        }
        System.out.println(adj);
        System.out.println(map);
        // return original node
        return map.get(node.val);
    }

    private void dfs(Node node, HashMap<Integer, Set<Integer>> map) {
        if(!map.containsKey(node.val)){
            map.put(node.val, new HashSet<Integer>());
        }
        for(Node n : node.neighbors){
            map.get(node.val).add(n.val);
            if(!map.containsKey(n.val)) dfs(n, map);
        }
    }
}
