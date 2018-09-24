class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P+1][G+1];
        int ans = 0;
        int MOD = (int)1e9 + 7;
        dp[0][0] = 1;
        for(int k = 0; k < group.length; k++){
            int g = group[k];
            int p = profit[k];
            for(int i = P; i >= 0; i--){
                for(int j = G - g; j >= 0; j--){
                    dp[Math.min(i+p, P)][j + g] = (dp[Math.min(i+p, P)][j + g] + dp[i][j]) % MOD;
                }
            }
        }
        for(int val: dp[P]){
            ans = (ans + val) % MOD;
        }
        return ans;
    }
}