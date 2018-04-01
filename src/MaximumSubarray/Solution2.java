class Solution2 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[2];
        dp[0] = nums[0];
        int ret = dp[0];
        for(int i = 1; i < n; i++){
            dp[i%2] = Math.max(dp[(i-1)%2] + nums[i], nums[i]);
            ret = Math.max(ret, dp[i%2]);
        }
        return ret;
    }
}