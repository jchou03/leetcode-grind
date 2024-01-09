package grind.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
- given a binary tree root
- need to return the zigzag level order traversal
    - each level should have its own list
    - the directions should alternate
    - start from left to right, then right to left, etc
- edge cases:
    - null root? 

plan:
- go layer by layer and use a stack vs queue depending on the layer
- use stack to store the next layer
- go through each data structure then use the other one
 */

public class M103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> right = new Stack<TreeNode>();
        Stack<TreeNode> left = new Stack<TreeNode>();

        left.push(root);

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root == null) return res;

        while(!left.isEmpty() || !right.isEmpty()){
            // left order
            List<Integer> layer = new ArrayList<Integer>();
            while(!left.isEmpty()){
                TreeNode c = left.pop();
                layer.add(c.val);
                if(c.left != null) right.push(c.left);
                if(c.right != null) right.push(c.right);
            }
            if(!layer.isEmpty()) res.add(layer);
            // right order
            layer = new ArrayList<Integer>();
            while(!right.isEmpty()){
                TreeNode c = right.pop();
                layer.add(c.val);
                if(c.right != null) left.push(c.right);
                if(c.left != null) left.push(c.left);
            }
            if(!layer.isEmpty()) res.add(layer);
        }

        return res;
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
