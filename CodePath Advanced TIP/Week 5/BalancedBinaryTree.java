/*
understand
    given a root node, determine if a binary tree is height balanced (depth of every 2 subtrees don't differ by more than 1)
    - if there are no children (only root) then it is balanced
    - even if two subtrees are balanced, how could I keep track of the depth of the 2 balanced subtrees? 

match
    tree problem - recursive solution is likely a good choice
    stack or queue implementation has potential as well depending on the order we want to process cells

plan
    use a helper function to determine the height of the two subtrees, and compare 

examine
    runtime: O(n) since we visit every node 93%
    memory: O(h) where h is the height of the binary tree due to the memory of the recursive calls 64%

*/

import java.util.*;

public class BalancedBinaryTree{
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
    public boolean isBalanced(TreeNode root) {
        int res = height(root);
        return res != -1;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        // return -1 if it is unbalanced
        if(lheight == -1 || rheight == -1 || (Math.abs(lheight - rheight) > 1)) return -1;
        return Math.max(lheight, rheight) + 1;
    }
}