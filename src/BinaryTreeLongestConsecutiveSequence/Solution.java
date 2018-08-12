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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null){
            max = Math.max(1, max);
            return 1;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int ans = 1;
        if(node.left != null && node.val +1 == node.left.val){
            ans = Math.max(ans, left + 1);
        }
        if(node.right != null && node.val +1 == node.right.val){
            ans = Math.max(ans, right + 1);
        }
        max = Math.max(max, ans);
        return ans;
    }
}