class NumArray {
    int len;
    int[] tree;
    int[] vals;
    public NumArray(int[] nums) {
        len = nums.length;
        tree = new int[len+1];
        vals = new int[len];
        for(int i = 0; i < len; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - vals[i];
        if(diff == 0) return;
        vals[i] = val;
        for(int j = i+1; j < tree.length; j += j & (-j)){
            tree[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i-1);
    }

    private int query(int i){
        int ret = 0;
        for(int j = i+1; j > 0; j -= j & (-j)){
            ret += tree[j];
        }
        return ret;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */