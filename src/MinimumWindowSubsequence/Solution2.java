class Solution {
    public String minWindow(String S, String T) {
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <=n; i++){
            dp[0][i] = i + 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        String ans = "";
        int min = Integer.MAX_VALUE;
        for(int j = 1; j <= n; j++){
            if(dp[m][j] != 0){
                if(j - dp[m][j] + 1< min){
                    min = j - dp[m][j] + 1;
                    ans = S.substring(dp[m][j] -1 , j);
                }
            }
        }
        return ans;
    }
}