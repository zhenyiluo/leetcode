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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum){
        if(node == null) return 0;
        int ans = 0;
        if(node.val == sum){
            ans ++;
        }
        sum -= node.val;
        ans += pathSumFrom(node.left, sum) + pathSumFrom(node.right, sum);
        return ans;
    }
}