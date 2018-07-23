class RangeModule {
    TreeMap<Integer, Integer> tm;
    public RangeModule() {
        tm = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer start = tm.floorKey(left);
        Integer end = tm.floorKey(right);
        if(end != null && tm.get(end) > right){
            right = tm.get(end);
        }

        if(start != null && tm.get(start) >= left){
            left = start;
        }

        tm.put(left, right);
        tm.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = tm.floorKey(left);
        if(start == null) return false;
        return tm.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = tm.floorKey(left);
        Integer end = tm.floorKey(right);
        if(end != null && tm.get(end) > right){
            tm.put(right, tm.get(end));
        }

        if(start != null && tm.get(start) > left){
            tm.put(start, left);
        }

        tm.subMap(left, true, right, false).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */