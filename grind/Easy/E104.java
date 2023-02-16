package grind.Easy;

import grind.TreeNode;

// max depth of binary tree
// runtime: 100%, memory: 93%


public class E104 {
    public int maxDepth(TreeNode root) {
        // recursivly perform DFS to determine max depth
        if(root == null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
