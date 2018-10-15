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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        return dfs(root, 0, sum, hm);
    }

    private int dfs(TreeNode node, int sum, int target, HashMap<Integer, Integer> hm){
        if(node == null) return 0;
        sum += node.val;
        int ret = hm.getOrDefault(sum - target, 0);
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        ret += dfs(node.left, sum, target, hm) + dfs(node.right, sum, target, hm);
        hm.put(sum, hm.get(sum) -1);
        return ret;
    }
}