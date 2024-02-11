public class E226 {
    public TreeNode invertTree(TreeNode root) {
        // recursive solution
        // for each root, swap left and right
        return helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            helper(root.left);
            helper(root.right);
        }

        return root;
    }
}
