/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        dfs(root);
        if(head != null && prev != null){
            head.left = prev;
            prev.right = head;
        }
        return head;
    }

    private void dfs(Node node){
        if(node == null) return;
        dfs(node.left);

        if(prev == null){
            head = node;
        }else{
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        dfs(node.right);
    }
}