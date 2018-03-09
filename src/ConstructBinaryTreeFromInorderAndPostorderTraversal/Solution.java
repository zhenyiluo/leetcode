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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length ) return null;
        return build(inorder, 0, inorder.length -1, postorder, 0, postorder.length -1);
    }

    private TreeNode build(int[] inorder, int left1, int right1, int[] postorder, int left2, int right2){
        if(left1 > right1) return null;
        if(left1 == right1) return new TreeNode(inorder[left1]);
        int target = postorder[right2];
        int pivot = findPivot(target, inorder, left1, right1);
        TreeNode root = new TreeNode(target);
        int len = pivot - left1;
        root.left = build(inorder, left1, pivot -1, postorder, left2, left2 + len -1);
        root.right = build(inorder, pivot + 1, right1, postorder, left2 + len, right2 -1);
        return root;
    }

    private int findPivot(int target, int[] inorder, int left, int right){
        for(int i = left; i <= right; i++){
            if(inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
}