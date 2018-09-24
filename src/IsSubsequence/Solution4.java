class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for(int j = 0; j <= n; j++){
            dp[0][j] = true;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i][j-1];
                if(s.charAt(i-1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i][j] || dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}