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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.val >= target){
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
            }
            if(pred.isEmpty()){
                ret.add(getSuccessor(succ));
            }else if(succ.isEmpty()){
                ret.add(getPredecessor(pred));
            }else if(Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)){
                ret.add(getPredecessor(pred));
            }else{
                ret.add(getSuccessor(succ));
            }
            k--;
        }
        return ret;
    }

    private int getPredecessor(Stack<TreeNode> st){
        TreeNode pop = st.pop();
        TreeNode cur = pop.left;
        while(cur != null){
            st.push(cur);
            cur = cur.right;
        }
        return pop.val;
    }

    private int getSuccessor(Stack<TreeNode> st){
        TreeNode pop = st.pop();
        TreeNode cur = pop.right;
        while(cur != null){
            st.push(cur);
            cur = cur.left;
        }
        return pop.val;
    }
}