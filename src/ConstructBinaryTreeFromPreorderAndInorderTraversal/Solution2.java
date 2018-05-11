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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd) return null;
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int pivot = findPivot(inorder, inStart, inEnd, val);
        int len = pivot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, pivot -1);
        root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, pivot + 1, inEnd);
        return root;
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