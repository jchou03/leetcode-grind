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
}
