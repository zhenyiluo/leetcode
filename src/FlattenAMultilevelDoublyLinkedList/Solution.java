/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    Node prev = null;
    public Node flatten(Node head) {
        if(head == null) return null;
        Node retNode = head;
        dfs(head);
        return retNode;
    }

    private void dfs(Node node){
        if(prev != null){
            prev.next = node;
            node.prev = prev;
        }
        prev = node;
        Node child = node.child;
        node.child = null;
        Node next = node.next;
        if(child != null){
            dfs(child);
        }

        if(next != null){
            dfs(next);
        }
    }
}