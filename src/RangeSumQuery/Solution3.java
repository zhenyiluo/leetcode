class NumArray {
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length -1);
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
        if(mid >= i){
            update(node.left, i, val);
        }else{
            update(node.right, i, val);
        }
        node.val = node.left.val + node.right.val;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode node, int i, int j){
        if(node.start == i && node.end == j) return node.val;
        int mid = node.start + (node.end - node.start) / 2;
        if(mid >= j){
            return sumRange(node.left, i, j);
        }else if(mid < i){
            return sumRange(node.right, i, j);
        }else{
            return sumRange(node.left, i, mid) + sumRange(node.right, mid+1, j);
        }
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start == end){
            root.val = nums[start];
        }else{
            int mid = start + (end - start)/2;
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid+1, end);
            root.val = root.left.val + root.right.val;
        }
        return root;
    }
}

class SegmentTreeNode{
    int start;
    int end;
    int val;
    SegmentTreeNode left;
    SegmentTreeNode right;
    public SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */