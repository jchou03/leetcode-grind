/*
Understand
    - given a root of a binary tree, return same tree where every subtree that doesn't contain a 1 has been removed
    - since we are only dealing with subtrees, no need to worry about whether or not the current root is a 1 or not
    
match
    - we can approach with DFS to make all subtrees contain 1's

plan
    - recursive impelmentation using helper
    - helper check if there aren't any children, then check if cur val is 1 (return node) else return null (prunes non one leaves)

Examine
    - runtime O(n) since we need to visit every node 100%
    - memory O(logn) for the memory stack of recursive function calls of the depth of tree 57%
 */

public class BinaryTreePruning {
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
    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }
    private TreeNode helper(TreeNode root){
        if(root == null) return null;
        // prune leaves if they exist
        if(root.left != null) root.left = helper(root.left);
        if(root.right != null) root.right = helper(root.right);
        // check if leaf (after pruning) and if it is a leaf that is a 1, keep the node, else prune leaf
        if(root.left == null && root.right == null){
            if(root.val == 1){
                return root;
            }else{
                return null;
            }
        }
        return root;
    }

}
