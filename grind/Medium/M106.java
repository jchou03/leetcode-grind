package grind.Medium;

import java.util.HashMap;

 /*
understand:
- given lists of ints
    - one of inorder traversal of binary tree
    - one of postorder traversal of binary tree
- need to return root to the constructed tree

plan:
- can recursively solve the problem
- keep track of the index which will be the root (backwards through the postorder)
- keep track of the left and right ranges for which to build the subtree (given by the inorder traversal)
- create lookup table for the inorder traversal to create boundaries
 */

public class M106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            lookup.put(inorder[i], i);
        }
        return build(inorder, postorder, lookup, new Index(postorder.length - 1), 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, HashMap<Integer, Integer> lookup, Index postIndex, int left, int right){
        if(postIndex.val < 0 || left > right){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex.val]);
        postIndex.val--;

        if(left != right){
            root.right = build(inorder, postorder, lookup, postIndex, lookup.get(root.val) + 1, right);
            root.left = build(inorder, postorder, lookup, postIndex, left, lookup.get(root.val) - 1);
        }

        return root;
    }

    class Index{
        public int val;
        public Index(int val){
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
