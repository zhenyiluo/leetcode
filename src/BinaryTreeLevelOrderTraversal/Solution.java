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
        Queue<Integer> qLevel = new LinkedList<>();
        qNode.add(root);
        qLevel.add(0);
        int curLevel = -1;
        while(!qNode.isEmpty()){
            int level = qLevel.poll();
            TreeNode node = qNode.poll();
            if(level != curLevel){
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                ret.add(list);
                curLevel = level;
            }else{
                List<Integer> list = ret.get(ret.size() -1);
                list.add(node.val);
            }
            if(node.left != null){
                qNode.add(node.left);
                qLevel.add(curLevel+1);
            }
            if(node.right != null){
                qNode.add(node.right);
                qLevel.add(curLevel +1);
            }
        }
        return ret;
    }
}