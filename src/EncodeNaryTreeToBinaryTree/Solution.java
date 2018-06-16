/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        HashMap<Node, TreeNode> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        hm.put(root, new TreeNode(root.val));
        while(!q.isEmpty()){
            Node node = q.poll();
            TreeNode target = hm.get(node);
            if(node.children.size() > 0){
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    hm.put(child, new TreeNode(child.val));
                    if(i == 0){
                        target.right = hm.get(child);
                        target = target.right;
                    }else{
                        target.left = hm.get(child);
                        target = target.left;
                    }
                    q.add(child);
                }
            }
        }
        return hm.get(root);
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        HashMap<TreeNode, Node> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        hm.put(root, new Node(root.val));
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            Node target = hm.get(node);
            target.children = new ArrayList<>();
            node = node.right;
            while(node != null){
                q.add(node);
                hm.put(node, new Node(node.val));
                target.children.add(hm.get(node));
                node = node.left;
            }
        }
        return hm.get(root);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));