class Solution {
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i > 0 && s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int l = 2; l <= n; l ++){
            for(int i = 0; i + l <= n; i++){
                int j = i + l - 1;
                dp[i][j] = l;
                for(int k = i; k < j; k++){
                    int tmp = dp[i][k] + dp[k+1][j];
                    if(s.charAt(k) == s.charAt(j)) tmp --;
                    dp[i][j] = Math.min(dp[i][j], tmp);
                }
            }
        }
        return dp[0][n-1];
    }
}