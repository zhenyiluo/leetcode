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
    public boolean checkEqualTree(TreeNode root) {
        HashSet<Integer> hsSum = new HashSet<>();
        int total = dfs(root, root, hsSum);
        if(total % 2 != 0) return false;
        return hsSum.contains(total/2);
    }

    private int dfs(TreeNode node, TreeNode root, HashSet<Integer> hsSum){
        if(node == null) return 0;
        int sum = node.val;
        int left = dfs(node.left, root, hsSum);
        int right = dfs(node.right, root, hsSum);
        sum += left + right;
        if(node != root){
            hsSum.add(sum);
        }
        return sum;
    }
}