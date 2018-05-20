/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString().substring(0, sb.length()-1);
    }

    private void dfs(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        int[] index = new int[]{0};
        return dfs2(dataArr, index);
    }

    private TreeNode dfs2(String[] dataArr, int[] index){
        if(dataArr[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(dataArr[index[0]++]));
        node.left = dfs2(dataArr, index);
        node.right = dfs2(dataArr, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));