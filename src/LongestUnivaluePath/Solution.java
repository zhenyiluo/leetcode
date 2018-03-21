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
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ret;
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left != 0 && node.val != node.left.val){
            left = 0;
        }
        if(right != 0 && node.val != node.right.val){
            right = 0;
        }
        ret = Math.max(ret, left + right);
        return Math.max(left, right) + 1;
    }
}