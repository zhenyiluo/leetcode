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
    List<String> ret = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return ret;
        }
        String s= String.valueOf(root.val);
        dfs(root, s);
        return ret;
    }
    
    private void dfs(TreeNode node, String s){
        if(node.left == null && node.right == null){
            ret.add(s);
            return;
        }
        
        if(node.left != null){
            dfs(node.left, s + "->" + node.left.val);
        }
        
        if(node.right != null){
            dfs(node.right, s + "->" + node.right.val);
        }
    }
}