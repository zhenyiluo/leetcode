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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        int curLevel = -1;
        Queue<Integer> qLevel = new LinkedList<>();
        Queue<TreeNode> qNode = new LinkedList<>();
        qNode.add(root);
        qLevel.add(0);
        while(!qNode.isEmpty()){
            int level = qLevel.poll();
            TreeNode node = qNode.poll();
            if(level != curLevel){
                curLevel = level;
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                ret.add(0, list);
            }else{
                List<Integer> list = ret.get(0);
                list.add(node.val);
            }
            if(node.left != null){
                qNode.add(node.left);
                qLevel.add(level + 1);
            }
            if(node.right != null){
                qNode.add(node.right);
                qLevel.add(level+1);
            }
        }
        return ret;
    }
}