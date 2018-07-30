class MyCalendarThree {
    SegmentTreeNode root;
    int max = 0;

    public MyCalendarThree() {
        root = new SegmentTreeNode(0, (int) Math.pow(10, 9), 0);
    }

    public int book(int start, int end) {
        update(root, start, end -1, 1);
        max = Math.max(max, query(root, start, end-1));
        return max;
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
        this.val = val;
        lazy = 0;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */