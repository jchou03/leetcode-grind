package grind.Medium;
import java.util.*;

// Binary Tree Level Order Traversal

public class M102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lvlOrder = new ArrayList<List<Integer>>();
        return helper(root, lvlOrder, 0);
    }
    private List<List<Integer>> helper(TreeNode root, List<List<Integer>> lvlOrder, int lvl){
        if(root != null){
            if(lvl >= lvlOrder.size()){
                lvlOrder.add(new ArrayList<Integer>());
            }
            lvlOrder.get(lvl).add(root.val);
            if(root.left != null){
                helper(root.left, lvlOrder, lvl + 1);
            }
            if(root.right != null){
                helper(root.right, lvlOrder, lvl + 1);
            }
        }
        return lvlOrder;
    }

    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null){
            return res;
        }else{
            q1.add(root);
            while(!q1.isEmpty() || !q2.isEmpty()){
                ArrayList<Integer> level = new ArrayList<Integer>();
                while(!q1.isEmpty()){
                    TreeNode n = q1.poll();
                    if(n.left != null) q2.add(n.left);
                    if(n.right != null) q2.add(n.right);
                    level.add(n.val);
                }
                res.add(level);
                q1 = q2;
                q2 = new LinkedList<TreeNode>();
            }
        }
        return res;
    }
     */
}
