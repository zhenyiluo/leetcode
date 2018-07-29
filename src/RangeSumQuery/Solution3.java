class NumArray {
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode node, int i, int val){
        if(node.start == node.end){
            node.val = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if(i <= mid){
            update(node.left, i, val);
        }else{
            update(node.right, i, val);
        }
        node.val = node.left.val + node.right.val;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode node, int start, int end){
        if(node.start == start && node.end == end) return node.val;
        int mid = node.start + (node.end - node.start) / 2;
        if(end <= mid){
            return sumRange(node.left, start, end);
        }else if(start > mid){
            return sumRange(node.right, start, end);
        }else{
            return sumRange(node.left, start, mid) + sumRange(node.right, mid+1, end);
        }
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start == end){
            root.val = nums[start];
        }else{
            int mid = start + (end - start) / 2;
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid+1, end);
            root.val = root.left.val + root.right.val;
        }
        return root;
    }
}

class SegmentTreeNode{
    SegmentTreeNode left;
    SegmentTreeNode right;
    int start;
    int end;
    int val;
    public SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        val = 0;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */