class NumArray {
    int[] tree;
    int[] vals;
    public NumArray(int[] nums) {
        int n = nums.length;
        tree = new int[n+1];
        vals = new int[n];
        for(int i = 0; i < n; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int cur = vals[i];
        int diff = val - cur;
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
        int sum = 0;
        for(int j = i+1; j > 0; j -= j & (-j)){
            sum += tree[j];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */