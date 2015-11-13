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
    int ret = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return ret;
    }
    
    private int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == -1 && right == -1){
            ret ++;
            return 1;
        }
        if(left == -1){
            if(root.val == root.right.val && right == 1){
                ret ++;
                return 1;
            }else{
                return 0;
            }
        }
        
        if(right == -1){
            if(root.val == root.left.val && left == 1){
                ret ++;
                return 1;
            }else{
                return 0;
            }
        }
        
        if(root.val == root.left.val && root.val == root.right.val && left == 1 && right == 1){
            ret++;
            return 1;
        }else{
            return 0;
        }
    }
}