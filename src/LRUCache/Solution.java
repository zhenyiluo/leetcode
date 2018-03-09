class LRUCache {
    HashMap<Integer, Node> hm;
    int capacity;
    int count;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        hm = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            Node cur = hm.get(key);
            remove(cur);
            addToHead(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node cur = hm.get(key);
            remove(cur);
            cur.val = value;
            addToHead(cur);
        }else{
            Node cur = new Node(key, value);
            hm.put(key, cur);
            if(count < capacity){
                count ++;
            }else{
                hm.remove(tail.prev.key);
                remove(tail.prev);
            }
            addToHead(cur);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}

class Node{
    int key;
    int val;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    Node prev;
    Node next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */