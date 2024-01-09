package grind.Easy;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
understand:
- given the root of a binary search tree
- need to return the minimum absolute difference between values between 2 different nodes in the tree
- could the root be null? what to return in that case? 
    - number of nodes in tree is at least 2

plan:
- in order to get the minimum difference between two values, can sort the values and iterate over them comparing neighboring pairs
- a binary search tree is already in sorted order
    - can explore the bst recursevely
        - add nodes to the stack until leftmost node is found
        - keep track of a prev value and a min dist value

runtime: 100%, memory: 7%


        */

public class E530 {
    public int getMinimumDifference(TreeNode root) {
        return Math.abs(getMinDist(root, new Prev(-1)));
    }

    private int getMinDist(TreeNode root, Prev prev){
        if(root == null) return Integer.MAX_VALUE;
        int leftMin = getMinDist(root.left, prev);
        int curMin = root.val - prev.val;
        if(prev.val == -1) curMin = Integer.MAX_VALUE;
        prev.val = root.val;
        int rightMin = getMinDist(root.right, prev);
        return Math.min(Math.min(leftMin, curMin), rightMin);
    }

    class Prev {
        public int val;
        public Prev(int val){
            this.val = val;
        }
    }

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
}
