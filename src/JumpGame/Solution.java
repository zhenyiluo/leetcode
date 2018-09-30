class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i = 0; i < n-1; i++){
            if(dp[i]){
                for(int j = i+1; j <= Math.min(n-1, i + nums[i]); j++){
                    dp[j] = true;
                }
            }
        }
        return dp[n-1];
    }
}