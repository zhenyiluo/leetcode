/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ret = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return ret;
    }
    private boolean dfs(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if(left && right){
            if(root.left != null && root.left.val != root.val){
                return false;
            }
            if(root.right != null && root.right.val != root.val){
                return false;
            }
            ret++;
            return true;
        }
        return false;
    }
}