// Moris solution
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        TreeNode prev = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                ret.add(cur.val);
                cur = cur.right;
            }else{
                prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    ret.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ret;
    }
}