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
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<>();
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right){
        List<TreeNode> ret = new ArrayList<>();
        if(left > right){
            ret.add(null);
            return ret;
        }
        for(int i = left; i <= right; i++){
            List<TreeNode> leftTree = dfs(left, i-1);
            List<TreeNode> rightTree = dfs(i+1, right);
            for(int j = 0; j < leftTree.size(); j++){
                for(int k = 0; k < rightTree.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}