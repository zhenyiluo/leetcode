/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionNonRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return ret;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            ret.add(0, node.val);
            if(node.left != null) st.push(node.left);
            if(node.right != null) st.push(node.right);
        }
        return ret;
    }

}