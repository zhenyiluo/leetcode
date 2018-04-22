/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution4 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.val > target){
                succ.push(cur);
                cur = cur.left;
            }else{
                pred.push(cur);
                cur = cur.right;
            }
        }
        List<Integer> ret = new ArrayList<>();
        while(k > 0){
            if(pred.isEmpty() && succ.isEmpty()){
                break;
            }else if(pred.isEmpty()){
                ret.add(getSucc(succ));
            }else if(succ.isEmpty()){
                ret.add(getPred(pred));
            }else if(Math.abs(pred.peek().val - target) < Math.abs(succ.peek().val - target)){
                ret.add(getPred(pred));
            }else{
                ret.add(getSucc(succ));
            }
            k--;
        }
        return ret;
    }

    private int getSucc(Stack<TreeNode> succ){
        TreeNode ret = succ.pop();
        TreeNode cur = ret.right;
        while(cur != null){
            succ.push(cur);
            cur = cur.left;
        }
        return ret.val;
    }

    private int getPred(Stack<TreeNode> pred){
        TreeNode ret = pred.pop();
        TreeNode cur = ret.left;
        while(cur != null){
            pred.push(cur);
            cur = cur.right;
        }
        return ret.val;
    }
}