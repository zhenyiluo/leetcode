/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ret = new int[1];
        int sum = 0;
        sumNumbers(root, sum, ret);
        return ret[0];
    }
    
    private void sumNumbers(TreeNode root, int sum, int[] ret) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            ret[0] += sum;
            return;
        }
        sum *= 10;
        if (root.left != null) {
            sumNumbers(root.left, sum, ret);
        }
        
        if (root.right != null) {
            sumNumbers(root.right, sum, ret);
        }
    }
}