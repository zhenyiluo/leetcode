class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum < S) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for(int num: nums){
            int[] next = new int[2* sum + 1];
            for(int i = 0; i <= 2 * sum; i++){
                if(dp[i] != 0){
                    next[i+ num] += dp[i];
                    next[i- num] += dp[i];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }
}