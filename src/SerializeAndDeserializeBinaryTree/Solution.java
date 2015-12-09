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
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append("null,");
            }else{
                sb.append(node.val + ",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0) return null;
        String[] ss=data.split(",");
        Queue<TreeNode> q= new LinkedList<>();
        int i=0;
        TreeNode root= new TreeNode(Integer.valueOf(ss[0]));
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(++i<ss.length&&!ss[i].equals("null")){
                    TreeNode left=new TreeNode(Integer.valueOf(ss[i]));
                    node.left=left;
                    q.add(left);
            }
            if(++i<ss.length&&!ss[i].equals("null")){
                    TreeNode right=new TreeNode(Integer.valueOf(ss[i]));
                    node.right=right;
                    q.add(right);
            }
        }
            return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));