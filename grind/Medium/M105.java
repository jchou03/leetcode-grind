package grind.Medium;

import java.util.HashMap;

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
- preorder will always contain the root before the children
- inorder will contain left, then root, then right
- need to create the binary tree and return the root
- all unique node IDs
- guaranteed to be valid preorder and inorder traversals of the same tree

plan:
- recursive solution
- convert inorder into a map
- keep track of index in preorder 
    - the first element in preorder will aways be the root
    - inorder orders nodes from left to right, so keep track of the range in 
    - keep track of left and right child ranges that could possibly fall under the root
    - need to keep track of preorder index as it iterates through new values (preIndex stores leftmost unvisted value in preorder)

runtime: 68%, memory: 35%

 */

public class M105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // convert inorder into a hashmap lookup table
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            lookup.put(inorder[i], i);
        }

        return subTree(preorder, inorder, lookup, new Index(0), 0, inorder.length - 1);
    }

    private TreeNode subTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> lookup, Index preIndex, int left, int right){
        
        if(preIndex.val >= preorder.length || right < left){
            return null;
        }

        // create root
        TreeNode root = new TreeNode(preorder[preIndex.val]);
        preIndex.val++;
        // if this is not a leaf node
        if(left != right){
            root.left = subTree(preorder, inorder, lookup, preIndex, left, lookup.get(root.val) - 1);
            root.right = subTree(preorder, inorder, lookup, preIndex, lookup.get(root.val) + 1, right);
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
