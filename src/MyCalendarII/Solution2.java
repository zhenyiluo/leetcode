class MyCalendarTwo {
    SegmentTreeNode root;
    public MyCalendarTwo() {
        root = new SegmentTreeNode(0, (int) Math.pow(10, 9), 0);
    }

    public boolean book(int start, int end) {
        int k = query(root, start, end-1);
        if(k >= 2) return false;
        update(root, start, end -1, 1);
        return true;
    }

    private int query(SegmentTreeNode node, int start, int end){
        normalize(node);
        if(node == null || start > end || end < node.start || start > node.end) return 0;

        if(start <= node.start && end >= node.end){
            return node.val;
        }

        return Math.max(query(node.left, start, end), query(node.right, start, end));
    }

    private void update(SegmentTreeNode node, int start, int end, int val){
        normalize(node);
        if(node == null || start > end || end < node.start || start > node.end) return;

        if(start <= node.start && end >= node.end){
            node.lazy = val;
            normalize(node);
            return;
        }

        update(node.left, start, end, val);
        update(node.right, start, end, val);

        node.val = Math.max(node.left.val, node.right.val);
    }

    private void normalize(SegmentTreeNode node){
        if(node.lazy > 0) node.val += node.lazy;
        if(node.start < node.end){
            if(node.left == null || node.right == null){
                int mid = node.start + (node.end - node.start) / 2;
                node.left = new SegmentTreeNode(node.start, mid, node.val);
                node.right = new SegmentTreeNode(mid + 1, node.end, node.val);
            }else{
                node.left.lazy += node.lazy;
                node.right.lazy += node.lazy;
            }
        }

        node.lazy = 0;
    }
}

class SegmentTreeNode{
    SegmentTreeNode left;
    SegmentTreeNode right;
    int start;
    int end;
    int val;
    int lazy;
    public SegmentTreeNode(int start, int end, int val){
        this.start = start;
        this.end = end;
        lazy = 0;
        this.val = val;
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */