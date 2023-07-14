/*
Understand
    given root of tree, find the largest value in each tree row

Match
    level order implementation using 2 queues

Plan
    - implement level order traversel, and in each level, check for max and add to res

Examine
    - runtime: O(n) (need to visit each node) 82%
    - memory: O(2m) (where m is the max width of a tree) 80%
 */
import java.util.*;

public class LargestValueInTreeRow {
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
    public List<Integer> largestValueInTreeRow(TreeNode root){
        if(root == null) return new LinkedList<Integer>();
        Queue<TreeNode> curLev = new LinkedList<TreeNode>();
        Queue<TreeNode> nexLev = new LinkedList<TreeNode>();
        curLev.add(root);
        List<Integer> res = new LinkedList<Integer>();
        while(!(curLev.isEmpty() && nexLev.isEmpty())){
            int max = Integer.MIN_VALUE;
            while(!curLev.isEmpty()){
                TreeNode cur = curLev.poll();
                if(cur.left != null) nexLev.add(cur.left);
                if(cur.right != null) nexLev.add(cur.right);
                if(cur.val > max) max = cur.val;
            }
            res.add(max);
            curLev = nexLev;
            nexLev = new LinkedList<TreeNode>();
        }
        return res;
    }
}
