/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ret;
        dfs(root, String.valueOf(root.val));
        return ret;
    }

    private void dfs(TreeNode root, String s){
        if(root.left == null && root.right == null){
            ret.add(s);
            return;
        }
        if(root.left != null){
            dfs(root.left, s + "->" + String.valueOf(root.left.val));
        }
        if(root.right != null){
            dfs(root.right, s + "->" + String.valueOf(root.right.val));
        }
    }
}