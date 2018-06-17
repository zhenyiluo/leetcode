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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(Node root, StringBuilder sb){
        sb.append(root.val);
        sb.append(" ");
        for(Node node: root.children){
            dfs(node, sb);
        }
        sb.append(")");
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public Node deserialize(String data) {
        if(data == null || data.length() == 0 || index >= data.length()) return null;
        int end = index;
        while(data.charAt(end) >= '0' && data.charAt(end) <= '9'){
            end++;
        }
        Node node = new Node(Integer.valueOf(data.substring(index, end)));
        node.children = new ArrayList<>();
        index = end+1;
        while(data.charAt(index) != ')'){
            node.children.add(deserialize(data));
        }
        index ++;
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));