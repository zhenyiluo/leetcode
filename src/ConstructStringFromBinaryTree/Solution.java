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
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        return dfs(t);
    }

    private String dfs(TreeNode node){
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        if(node.left == null && node.right == null){
            // Do nothing
        }else if(node.left != null && node.right != null){
            sb.append("(");
            sb.append(dfs(node.left));
            sb.append(")(");
            sb.append(dfs(node.right));
            sb.append(")");
        }else if(node.left == null){
            sb.append("()");
            sb.append("(");
            sb.append(dfs(node.right));
            sb.append(")");
        }else{
            sb.append("(");
            sb.append(dfs(node.left));
            sb.append(")");
        }
        return sb.toString();
    }
}