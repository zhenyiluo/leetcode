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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);
        if(prev != null){
            if(first == null && prev.val > node.val){
                first = prev;
            }
            if(first != null && prev.val > node.val){
                second = node;
            }
        }
        prev = node;
        dfs(node.right);
    }
}