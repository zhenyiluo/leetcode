class Solution {
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int l = 2; l <= n; l++){
            for(int i = 0; i + l <= n; i++){
                int j = i + l -1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    if(s.charAt(k) == s.charAt(j)){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] -1);
                    }else{
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}