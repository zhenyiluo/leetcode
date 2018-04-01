class Solution3 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] local = new int[2];
        int[] global = new int[2];
        local[0] = nums[0];
        global[0] = nums[0];
        for(int i = 1; i < n; i++){
            local[i%2] = Math.max(nums[i], local[(i-1)%2] + nums[i]);
            global[i%2] = Math.max(global[(i-1)%2], local[i%2]);
        }
        return global[(n-1)%2];
    }
}