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
    TreeNode last;
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode right = root.right;
        if(last != null){
            last.left = null;
            last.right = root;
        }
        last = root;
        flatten(root.left);
        flatten(right);
    }
}