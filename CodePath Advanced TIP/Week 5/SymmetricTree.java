/*
Understand
    - check if a binary tree is symetric (given its root)
    - number of nodes is in range [1, 1000]
    - node vals are in range [-100, 100] (integers)

Match
    - binary tree problem
    - could use BFS to build out a queue of nodes we need to visit on each side

Plan
    - check for edge case of only a root node (is symetrical)
    - create a treenode queue for the left and right side of the tree
    - add the left and right into their respective queues
    - enter while loop (while leftQueue.size == rightQueue.size and not 0)
        - pop the first element from both queues
        - check if their value is the same (if not, return false)
        - add their children into each respective queues (but flip the order)
    - return true (if we didn't fail an earlier case)

Evaluate
    runtime O(n) since we need to visit every node 13%
    memory O(n) since we need to store every node in one of 2 queues 64%

 */

import java.util.*;

 public class SymmetricTree {
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

    // try recursive solution by checking each subtree for symmetry
    public boolean isSymmetric(TreeNode root){
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }else if(l == null || r == null){
            return false;
        }else{
            return l.val == r.val && helper(l.left, r.right) && helper(l.right, r.left);
        }
    }



    // public boolean isSymmetric(TreeNode root){
    //     // case of only root node
    //     if(root.left == null && root.right == null) return true;
    //     Queue<TreeNode> lq = new LinkedList<TreeNode>();
    //     Queue<TreeNode> rq = new LinkedList<TreeNode>();
    //     TreeNode left;
    //     TreeNode right;
    //     lq.add(root.left);
    //     rq.add(root.right);
        
    //     while(!lq.isEmpty() && !rq.isEmpty()){
    //         left = lq.poll();
    //         right = rq.poll();
    //         if((left == null && right !=null) || (right == null && left != null)) return false;
    //         if(left != null && right != null && left.val != right.val){
    //             return false;
    //         }
    //         if(left != null){
    //             lq.add(left.left);
    //             lq.add(left.right);
    //         }
    //         if(right != null){
    //             rq.add(right.right);
    //             rq.add(right.left);
    //         }
    //     }

    //     if(lq.size() != rq.size()) return false;

    //     return true;
    // }
}
