class RandomizedSet {
    HashMap<Integer, Integer> hm;
    ArrayList<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
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
        int index = hm.get(val);
        if(index != list.size() -1){
            list.set(index, list.get(list.size() -1));
            hm.put(list.get(list.size() -1), index);
        }
        hm.remove(val);
        list.remove(list.size() -1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */