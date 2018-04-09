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
    List<Integer> ret = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return ret;
        ret.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return ret;
    }

    private void leftBoundary(TreeNode node){
        if(node == null || (node.left == null && node.right == null)) return;
        ret.add(node.val);
        if(node.left != null){
            leftBoundary(node.left);
        }else{
            leftBoundary(node.right);
        }
    }

    private void rightBoundary(TreeNode node){
        if(node == null || (node.left == null && node.right == null)) return;
        if(node.right != null){
            rightBoundary(node.right);
        }else{
            rightBoundary(node.left);
        }
        ret.add(node.val);
    }

    private void leaves(TreeNode node){
        if(node == null) return;
        if(node.left == null && node.right == null) ret.add(node.val);
        leaves(node.left);
        leaves(node.right);
    }
}