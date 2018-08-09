class TwoSum {
    HashMap<Integer, Integer> hm;
    /** Initialize your data structure here. */
    public TwoSum() {
        hm = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        hm.put(number, hm.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key: hm.keySet()){
            if(value - key == key){
                if(hm.get(key) > 1){
                    return true;
                }
            }else{
                if(hm.containsKey(value - key)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */