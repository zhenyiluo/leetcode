//O(max(logN, k))
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null){
            return new LinkedList<Integer>();
        }

        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> suc = new Stack<>();
        List<Integer> ret = new LinkedList<>();
        init(pred, suc, target, root);
        while(k > 0){
            if(suc.isEmpty() || !pred.isEmpty() && target - pred.peek().val < suc.peek().val - target){
                ret.add(pred.peek().val);
                nextPred(pred);
            }else{
                ret.add(suc.peek().val);
                nextSuc(suc);
            }

            k--;
        }

        return ret;
    }

    private void init(Stack<TreeNode> pred, Stack<TreeNode> suc, double target, TreeNode root){
        while(root != null){
            if(root.val < target){
                pred.push(root);
                root = root.right;
            }else{
                suc.push(root);
                root = root.left;
            }
        }
    }

    private void nextPred(Stack<TreeNode> st){
        TreeNode node = st.pop();
        pushRightChildren(node.left, st);
    }

    private void nextSuc(Stack<TreeNode> st){
        TreeNode node = st.pop();
        pushLeftChildren(node.right, st);
    }

    private void pushRightChildren(TreeNode node, Stack<TreeNode> st){
        while(node != null){
            st.push(node);
            node = node.right;
        }
    }

    private void pushLeftChildren(TreeNode node, Stack<TreeNode> st){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
}