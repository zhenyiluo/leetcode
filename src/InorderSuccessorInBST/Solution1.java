/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }else{
            TreeNode left = inorderSuccessor(root.left, p);
            if(left != null){
                return left;
            }else{
                return root;
            }
        }
    }
    
    
}