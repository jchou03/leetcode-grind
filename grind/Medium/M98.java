package grind.Medium;

public class M98 {
    class TreeNode{
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
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null, false);
    }

    private boolean helper(TreeNode root, TreeNode leftConstraint, TreeNode rightConstraint, boolean isLeft){
        // System.out.println("root: " + root.val + " leftConstraint: " + leftConstraint + " rightConstraint: " + rightConstraint);
        
        // check if the current node falls within its constraints
        if(leftConstraint != null && root.val <= leftConstraint.val){
            return false;
        }
        if(rightConstraint != null && root.val >= rightConstraint.val){
            return false;
        }
        
        // recursively check the left and right children
        boolean res = true;
        if(root.left != null){
            res = helper(root.left, leftConstraint, root, true);
        }
        if(root.right != null){
            res = res && helper(root.right, root, rightConstraint, false);
        }
        return res;
    }
}
