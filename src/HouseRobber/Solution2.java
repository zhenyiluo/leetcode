class Solution2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[3];
        for(int i = 0; i < nums.length; i ++){
            if(i == 0){
                dp[i%3] = nums[i];
            }else if(i == 1){
                dp[i%3] = Math.max(nums[i], nums[i-1]);
            }else{
                dp[i%3] = Math.max(dp[(i-2)%3] + nums[i], dp[(i-1)%3]);
            }
        }
        return dp[(nums.length -1) %3];
    }
}