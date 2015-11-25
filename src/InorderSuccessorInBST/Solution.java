/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        
        return helper(root, p);
    }
    
    private TreeNode helper(TreeNode root, TreeNode p){
        if(root == null){
            return null;
        }
        TreeNode left = helper(root.left, p);
        if(left != null){
            return left;
        }
        
        if(flag){
            return root;
        }
        
        if(root.val == p.val){
            flag = true;
        }
        
        return helper(root.right, p);
    }
    
}