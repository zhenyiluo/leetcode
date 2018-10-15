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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private int dfs(List<List<Integer>> ans, TreeNode node){
        if(node == null) return -1;
        int level = 1 + Math.max(dfs(ans, node.left), dfs(ans, node.right));
        if(ans.size() < level + 1){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        return level;
    }
}