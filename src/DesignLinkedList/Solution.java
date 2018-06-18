
class MyLinkedList {
    Node head;
    Node tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0) return -1;
        Node cur = head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node insertNode = new Node(val);
        insertNode.next = head.next;
        head.next.prev = insertNode;
        head.next = insertNode;
        insertNode.prev = head;
        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node insertNode = new Node(val);
        insertNode.prev = tail.prev;
        tail.prev.next = insertNode;
        tail.prev = insertNode;
        insertNode.next = tail;
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        Node prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
        node.prev = prev;
        size ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;
        Node prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        prev.next.next.prev = prev;
        prev.next = prev.next.next;
        size --;
    }
}

class Node {
    Node prev;
    Node next;
    int val;
    public Node(int val){
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */