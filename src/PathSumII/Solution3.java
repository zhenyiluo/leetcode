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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root, sum, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, TreeNode node, int sum, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        if(node.left == null && node.right == null && node.val == sum){
            ans.add(new ArrayList<>(list));
        }
        sum -= node.val;
        dfs(ans, node.left, sum, list);
        dfs(ans, node.right, sum, list);
        list.remove(list.size() -1);
    }
}