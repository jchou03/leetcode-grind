package grind.Easy;
import grind.TreeNode;
import java.util.*;

// binary tree postorder traversal
// runtime: 100%, memory: 88%


public class E145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }else{
            List<Integer> res = postorderTraversal(root.left);
            res.addAll(postorderTraversal(root.right));
            res.add(root.val);
            return res;
        }
    }
}
