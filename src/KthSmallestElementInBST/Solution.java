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
    public int kthSmallest(TreeNode root, int k) {
        int[] val = new int[]{k};
        dfs(root, val);
        return ret;
    }

    private void dfs(TreeNode root, int[] val){
        if(root == null) return;
        dfs(root.left, val);
        val[0] --;
        if(val[0] == 0){
            ret = root.val;
            return;
        }
        dfs(root.right, val);
    }
}