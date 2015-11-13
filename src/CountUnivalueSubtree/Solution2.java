/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] ret = new int[1];
        dfs(root, ret, 0);
        return ret[0];
    }
    
    private boolean dfs(TreeNode root, int[] ret, int val){
        if(root == null){
            return true;
        }
        boolean left = dfs(root.left, ret, root.val);
        boolean right = dfs(root.right, ret, root.val);
        if(!left || !right){
            return false;
        }
        ret[0]++;
        return root.val == val;
    }
}