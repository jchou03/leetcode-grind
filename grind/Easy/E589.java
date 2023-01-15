package grind.Easy;
import java.util.*;

public class E589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<Integer>();
        return helper(root, ls);
    }

    private List<Integer> helper(Node root, List<Integer> ls){
        if(root != null){
            ls.add(root.val);
            for(int i = 0; i < root.children.size(); i++){
                helper(root.children.get(i), ls);
            }
        }
        return ls;
    }
}
