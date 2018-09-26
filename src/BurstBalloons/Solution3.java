class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] vals = new int[n+2];
        vals[0] = 1;
        vals[n+1] = 1;
        for(int i = 0; i < n; i++){
            vals[i+1] = nums[i];
        }
        for(int l = 1; l <= n; l++){
            for(int i = 1; i + l <= n+1; i++){
                int j = i + l -1;
                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + vals[i-1] * vals[k] * vals[j +1]);
                }
            }
        }

        return dp[1][n];
    }
}