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
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, new ArrayList<>(), sum);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> list, int sum){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                ret.add(new ArrayList<>(list));
            }
        }
        sum -= root.val;
        dfs(root.left, list, sum);
        dfs(root.right, list, sum);
        list.remove(list.size() -1);
    }
}