package grind.Medium;

public class M235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // different cases based on whether or not the root is on the left, right, or middle of the two nodes
        // if root is on the left of the two values
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }

    /*

    worse solution: forgot it was BST
     * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q, new HashSet<TreeNode>());
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q, HashSet<TreeNode> set){
        if(root != null){
            HashSet<TreeNode> leftSet = new HashSet<TreeNode>();
            TreeNode left = helper(root.left, p, q, leftSet);
            if(left != null) return left;

            HashSet<TreeNode> rightSet = new HashSet<TreeNode>();
            TreeNode right = helper(root.right, p, q, rightSet);
            if(right != null) return right;
            
            set.add(root);
            set.addAll(leftSet);
            set.addAll(rightSet);
            if(set.contains(p) && set.contains(q)) return root;
        }

        return null;
    }
     * 
     */
}
