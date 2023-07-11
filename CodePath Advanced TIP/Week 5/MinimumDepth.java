/*
Understand
    given the root of a tree, find the minimum depth of a tree
    the tree could be null


Match
    - this sounds like a BFS problem implemented with a queue

Plan
    - implement BFS with a queue (using null value to check between levels)

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
        while(!curLevel.isEmpty() || !nextLevel.isEmpty()){
            while(!curLevel.isEmpty()){
                cur = curLevel.poll();
                if(cur == null) return level - 1;
                nextLevel.add(cur.left);
                nextLevel.add(cur.right);
            }
            level++;
            curLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
        }
        return level;
    }
}
