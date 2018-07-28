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
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        int[] ret = new int[1];
        ret[0] = Integer.MAX_VALUE;
        if(root == null) return 0;
        dfs(root, ret);
        return ret[0];
    }

    private void dfs(TreeNode node, int[] ret){
        if(node.left != null){
            dfs(node.left, ret);
        }

        if(prev != null){
            ret[0] = Math.min(ret[0], Math.abs(prev.val - node.val));
        }
        prev = node;
        if(node.right != null){
            dfs(node.right, ret);
        }
    }
}