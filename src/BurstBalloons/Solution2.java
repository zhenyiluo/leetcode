class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] val = new int[n+2];
        val[0] = 1;
        val[n+1] = 1;
        for(int i = 0; i < n; i++){
            val[i+1] = nums[i];
        }

        for(int len = 1; len <= n; len++){
            for(int i = 1; i + len -1 <= n; i++){
                int j = i + len - 1;
                int max = 0;
                for(int k = i; k <= j; k++){
                    int tmp = dp[i][k-1] + dp[k+1][j];
                    tmp += val[i-1] * val[k] * val[j+1];
                    max = Math.max(tmp, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}