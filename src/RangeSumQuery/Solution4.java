class NumArray {
    SegmentTreeNode root;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        root = buildTree(nums, 0, nums.length -1);
    }

    public void update(int i, int val) {
        if(nums[i] == val) return;
        nums[i] = val;
        update(root, i, val);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end){
            node.val = nums[start];
        }else{
            int mid = start + (end - start) /2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.val = node.left.val + node.right.val;
        }
        return node;
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
        if(i > j) return 0;
        if(i == j) return nums[i];
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
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */