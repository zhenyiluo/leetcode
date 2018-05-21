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
        int ans = node.val;
        remove(node);
        addToHead(node);
        return ans;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
            return;
        }
        if(hm.size() == capacity){
            hm.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        hm.put(key, node);
        addToHead(node);
    }
}

class Node{
    Node prev;
    Node next;
    int key;
    int val;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */