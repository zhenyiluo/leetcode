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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> qNode = new LinkedList<>();
        qNode.add(root);
        while(!qNode.isEmpty()){
            int size = qNode.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = qNode.poll();
                if(node.left != null) qNode.add(node.left);
                if(node.right != null) qNode.add(node.right);
                list.add(node.val);
            }
            ret.add(list);
        }
        return ret;
    }
}