class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> hm;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        hm = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;
        hm.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int idx = hm.get(val);
        if(idx != list.size() -1){
            int lastVal = list.get(list.size() -1);
            list.set(idx, lastVal);
            hm.put(lastVal, idx);
        }
        list.remove(list.size() -1);
        hm.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */