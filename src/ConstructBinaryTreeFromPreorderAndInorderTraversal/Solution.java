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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
    }

    private TreeNode build(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2){
        if(left1 > right1) return null;
        if(left1 == right1) return new TreeNode(preorder[left1]);
        int target = preorder[left1];
        int pivot = findPivot(target, inorder, left2, right2);
        int len = pivot - left2;
        TreeNode root = new TreeNode(preorder[left1]);
        root.left = build(preorder, left1 + 1, left1 + len, inorder, left2, pivot - 1);
        root.right = build(preorder, left1 + len + 1, right1, inorder, pivot +1, right2);
        return root;
    }

    private int findPivot(int target, int[] order, int left, int right){
        for(int i = left; i<= right; i++){
            if(order[i] == target) return i;
        }
        return -1;
    }
}