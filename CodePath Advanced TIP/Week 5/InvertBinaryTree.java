/*
Understand
    given the root of a binary tree 
    need to invert (so swap the left and right of each node)
    then need to return the root node

Match
    we could use recursion to solve this problem
    could we use any other data structure to make this solution easier? 
        - a queue could help us iterate over all the nodes we need to visit and swap their children
        - same with a stack

Plan
    if the input is null, return null
    else - create a temp to store left
        - node.left = invert(node.right)
        - node.right = invert(temp)

Evaluate
    runtime O(n) solution since we need to visit every node in some way - 100%
    memory O(1) since we only store one temp variable - 82%

 */


public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root){
        if(root == null) return null;
        // in this case, root isn't null, so return the inversion
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
