class MyCalendarThree {
    STN root;
    int max;
    public MyCalendarThree() {
        root = new STN(0, (int) Math.pow(10, 9), 0);
        max = 0;
    }

    public int book(int start, int end) {
        update(root, start, end -1);
        max = Math.max(max, query(root, start, end -1));
        return max;
    }

    private int query(STN node, int start, int end){
        load(node);
        if(start > end || node.end < start || node.start > end) return 0;
        if(start <= node.start && end >= node.end){
            return node.val;
        }
        return Math.max(query(node.left, start, end), query(node.right, start, end));
    }

    private void update(STN node, int start, int end){
        load(node);
        if(start > end || node.end < start || node.start > end) return;
        if(start<= node.start && end >= node.end){
            node.lazy += 1;
            load(node);
            return;
        }
        update(node.left, start, end);
        update(node.right, start, end);
        node.val = Math.max(node.left.val, node.right.val);
    }

    private void load(STN node){
        node.val += node.lazy;
        if(node.start < node.end){
            if(node.left == null || node.right == null){
                int mid = node.start + (node.end - node.start) /2;
                node.left = new STN(node.start, mid, node.val);
                node.right = new STN(mid + 1, node.end, node.val);
            }else{
                node.left.lazy += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        node.lazy = 0;
    }
}

class STN{
    STN left;
    STN right;
    int start;
    int end;
    int val;
    int lazy;
    public STN(int start, int end, int val){
        this.start = start;
        this.end = end;
        this.val = val;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */