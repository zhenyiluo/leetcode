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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(cnt % 2 == 0){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            ret.add(list);
            cnt ++;
        }
        return ret;
    }
}