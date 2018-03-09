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

    HashMap<TreeNode, Integer> cache = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) >1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root){
        if(root == null) return 0;
        if(cache.containsKey(root)) return cache.get(root);
        int ret = 1 + Math.max(getDepth(root.left), getDepth(root.right));
        cache.put(root, ret);
        return ret;
    }

}