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
        helper(root, 0, root.val);
        return max;
    }

    private void helper(TreeNode node, int cur, int target){
        if(node == null) return;
        if(node.val == target){
            cur++;
        }else{
            cur = 1;
        }

        max = Math.max(max, cur);
        helper(node.left, cur, node.val + 1);
        helper(node.right, cur, node.val + 1);
    }
}