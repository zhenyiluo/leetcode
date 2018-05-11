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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;
        return buildTree(inorder, 0, inorder.length -1, postorder, 0, postorder.length -1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(postStart > postEnd) return null;
        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);
        int pivot = findPivot(inorder, inStart, inEnd, val);
        int len = pivot - inStart;
        node.left = buildTree(inorder, inStart, pivot -1, postorder, postStart, postStart + len -1);
        node.right = buildTree(inorder, pivot + 1, inEnd, postorder, postStart + len, postEnd -1);
        return node;
    }

    private int findPivot(int[] arr, int start, int end, int target){
        for(int i = start; i <= end; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}