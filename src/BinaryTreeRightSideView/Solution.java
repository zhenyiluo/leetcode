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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        dfs(root, ret, 0);
        return ret;
    }

    private void dfs(TreeNode node, List<Integer> ret, int curLevel){
        if(node == null) return;
        if(curLevel == ret.size()){
            ret.add(node.val);
        }
        dfs(node.right, ret, curLevel +1);
        dfs(node.left, ret, curLevel +1);
    }
}