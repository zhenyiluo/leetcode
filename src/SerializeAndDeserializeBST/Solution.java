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
        if(s.length() > 1){
            s = s.substring(0, s.length() -1);
        }
        return s;
    }

    private void dfs(TreeNode node, StringBuilder sb){
        if(node == null) {
            return;
        }
        sb.append(node.val);
        sb.append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] dataArr = data.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for(String s : dataArr){
            list.add(Integer.valueOf(s));
        }
        return dfs2(list);
    }

    private TreeNode dfs2(ArrayList<Integer> list){
        TreeNode root = null;
        if(list.size() == 0){
            return root;
        }
        root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < root.val) {
                leftList.add(list.get(i));
            }
            if(list.get(i) > root.val) {
                rightList.add(list.get(i));
            }
        }
        root.left = dfs2(leftList);
        root.right = dfs2(rightList);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));