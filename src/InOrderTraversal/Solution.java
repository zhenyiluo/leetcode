// Moris Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        TreeNode cur = root;
        TreeNode prev = null;
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
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = cur;
                    ret.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ret;
    }
}


