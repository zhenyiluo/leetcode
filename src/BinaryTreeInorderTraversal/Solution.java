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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        dfs(root, ret);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> ret){
        if (root == null) return;
        dfs(root.left, ret);
        ret.add(root.val);
        dfs(root.right, ret);
    }
}