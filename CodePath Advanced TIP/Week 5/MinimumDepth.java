/*
Understand
    given the root of a tree, find the minimum depth of a tree
    the tree could be null


Match
    - this sounds like a BFS problem implemented with a queue

Plan
    - implement BFS with a queue (using null value to check between levels)

Examine
    O(n) solution
    runtime: 99%
    memory: 98%

 */
import java.util.*;
public class MinimumDepth {
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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        TreeNode cur;
        int level = 0;
        if(root != null){
            curLevel.add(root);
            level++;
        } 
        while(!curLevel.isEmpty() || !nextLevel.isEmpty()){
            while(!curLevel.isEmpty()){
                cur = curLevel.poll();
                if(cur != null){
                    if(cur.left == null && cur.right == null){
                        return level;
                    }
                    if(cur.left != null) nextLevel.add(cur.left);
                    if(cur.right != null) nextLevel.add(cur.right);
                }
            }
            // System.out.println("level complete: " + level);
            level++;
            curLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
        }
        return level;
    }
}
