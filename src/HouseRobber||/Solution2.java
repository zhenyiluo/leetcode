class Solution2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length -1));
    }

    private int rob(int[] nums, int left, int right) {
        int[] dp = new int[3];
        for(int i = left; i <= right; i ++){
            if(i == left){
                dp[i%3] = nums[i];
            }else if(i == left + 1){
                dp[i%3] = Math.max(nums[i], nums[i-1]);
            }else{
                dp[i%3] = Math.max(dp[(i-2)%3] + nums[i], dp[(i-1)%3]);
            }
        }
        return dp[right %3];
    }
}
