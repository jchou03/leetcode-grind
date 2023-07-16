/*
undersatnd
    given the root of a binary tree, return a list of lists that contain the vertical order
    the input could be null

Match
    in order traversal (recursion)
    use a hash map to store each node to a coordinate relative to the root

Plan
    use a recursive in order solution in order populate a hashmap storing the nodes in each column relative to 0 (root)
    then return list

 */
import java.util.*;
public class BinaryTreeVertical {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public static void main(String[] args){
        BinaryTreeVertical c = new BinaryTreeVertical();
        TreeNode root = c.new TreeNode(1, c.new TreeNode(3, c.new TreeNode(5), c.new TreeNode(3)), c.new TreeNode(2, null, c.new TreeNode(9)));
        
    }

    TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    public List<List<Integer>> binaryTreeVertical (TreeNode root){
        helper(root, 0);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for(Map.Entry<Integer, List<Integer>> i : map.entrySet()){
            res.add(i.getValue());
        }
        return res;
    }
    private void helper(TreeNode root, int col){
        if(root == null) return;
        if(map.containsKey(col)){
            map.get(col).add(root.val);
        }else{
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(root.val);
            map.put(col, list);
        }
        helper(root.left, col-1);
        helper(root.right, col + 1);
    }
}
