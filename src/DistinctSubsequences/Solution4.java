class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return 0;
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i+1][j+1] = dp[i][j+1];
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] += dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}