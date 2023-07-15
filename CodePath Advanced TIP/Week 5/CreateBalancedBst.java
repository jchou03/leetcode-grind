/*
Understand
    given a sorted array, create a balanced binary trees

Match
    use binary search to create the balanced binary tree

Plan
    use helper function that takes in a a starting and ending index and returns a treenode from middle value then recursevely call on left and right

Examine
    O(n) runtime 100%
    O(n) memory 53%
 */

public class CreateBalancedBst {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start >= end) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
