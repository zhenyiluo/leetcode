/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public int closestValue(TreeNode root, double target) {
        double minDif = Double.MAX_VALUE;
        int closest = 0;
        
        TreeNode cur = root;
        while(cur != null){
            double dif = Math.abs(target - cur.val);
            if(dif < minDif){
                minDif = dif;
                closest = cur.val;
            }
            
            if(target < cur.val){
                cur = cur.left;
            }else if (target > cur.val){
                cur = cur.right;
            }else{
                return closest;
            }
        }
        
        return closest;
    }
    
}