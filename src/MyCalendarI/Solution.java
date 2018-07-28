class MyCalendar {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() {
        tm = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer left = tm.floorKey(end - 1);
        if(left == null || tm.get(left) <= start){
            tm.put(start, end);
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */