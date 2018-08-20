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
    public int rob(TreeNode root) {
        int[] ret = dfs(root);
        return ret[0];
    }

    private int[] dfs(TreeNode node){
        if(node == null) return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int max1 = node.val + left[1] + right[1];
        int max2 = left[0] + right[0];
        return new int[]{Math.max(max1, max2), max2};
    }
}