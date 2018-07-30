class MyCalendarThree {
    TreeMap<Integer, Integer> tm;
    public MyCalendarThree() {
        tm = new TreeMap<>();
    }

    public int book(int start, int end) {
        tm.put(start, tm.getOrDefault(start, 0) + 1);
        tm.put(end, tm.getOrDefault(end, 0) -1);
        int max = 0;
        int cnt = 0;
        for(int val : tm.values()){
            cnt += val;
            max = Math.max(cnt, max);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */