class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = costs[0][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + costs[i][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[m-1][j]);
        }
        return ans;
    }
}