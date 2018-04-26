class RangeModule {
    TreeMap<Integer, Integer> tm;
    public RangeModule() {
        tm = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if(left >= right) return;
        Integer start = tm.floorKey(left);
        if(start == null) start = tm.ceilingKey(left);
        while(start != null && start <= right){
            int end = tm.get(start);
            if(end >= left){
                tm.remove(start);
                if(start < left) left = start;
                if(end > right) right = end;
            }
            start = tm.ceilingKey(end);
        }
        tm.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        if(left >= right) return true;
        Integer start = tm.floorKey(left);
        if(start == null){
            return false;
        }
        return tm.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if(left >= right) return;
        Integer start = tm.floorKey(left);
        if(start == null) start = tm.ceilingKey(left);
        while(start != null && start < right){
            int end = tm.get(start);
            if(end >= left){
                tm.remove(start);
                if(start < left) tm.put(start, left);
                if(end > right) tm.put(right, end);
            }
            start = tm.ceilingKey(end);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */