/*
Understand
    - given a root node for a binary tree, return a list of the nodes that can be seen from the right side
    - level based traversal would be helpful in order to determine the rightmost node in each level

Plan
    - use 2 queues to store the nodes from right to left on each level (then add the first/rightmost node to the answer list)

Examine:
    O(n) for memory and runtime
    runtime: 66%
    memory: 11%
 */
import java.util.*;

public class BinaryTreeSideView {
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        if(root != null) nextLevel.add(root);
        TreeNode cur;
        while(!curLevel.isEmpty() || !nextLevel.isEmpty()){
            while(!curLevel.isEmpty()){
                cur = curLevel.poll();
                // System.out.println("cur: " + cur.val);
                if(cur.right != null) nextLevel.add(cur.right);
                if(cur.left != null) nextLevel.add(cur.left);
            }
            if(!nextLevel.isEmpty()){
                res.add(nextLevel.peek().val);
            } 
            curLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
        }
        return res;
    }
}
