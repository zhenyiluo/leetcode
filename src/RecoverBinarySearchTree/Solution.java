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
    List<TreeNode> list = new ArrayList<TreeNode>();
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        
        if(list.size() > 0){
            swapTwoNodes(list.get(0), list.get(list.size() - 1));
        }
    }
    
    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        
        if(prev != null && prev.val > node.val){
            list.add(prev);
            list.add(node);
        }
        prev = node;
        
        dfs(node.right);
    }
    
    private void swapTwoNodes(TreeNode node1, TreeNode node2){
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}