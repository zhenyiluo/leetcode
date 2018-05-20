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
        String s = sb.toString();
        s = s.substring(0, s.length() -1);
        return s;
    }

    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        ArrayList<String> list = new ArrayList<>();
        for(String s : arr){
            list.add(s);
        }
        return dfs2(list);
    }

    private TreeNode dfs2(ArrayList<String> list){
        TreeNode root = null;
        if(list.get(0).equals("null")){
            list.remove(0);
            return root;
        }
        root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = dfs2(list);
        root.right = dfs2(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));