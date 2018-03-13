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
    List<Integer> list = new ArrayList<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inOrderTraversal(root);
        int start = 0;
        int end = list.size() - k;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(target - list.get(mid) > list.get(mid + k) - target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = start; i < start + k; i++){
            ret.add(list.get(i));
        }
        return ret;
    }

    private void inOrderTraversal(TreeNode node){
        if(node == null) return;
        inOrderTraversal(node.left);
        list.add(node.val);
        inOrderTraversal(node.right);
    }
}