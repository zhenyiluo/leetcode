/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, list, ret);
        return ret;
    }
    
    
    private void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new ArrayList<>(list));
        }
        
        pathSum(root.left, sum, list, ret);
        pathSum(root.right, sum, list, ret);
        list.remove(list.size()-1);
    }
    
}