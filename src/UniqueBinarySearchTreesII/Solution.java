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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTreesFromRange(1, n);
    }
    
    private List<TreeNode> generateTreesFromRange(int start, int end){
        List<TreeNode> ret = new LinkedList<TreeNode>();
        if(start > end){
            ret.add(null);
            return ret;
        }
        
        for(int rootNum = start; rootNum <= end; rootNum++){
            List<TreeNode> leftList = generateTreesFromRange(start, rootNum -1);
            List<TreeNode> rightList = generateTreesFromRange(rootNum + 1, end);
            for(TreeNode left : leftList){
                for(TreeNode right: rightList){
                    TreeNode root = new TreeNode(rootNum);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}