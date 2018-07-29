class MyCalendarTwo {
    TreeMap<Integer, Integer> tm;
    public MyCalendarTwo() {
        tm = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        tm.put(start, tm.getOrDefault(start, 0) + 1);
        tm.put(end, tm.getOrDefault(end, 0) -1);
        int cnt = 0;
        for(int val: tm.values()){
            cnt += val;
            if(cnt >= 3){
                tm.put(start, tm.get(start) -1);
                tm.put(end, tm.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */