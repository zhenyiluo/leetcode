/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] ret = new int[1];
        dfs(root, ret);
        return ret[0];
    }
    
    private boolean dfs(TreeNode root, int[] ret){
        if(root == null){
            return true;
        }
        boolean left = dfs(root.left, ret);
        boolean right = dfs(root.right, ret);
        if(left && right){
            if(root.left != null && root.val != root.left.val){
                return false;
            }
            if(root.right != null && root.val != root.right.val){
                return false;
            }
            ret[0]++;
            return true;
        }
        return false;
    }
}