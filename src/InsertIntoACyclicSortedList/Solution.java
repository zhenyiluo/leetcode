/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node();
        node.val = insertVal;
        if(head == null){
            node.next = node;
            return node;
        }

        Node prev = head;
        Node cur = prev.next;
        boolean changed = false;
        while(true){
            if((prev.val <= insertVal && cur.val >= insertVal)
                    || (prev.val > cur.val && (insertVal >= prev.val || insertVal <= cur.val))
                    ){
                prev.next = node;
                node.next = cur;
                changed = true;
                break;
            }
            prev = prev.next;
            cur = cur.next;
            if(prev == head) break;
        }

        if(!changed){
            prev.next = node;
            node.next = cur;
        }

        return head;
    }
}