class LRUCache {
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> hm;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }

    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        }else{
            if(hm.size() == capacity){
                hm.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key, value);
            hm.put(key, node);
            addToHead(node);
        }
    }

    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */