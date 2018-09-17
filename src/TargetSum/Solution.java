class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum < S) return 0;
        int[][] dp = new int[2][2 * sum + 1];
        dp[0][sum] = 1;
        int idx = 0;
        for(int num: nums){
            dp[(idx+1) % 2] = new int[2* sum + 1];
            for(int i = 2 * sum; i >= num; i--){
                dp[(idx+1) % 2][i] += dp[idx % 2][i - num];
            }
            for(int i = 0; i + num <= 2 * sum; i++){
                dp[(idx+1) % 2][i] += dp[idx % 2][i + num];
            }
            idx++;
        }
        return dp[n % 2][sum + S];
    }
}