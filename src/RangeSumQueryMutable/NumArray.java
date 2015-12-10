public class NumArray {
    int[] tree;
    int[] vals;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        tree = new int[len+1];
        vals = new int[len];
        for(int i = 0; i < len; i++){
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        if(tree == null){
            return;
        }
        int dif = val - vals[i];
        if(dif == 0){
            return;
        }
        vals[i] = val;
        for(int j = i+1; j < tree.length; j += j & (-j)){
            tree[j] += dif;
        }
    }

    public int sumRange(int i, int j) {
        if(tree == null){
            return 0;
        }
        return query(j + 1) - query(i);
    }
    
    private int query(int i){
        int ret = 0;
        for(int j = i; j > 0; j -= j & (-j)){
            ret += tree[j];
        }
        return ret;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);