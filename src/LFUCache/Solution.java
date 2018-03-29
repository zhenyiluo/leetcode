class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> hm;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        hm = new HashMap<>();
        hm.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key)){
            return -1;
        }
        increaseCount(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap <= 0) return;
        if(vals.containsKey(key)){
            vals.put(key, value);
            increaseCount(key);
            return;
        }
        if(vals.size() >= cap){
            int evict = hm.get(min).iterator().next();
            counts.remove(evict);
            vals.remove(evict);
            hm.get(min).remove(evict);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        hm.get(1).add(key);
    }

    private void increaseCount(int key){
        int count = counts.get(key);
        counts.put(key, count + 1);
        hm.get(count).remove(key);
        if(count == min && hm.get(count).size() == 0){
            min ++;
        }
        if(!hm.containsKey(count+1)){
            hm.put(count+1, new LinkedHashSet<>());
        }
        hm.get(count+1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */