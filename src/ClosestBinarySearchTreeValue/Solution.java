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
    public int closestValue(TreeNode root, double target) {
        double[] minDif = new double[1];
        int[] closest = new int[1];
        minDif[0] = Double.MAX_VALUE;
        
        helper(root, minDif, closest, target);
        
        return closest[0];
    }
    
    private void helper(TreeNode root, double[] minDif, int[] closest, double target){
        if(root == null){
            return;
        }
        double dif = Math.abs(target - root.val);
        if(dif < minDif[0]){
            minDif[0] = dif;
            closest[0] = root.val;
        }
        
        if(target < root.val){
            helper(root.left, minDif, closest, target);
        }else{
            helper(root.right, minDif, closest, target);
        }
    }
}