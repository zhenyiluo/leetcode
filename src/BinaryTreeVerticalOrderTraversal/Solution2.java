/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int min = 0;
        int max = 0;
        q.add(root);
        cols.add(0);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int col = cols.poll();
            if(!hm.containsKey(col)){
                hm.put(col, new ArrayList<>());
            }
            hm.get(col).add(node.val);
            min = Math.min(min, col);
            max = Math.max(max, col);
            if(node.left != null){
                q.add(node.left);
                cols.add(col - 1);
            }
            if(node.right != null){
                q.add(node.right);
                cols.add(col + 1);
            }
        }
        for(int i = min; i <= max; i++){
            ret.add(hm.get(i));
        }
        return ret;
    }
}