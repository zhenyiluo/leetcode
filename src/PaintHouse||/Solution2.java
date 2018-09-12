class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int l = 0; l < n; l++){
                    if(l != j){
                        if(dp[i-1][l] + costs[i][j] < dp[i][j]){
                            dp[i][j] = dp[i-1][l] + costs[i][j];
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[m-1][i]);
        }
        return ans;
    }
}