class Solution {
    int[] tree;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ret;
        }

        int min = Integer.MAX_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] - min;
            max = Math.max(max, nums[i]);
        }

        tree = new int[max+1];

        for(int i = nums.length -1; i >= 0; i--){
            ret.add(0, sum(nums[i]-1));
            update(nums[i]);
        }
        return ret;
    }
    private int sum(int i){
        return query(i + 1);
    }

    private int query(int i){
        int ret = 0;
        for(int j = i; j > 0; j -= j & (-j)){
            ret += tree[j];
        }
        return ret;
    }

    private void update(int i){
        for(int j = i + 1; j < tree.length; j += j & (-j)){
            tree[j] ++;
        }
    }
}