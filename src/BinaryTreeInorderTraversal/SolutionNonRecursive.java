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
    Stack<TreeNode> st = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        putAll(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            ret.add(node.val);
            putAll(node.right);
        }
        return ret;
    }

    private void putAll(TreeNode node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }

}