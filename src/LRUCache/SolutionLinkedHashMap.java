class LRUCache {
    private LinkedHashMap<Integer, Integer> hm;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        hm = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return hm.get(key) == null ? -1 : hm.get(key);
    }

    public void put(int key, int value) {
        hm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */