package grind.Easy;

// Convert sorted array to binary search tree
// runtime: 100%, Memory: 54%

public class E108 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right) {this.val = val; this.left = left; this.right = right;}
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start < 0 || end >= nums.length || end < start){
            return null;
        }else if(start == end){
            return new TreeNode(nums[start]);
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
